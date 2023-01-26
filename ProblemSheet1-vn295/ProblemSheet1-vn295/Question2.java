public class Question2 {
    public static void main(String[] args){
        StringRepeater s = new StringRepeater();
        doNaiveMeasuring(s, "hello", 1);
        doNaiveMeasuring(s, "hello", 100);
        doNaiveMeasuring(s, "hello", 1000);
        doNaiveMeasuring(s, "hello", 10000);

        System.out.println("");
        System.out.println("");

        doAccurateMeasuring(s, "hello", 1, 100000);
        doAccurateMeasuring(s, "hello", 100, 100000);
        doAccurateMeasuring(s, "hello", 1000, 100000);
        doAccurateMeasuring(s, "hello", 10000, 100000);
    }

    public static void doNaiveMeasuring(StringRepeater s, String strInput, int n){
        double start = System.nanoTime();
        s.repeatString(strInput, n);
        double end = System.nanoTime();
        double elapsedTime = (end - start) * 0.000000001;
        System.out.println("T(" + n + ") = " + elapsedTime + " seconds");
    }

    public static void doAccurateMeasuring(StringRepeater s, String strInput, int n, int repeats){
        double start = System.nanoTime();
        for (int i = 0; i < repeats; i++){
            s.optimisedRepeatString(strInput, n);
        }
        double end = System.nanoTime();
        double elapsedTime = ((end-start)/repeats) * 0.000000001;
        System.out.println("T(" + n + ") = " + elapsedTime + " seconds");
    }
}


