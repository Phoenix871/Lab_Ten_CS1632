/**
 * @author Carter Jorgensen
 * Date: 11 / 23 / 2026
 * Purpose: implement binary trees for lab 10 in CS 1632
 */
public class BinaryTree<T extends Comparable<T>> {
    //Attributes
    private Node<T> root; //The tippy top of the tree

    //Constructor
    /**
     * A constructor to initialize the Binary tree object
     */
    public BinaryTree() {
        this.root = null;
    }

    //Methods
    /**
     * A method to find a specific node within the binary tree
     * @param dValue The value of the node that is trying to find
     * @return The node if there is one
     */
    public Node<T> findNode(T dValue) {
        //Starts the recursive cycle with the rood node
        return doRecursiveFind(dValue, root);
    }

    /**
     * A helper method to recursively find the node
     * @param dValue The value within the node you are looking for
     * @param currNode The current parent node that is being looked at
     * @return The node if there is the one you are looking for
     */
    private Node<T> doRecursiveFind(T dValue, Node<T> currNode) {
        //Checks to see if there is no value/node present at the current node
        if (currNode == null) {
            return null;
        }

        //find how the values of currNode compare to what we want
        int compareValue = currNode.getData().compareTo(dValue);

        //Checks if this is the node you are looking for
        if (compareValue == 0) {
            return currNode; //returns the node
        }

        //Checks if the node you are looking for has a greater value than the current node
        if (compareValue > 0) {
            return doRecursiveFind(dValue, currNode.getLeft()); //runs the method again with the left child
        }

        //runs the method again with the right node
        return doRecursiveFind(dValue, currNode.getRight());
    }

    /**
     * A method to insert a new node into the binary tree
     * @param dValue The value of the new node you wish to insert
     */
    public void insertNode(T dValue) {
        root = doRecursiveInsert(dValue, root); //calls the recursive method using the root node
    }

    /**
     * A helper method to recursively insert a new node into the tree
     * @param dValue The value of the node to be inserted
     * @param currNode The current node being checked
     * @return A new node at the correct position in the tree
     */
    private Node<T> doRecursiveInsert(T dValue, Node<T> currNode) {
        //Checks to see if this node is completely blank or not
        if (currNode == null) {
            return new Node<>(dValue); //returns a new node with no children
        }
        //checks if the data of the current node is greater than the value we are trying to insert
        if (currNode.getData().compareTo(dValue) > 0) {
            currNode.setLeft(doRecursiveInsert(dValue, currNode.getLeft())); //sets the left using the result of the next recursion
        }
        //The data of current node is less than the value to be added
        else {
            currNode.setRight(doRecursiveInsert(dValue, currNode.getRight())); //sets the left using the result of the next recursion
        }
        //Return the new root node of the tree
        return currNode;
    }
}