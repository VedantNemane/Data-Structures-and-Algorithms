public class Sorter {

    public static void selectionSort(Contact[] contacts) {
        // TODO Q2
        int n = contacts.length;
        for (int i = 0; i < n; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (contacts[j].compareTo(contacts[minIndex]) < 0){
                    minIndex = j;
                }
            }
            Contact temp = contacts[i];
            contacts[i] = contacts[minIndex];
            contacts[minIndex] = temp;
        }

    }

    public static void insertionSort(Contact[] contacts) {
        // TODO Q3
        if (contacts.length <= 1){
            System.out.println("\nCan't really sort a " + contacts.length + " element array now can I?\n");
            return;
        }
        for (int s = 2; s <= contacts.length; s++){
            Contact sortMe = contacts[s - 1];
            int i = s - 2;
            while ((i >= 0) && (sortMe.compareTo(contacts[i]) < 0)){
                contacts[i + 1] = contacts[i];
                i--;
            }
            contacts[i + 1] = sortMe;
        }
    }

    public static void quickSort(Contact[] contacts) {
        // TODO Q4
        quickSort2(contacts, 0, contacts.length-1);
    }

    public static void quickSort2(Contact[] contacts, int first, int last){
        if (last - first >= 1){
            int pivotIndex;
            pivotIndex = partition(contacts, first, last);
            quickSort2(contacts, first, pivotIndex-1);
            quickSort2(contacts, pivotIndex+1, last);
        }
    }

    public static int partition(Contact[] contacts, int low, int high){
        int pi = low;
        Contact pivot = contacts[low];
        do {
            while(low <= high && contacts[low].compareTo(pivot) <= 0) low++;
            while (contacts[high].compareTo(pivot) > 0) high--;
            if (low < high){
                Contact temp = contacts[low];
                contacts[low] = contacts[high];
                contacts[high] = temp;
            }
        }
        while(low < high);
        Contact temp = contacts[pi];
        contacts[pi] = contacts[high];
        contacts[high] = temp;
        pi = high;
        return pi;
    }

    public static void mergeSort(Contact[] contacts) {
        // TODO Q5
        mergeSort2(contacts, contacts.length);
    }

    public static void mergeSort2(Contact[] contacts, int n){
        if (n < 2){
            return;
        }
        int middle = n/2;
        Contact[] left = new Contact[middle];
        Contact[] right = new Contact[n - middle];

        for (int i = 0; i < middle; i++)
            left[i] = contacts[i];

        for (int i = middle; i < n; i++)
            right[i - middle] = contacts[i];

        mergeSort2(left, middle);
        mergeSort2(right, n - middle);

        merge(contacts, left, right, middle, n-middle);
    }

    public static void merge(Contact[] array, Contact[] low, Contact[] high, int l, int r){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l && j < r) {
            if (low[i].compareTo(high[j]) <= 0) {
                array[k] = low[i];
                i++;
            } else {
                array[k] = high[j];
                j++;
            }
            k++;
        }
        while (i < l){
            array[k] = low[i];
            k++;
            i++;
        }
        while (j < r){
            array[k] = high[j];
            k++;
            j++;
        }

    }
}
