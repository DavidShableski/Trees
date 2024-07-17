//David Shableski

package trees;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<String> myTree = new BinarySearchTree<>();
        myTree.insert("carrot");
        myTree.insert("apple");
        myTree.insert("banana");
        myTree.insert("eggplant");
        myTree.insert("avocado");

        // Check contains 
        System.out.println("Does the tree contain 'banana'? " + myTree.contains("banana")); // true
        System.out.println("Does the tree contain 'cherry'? " + myTree.contains("cherry")); // false

        // Check find 
        try {
            System.out.println("Find 'apple': " + myTree.find("apple"));
            System.out.println("Find 'cherry': " + myTree.find("cherry")); //exception
        } catch (NullPointerException e) {
            System.out.println("'cherry' does not exist in the tree");
        }

        // Print  tree before removal
        System.out.println("Tree before removal: ");
        System.out.println(myTree);

        // Check remove 
        System.out.println("Removing 'banana'");
        myTree.remove("banana");

        // Check contains again
        System.out.println("Does the tree contain 'banana'? " + myTree.contains("banana")); // false

        // Print tree after removal
        System.out.println("Tree after removal of 'banana': ");
        System.out.println(myTree);
    }

}
