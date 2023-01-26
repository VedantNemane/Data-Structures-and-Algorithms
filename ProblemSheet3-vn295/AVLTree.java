public class AVLTree {
    AVLTreeNode root = null;

    public AVLTree(){}

    public void createTestTree(){
        //hard code the basic tree
        root = new AVLTreeNode(4, 3);
        root.left = new AVLTreeNode(2, 2);
        root.right = new AVLTreeNode(6, 2);
        root.left.left = new AVLTreeNode(1, 1);
        root.left.right = new AVLTreeNode(3, 1);
        root.right.left = new AVLTreeNode(5, 1);
        root.right.right = new AVLTreeNode(7, 1);

    }

    public void print(){
        realPrint(root, "");
    }

    public void realPrint(AVLTreeNode node, String tab) {
        if (node == null){
            return;
        }
        //preorder printing
        System.out.println(tab + node.value);
        //each time you go to a new line increase the indentation
        realPrint(node.left, tab + "  ");
        realPrint(node.right, tab + "  ");
    }

    public int getMax(int a, int b) {return (a > b) ? a : b;}

    public void insert(String e){
        //convert the string to an integer first (easier for comparisons)
        int value = Integer.parseInt(e);
        this.root = this.insertNode(this.root, value);
    }

    public AVLTreeNode insertNode(AVLTreeNode node, int value) {
        //we've found a gap so place it here
        if (node == null){
            return new AVLTreeNode(value);
        }
        //if it isn't exactly the same then traverse (e.g. call itself again to keep traversing and checking)
        if (value < node.value){
            node.left = insertNode(node.left, value);
        } else if (value > node.value){
            node.right = insertNode(node.right, value);
        } else {
            return node;
        }

        //get the balance
        //fix height and balance
        node.height = getMax(refinedHeight(node.left), refinedHeight(node.right)) + 1;
        int bal = calculateBalance(node);

        //if the balance is off

        if (bal < -1 && value < node.left.value){
            return newRightRotate(node);
        }
        if (bal > 1 && value > node.right.value){
            return newLeftRotate(node);
        }
        if (bal < -1 && value > node.left.value){
            node.left = newLeftRotate(node.left);
            return newRightRotate(node);
        }
        if (bal > 1 && value < node.right.value) {
            node.right = newRightRotate(node.right);
            return newLeftRotate(node);
        }

        return node;
    }

    //rotate whole tree right (so root's left child becomes new root)
    public AVLTreeNode newRightRotate(AVLTreeNode node){
        //new root is the smaller child of the old root
        AVLTreeNode newRoot = node.left;
        //create a new node and make it identical to the right branch of the small of the old root (can be null)
        AVLTreeNode newNode = newRoot.right;
        //new root's right side becomes the old root
        newRoot.right = node;
        //old root's left becomes right branch of the small of the old root (that can be null again)
        node.left = newNode;

        //refinedHeight makes sure that null values do not affect the getMax function
        newRoot.height = getMax(refinedHeight(newRoot.left), refinedHeight(newRoot.right)) + 1;
        node.height = getMax(refinedHeight(node.left), refinedHeight(node.right)) + 1;

        if (node == root){
            root = newRoot;
        }

        //return the top of the new tree
        return newRoot;
    }

    //rotate whole tree left (so root's right child becomes new root)
    public AVLTreeNode newLeftRotate(AVLTreeNode node){
        //new root is the bigger child of the old root
        AVLTreeNode newRoot = node.right;
        //create a new node and make it = left branch of the big side of the old root
        AVLTreeNode newNode = newRoot.left;
        //do rotation so: old root's big child's left becomes the old root (and the sub-trees within it)
        newRoot.left = node;
        //old root's right side becomes the left branch of the big side of old root
        node.right = newNode;

        //null values treated as 0 for the purpose of calculations
        newRoot.height = getMax(refinedHeight(newRoot.left), refinedHeight(newRoot.right)) + 1;
        node.height = getMax(refinedHeight(node.left), refinedHeight(node.right)) + 1;

        if (node == root){
            root = newRoot;
        }

        return newRoot;
    }

    //doesn't allow "height" characteristic to be null (has to be 0 if it is)
    public int refinedHeight(AVLTreeNode node){
        return (node == null) ? 0 : node.height;
    }
    //gets balance from height functions
    public int calculateBalance(AVLTreeNode node) {
        if (node == null){
            return 0;
        }
        return refinedHeight(node.right) - refinedHeight(node.left);
    }
    //original function doesn't allow for recursion, so make another function
    public boolean inTree(String e){
        int value = Integer.parseInt(e);
        return searchTree(root, value);
    }
    //if node is null we went past a leaf and so the value is not in tree
    public boolean searchTree(AVLTreeNode node, int value) {
        if (node == null){
            return false;
            //if we found a match then return true
        } else if (node.value == value){
            return true;
            //recurse with an if statement shorthand
        } return searchTree((value < node.value) ? node.left: node.right, value);
    }
}
