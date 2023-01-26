public class AVLTreeNode {
    //left is small and right is big
    public AVLTreeNode left, right;
    public int value, height;

    public AVLTreeNode(int value){
        this.value = value;
        this.height = 1;
    }

    public AVLTreeNode(int value, int height){
        this.value = value;
        this.height = height;
    }

}
