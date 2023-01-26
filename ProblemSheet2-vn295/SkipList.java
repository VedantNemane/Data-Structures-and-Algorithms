class SkipList {
    private SkipListNode[] head;
    private int n = 0; // list size
    private int maxLevels;

    public SkipList() {
        // TODO implement this
        maxLevels = 5;
        head = new SkipListNode[maxLevels - 1];
    }

    public void createTestList() {
        // TODO implement this
        head[0] = new SkipListNode("Anne", 3);
        head[1] = new SkipListNode("Anne", 3);
        head[2] = new SkipListNode("Anne", 3);

        SkipListNode Ben = new SkipListNode("Ben", 3);
        SkipListNode Charlie = new SkipListNode("Charlie", 3);
        SkipListNode Don = new SkipListNode("Don", 3);
        SkipListNode Ernie = new SkipListNode("Ernie", 3);

        head[0].next[0] = Ben;
        Ben.next[0] = Charlie;
        Charlie.next[0] = Don;
        Don.next[0] = Ernie;
        Ernie.next[0] = null;

        head[1].next[1] = Charlie;
        Charlie.next[1] = Ernie;
        Ernie.next[1] = null;

        head[2].next[2] = Ernie;
        Ernie.next[2] = null;

    }

    public void print() {
        // TODO implement this

        System.out.println();
        SkipListNode temp = head[2];
        for (int i = 0; i < 2; i++){
            if(i == 1){
                System.out.print(temp.element);
            } else {
                System.out.print(temp.element + ", ");
            }
            temp = temp.next[2];
        }

        System.out.println();
        temp = head[1];
        for (int i = 0; i < 3; i++){
            if(i == 2){
                System.out.print(temp.element);
            } else {
                System.out.print(temp.element + ", ");
            }
            temp = temp.next[1];
        }

        System.out.println();
        temp = head[0];
        for (int i = 0; i < 5; i++){
            if(i == 4){
                System.out.print(temp.element);
            } else {
                System.out.print(temp.element + ", ");
            }
            temp = temp.next[0];
        }
        System.out.println();
    }

    public boolean inList(String s) {
        for (int i = 2; i > -1; i--){
            SkipListNode temp = head[i];
            while (temp != null){
                if (temp.element.compareTo(s) == 0){
                    return true;
                }
                temp = temp.next[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.createTestList();
        sl.print();
        System.out.println();

        System.out.println(sl.inList("Anne") + " should be true");
        System.out.println(sl.inList("Ben") + " should be true");
        System.out.println(sl.inList("Charlie") + " should be true");
        System.out.println(sl.inList("Don") + " should be true");
        System.out.println(sl.inList("Ernie") + " should be true");

        System.out.println(sl.inList("Arya") + " should be false");
        System.out.println(sl.inList("Elmo") + " should be false");
        System.out.println(sl.inList("Zorro") + " should be false");
    }
}
