//David Shableski

package trees;

public class Node<T> {
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;
    private T data;
    
    // no argument constructor
    public Node() {
        parent = null;
        left = null;
        right = null;
        data = null;
    }
    
    // one argument constructor
    public Node(T data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * @return the parent
     */
    public Node<T> getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
    
    
    
    
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = null; 

        
        if (left != null) {
            left.setParent(this);
        }

        
        if (right != null) {
            right.setParent(this);
        }
    }
    
    
    
    
    /**
     * @return the left
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }    
    
    
    
    
    
    //replaces the child of the parent node
     public boolean replaceChild(Node<T> currentChild, Node<T> newChild) {
        if (left != null && left.equals(currentChild)) {
            setLeft(newChild);
            if (newChild != null) newChild.setParent(this);
            return true;
        } else if (right != null && right.equals(currentChild)) {
            setRight(newChild);
            if (newChild != null) newChild.setParent(this);
            return true;
        }
        return false;
    }
    
    
    
    
    
}
