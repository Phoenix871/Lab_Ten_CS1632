import java.util.ArrayList;

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

    /**
     * Simple private helper method that finds the next biggest node
     * @param currNode The node you are starting at
     * @return The next biggest node
     */
    private Node<T> doFindNextBiggestPrev(Node<T> currNode) {
        //Loop until there are no children two nodes down from currentNode
        while (currNode.getLeft().getLeft() != null) {
            currNode = currNode.getLeft(); //Set currNode to its left child
        }
        return currNode; //return the new currNode
    }

    public void removeNode(T dValue) {

    }

    /**
     * A private helper method to recursively handle the removal of a node
     * @param dValue The value of the node to be removed
     * @param currNode The current node being searched
     * @return The new node to be searched
     */
    private Node<T> doRecursiveRemove(T dValue, Node<T> currNode) {
        //checks if current node is blank
        if (currNode == null) {
            return null;
        }

        //create a compare value from this nodes data and the one we want to remove
        int compareValue = currNode.getData().compareTo(dValue);

        //check if this is the node to be removed
        if (compareValue == 0) {
            //check if there is a left child or not
            if (currNode.getLeft() == null) {
                return currNode.getRight();
            }
            //Check if there is a right child or not
            if (currNode.getRight() == null) {
                return currNode.getLeft();
            }
            //if neither child is null, check if the right child is left child is null
            if (currNode.getRight().getLeft() == null) {
                currNode.setData(currNode.getRight().getData()); //swaps data
                currNode.setRight(currNode.getRight().getRight()); //swap nodes
                return currNode;
            }
            //Get the next biggest previous node (a bit of a confusing sentence)
            Node<T> nextBiggestPrevious = doFindNextBiggestPrev(currNode.getRight());
            currNode.setData(nextBiggestPrevious.getLeft().getData()); //swap data
            nextBiggestPrevious.setLeft(nextBiggestPrevious.getLeft().getRight()); //swaps nodes
            return currNode; //returns current node
        }
        else { //All else fails, means the value of the current node is bigger or smaller than we want
            //See if the compare Value is larger
            if (compareValue > 0) {
                return currNode.setLeft(doRecursiveRemove(dValue, currNode.getLeft())); // run the cycle again
            }
            //Value must be smaller
            else {
                return currNode.setRight(doRecursiveRemove(dValue,currNode.getRight())); //run the cycle once again
            }
        }
    }

    /**
     * A method that returns the height of the tree
     * @param currNode The node we are starting at
     * @return The final height of the tree
     */
    public int calcTreeHeight(Node<T> currNode) {
        //checks if this node is even real
        if (currNode == null) {
            return  0; //not very tall then
        }
        else { //There's something here
            //recursively calculates the height of the tree
            return 1 + Math.max(calcTreeHeight(currNode.getLeft()), calcTreeHeight(currNode.getRight()));
        }
    }

    /**
     * A method to print the tree in its entirety
     */
    public void printTree() {
        //First call of recursive method
        recursivePrintTree(root, 0);
    }

    /**
     * A helper method that recursively prints out the contents of the tree
     * @param currNode The current node that it is at
     * @param level how high the tree currently is
     */
    private void recursivePrintTree(Node<T> currNode, int level) {
        //check to make sure currNode isn't null
        if (currNode != null) {
            recursivePrintTree(currNode.getLeft(), level+1);

            //loop through all the levels, just to look neat
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }

            System.out.println(currNode.getData());

            //call recursivePrintTree again
            recursivePrintTree(currNode.getRight(), level+1);
        }
    }

    public ArrayList<T> getArrayListOfValues() {
        return recursiveArrayListOfValues(root, new ArrayList<T>());
    }

    private ArrayList<T> recursiveArrayListOfValues(Node<T> currNode, ArrayList<T> tempArray) {
        //check if currNode exists
        if (currNode == null) {
            return tempArray;
        }

        tempArray = recursiveArrayListOfValues(currNode.getLeft(), tempArray); //run through all the left nodes
        tempArray.add(currNode.getData()); //Add the current node to the list
        return recursiveArrayListOfValues(currNode.getRight(), tempArray); //run through all the right nodes
    }
}