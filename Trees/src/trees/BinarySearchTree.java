//David Shableski

package trees;
// define generic Bianary search tree that extends BianaryTree
public class BinarySearchTree<T extends Comparable<T>> 
                                extends BinaryTree<T> {
//method to insert data in the tree
    public void insert(T data) {
        
        //create new node
        Node<T> newNode = new Node<T>();
    newNode.setData(data);
    //check if its empty
    if (isEmpty()) {
        root = newNode;
    } else {
        //go throughout tree to find right position
        Node<T> cur = getRoot();
        Node<T> parent = null;
        while (cur != null) {
            parent = cur; //update parent node
            if (newNode.getData().compareTo(cur.getData()) < 0) {
                if (cur.getLeft() == null) {
                    cur.setLeft(newNode); // if left is empty insert there
                    newNode.setParent(cur);
                    cur = null;
                } else {
                    cur = cur.getLeft(); //move left subtree
                }
            } else {
                if (cur.getRight() == null) {
                    cur.setRight(newNode); // if right is empty insert there
                    newNode.setParent(cur); 
                    cur = null;
                } else {
                    cur = cur.getRight();//move to left subtree
                }
            }
        }
    }
    size++; // increase treee size
    }
//method to remove
    public void remove(T data) {
        Node<T> node = findNode(data);// find the node with the right data
        removeNode(node);// call the removeNode method to remove it
    }
    //method to remove a specific node 
    public void removeNode(Node<T> node) {
        if (node == null) {
            return; // if the node is null return
        }

        //check if the node has left and right childs
        if (node.getLeft() != null && node.getRight() != null) {
           
            Node<T> successor = node.getLeft();
            //find the most right node in the left subree
            while (successor.getRight() != null) {
                successor = successor.getRight();
            }
            //replace data of the cur node with the data of the successor
            node.setData(successor.getData());
            //remove the successor node
            removeNode(successor);
        } else {
           
            Node<T> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();

            //check if the node is to be removed is the root
            if (node == root) {
                setRoot(child); //update the root to the child node
                if (child != null) {
                    child.setParent(null);
                }
            } else {
              
                node.getParent().replaceChild(node, child);//replace the node with its child
            }
            size--;//decrease the size of the tree
        }
    
    }
//method to check if the treee has specific data
    public boolean contains(T data) {
        Node<T> current = root;
        while (current != null) {
            int comparison = data.compareTo(current.getData());
            if (comparison < 0) {
                current = current.getLeft(); //move to the left subtree
            } else if (comparison > 0) {
                current = current.getRight(); //move to the right subtree
            } else {
                
                return true; //data found in tree
            }
        }
        
        return false; //data not found in tree
    
    }
    
    
    //method to fund the node with the specific data
    public Node<T> findNode(T data) {
        Node<T> current = root;
        while (current != null) {
            int comparison = data.compareTo(current.getData());
            if (comparison < 0) {
                current = current.getLeft();//move to the left subtree
            } else if (comparison > 0) {
                current = current.getRight();// move to the right subtree
            } else {
                return current; //return the node with the specified data
            }
        }
        return null; // data not found in the tree
    
    }

    public T find(T data) {        
        Node<T> node = findNode(data);
        return node.getData();
    }
}