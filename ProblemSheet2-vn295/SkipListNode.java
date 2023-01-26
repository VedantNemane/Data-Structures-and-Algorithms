import java.util.Random;

public class SkipListNode {
    public String element;
    public SkipListNode[] next;

    public SkipListNode(String s) {
        element = s;
        Random r = new Random();
        int l = 1;
        while(r.nextFloat() < 0.5){
            l++;
        }
        next = new SkipListNode[l];
    }

    public SkipListNode(String s, int lanes){
        element = s;
        next = new SkipListNode[lanes];
    }

}
