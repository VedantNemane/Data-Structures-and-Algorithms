class DoublyLinkedList {
    private ListNode2 head = null;
    private ListNode2 tail = null;

    private int n = 0; // list size

	// TODO implement this...

    public void addFirst(Object o) {
        ListNode2 temp = head;
        head = new ListNode2(o, null, head);

        if (n == 0){
            tail = head;
        } else {
            head.next = temp;
            head.next.prev = head;
        }
        n++;
    }

    public void remove(int i) {

        if (i == 0){
            head = head.next;
            if (head != null){
                head.prev = null;
            }
            n--;
            return;
        }

        ListNode2 node = head;
        for (int j = 0; j < i - 1; j++){
            node = node.next;
        }

        if (node.next == null){
            tail = node;
        } else {
            if (node.next.next != null){
                node.next.next.prev = node;
                node.next = node.next.next;
            } else {
                node.next = null;
            }

        }

        n--;
    }

    public void insert(Object o, int i) {

        if (i == 0){
            addFirst(o);
            return;
        }

        ListNode2 temp = new ListNode2(o, null, null);
        ListNode2 node = head;

        for (int j = 0; j < i - 1; j++){
            node = node.next;
        }

        ListNode2 temp2 = node.next;
        node.next = temp;
        temp.next = temp2;
        temp.prev = node;

        try{
            temp.next.prev = temp;
            tail = tail.next;
        } catch (NullPointerException ignored){}

        n++;
    }

    public Object get(int i) {
        if (i<0 || i>=n); // …error!
        ListNode2 node = head;
        for (int j=0; j<i; j++)
            node = node.next;
        return node.element;
    }

    /**
     * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
     * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
     */

    public void print() {
        // no elements to print for empty list
        if (head == null) {
            System.out.println("list empty.");
            return;
        }

        // follow next references to list elements from the front to the back of the list
        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        // follow prev references to list elements from the back to the front of the list
        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;
        }
        System.out.println();
    }
}
