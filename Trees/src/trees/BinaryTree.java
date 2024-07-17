//David Shableski

package trees;

public class BinaryTree<T> {

    protected int size;
    protected Node<T> root;
    
    
    // zero argument constructor
    public BinaryTree() {
        root = null;
        size = 0;
    }

    // one argument constructor using data for the root node
    public BinaryTree(T data) {
        this.root = new Node<>(data);
        this.size = 1; 
    }

    // one argument constructor using an existing node as the root
    public BinaryTree(Node<T> root) {
        this.root = root;
        this.size = calculateSize(root); 
    }
    
//gets the left subtree
    public BinaryTree<T> getLeftSubtree() {
        BinaryTree<T> result = new BinaryTree<>();
        result.setRoot(this.getRoot().getLeft());
        // size of the left subtree
        return result;
    }
//gets the right subtree
    public BinaryTree<T> getRightSubtree() {
        BinaryTree<T> result = new BinaryTree<>();
        result.setRoot(this.getRoot().getRight());
        // size of the right subtree
        return result;
    }
//checks if the tree is empty
    public boolean isEmpty() {
        return (size == 0);
    }
//returns string of the tree (in order traversal)
    public String toString() {
        //  returns the in order traversal of the tree
        String result = inOrderHelper(this.root, "");
        return result;
    }
    //helper method to preform in order traversal
    private String inOrderHelper(Node<T> node, String soFar) { 
        String answer = soFar;
        if (node == null)
            return answer;
        
        answer = inOrderHelper (node.getLeft(), answer);
        answer += node.getData().toString() + " ";
        answer = inOrderHelper (node.getRight(), answer);
        return answer;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the root
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }
    
    
    public String preorder() {
        return preorderHelper(this.root, "");
    }

    private String preorderHelper(Node<T> node, String soFar) {
        if (node == null) {
            return soFar;
        }

        soFar += node.getData().toString() + " "; //visit node
        soFar = preorderHelper(node.getLeft(), soFar);//traversal left subtree
        soFar = preorderHelper(node.getRight(), soFar);//traversal right subtree

        return soFar;
    }

    public String postorder() {
        return postorderHelper(this.root, "");
    }

    private String postorderHelper(Node<T> node, String soFar) {
        if (node == null) {
            return soFar;
        }

        soFar = postorderHelper(node.getLeft(), soFar);//traversal left subtree
        soFar = postorderHelper(node.getRight(), soFar);//traversal right subtree
        soFar += node.getData().toString() + " ";//visit node

        return soFar;
    }
    
    
    private int calculateSize(Node<T> node) {
        if (node == null) {
            return 0;
        }
        //the size is the sum of the sizes of the left subtree right subtree 
        return 1 + calculateSize(node.getLeft()) + calculateSize(node.getRight());
    }
    
    
}
