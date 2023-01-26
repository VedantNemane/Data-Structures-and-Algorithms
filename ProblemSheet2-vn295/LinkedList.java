public class LinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    private int n = 0; // list size

    public void addFirst(Object o) {
        head = new ListNode(o, head);
        tail = head;
        n++;
    }

    public Object get(int i) {
        if (i<0 || i>=n) ; // …error!
        ListNode node = head;
        for (int j=0; j<i; j++)
            node = node.next;
        return node.element;
    }

    public void add(Object o) {
        if (n == 0){
            tail = new ListNode(o, tail);
            head = tail;
        } else {
            tail.next = new ListNode(o, tail.next);
            tail = tail.next;
        }
        n++;
    }

    public void insert(Object o, int i) {
        if (i<0 || i>=n) ; // …error!
        if (i==0)
        {
            addFirst(o);
            return;
        }
        ListNode node = head;
        for (int j=0; j<i-1; j++)
            node = node.next;
        node.next = new ListNode(o, node.next);
        tail = tail.next;
        n++;
    }

    public void remove(int i) {
        if (i<0 || i>=n) ; // …error!
        if (i==0) { // special case
            head = head.next; n--; return; }

        ListNode node = head;

        for (int j=0; j<i-1; j++)
            node = node.next;

        node.next = node.next.next;
        if (node.next == null){
            tail = node;
        }
        n--;
    }

}
