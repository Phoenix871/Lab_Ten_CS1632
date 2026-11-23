/**
 * @author Carter Jorgensen
 * Date: 11 / 23 / 2026
 * Purpose: help implement binary trees for lab 10 in CS 1632
 */
public class Node<T> {
    //Attributes
    private T data; //the data stored
    private Node<T> left; //the left child
    private Node<T> right; //The right child

    //Constructor
    public Node(T data) {
        this.data = data;
    }

    //quick methods
    /**
     * A get method for data in node
     * @return The data
     */
    public T getData() {
        return this.data;
    }

    /**
     * A get method for the right child
     * @return The right child
     */
    public Node<T> getRight() {
        return this.right;
    }

    /**
     * A get method for the left child
     * @return The left child
     */
    public Node<T> getLeft() {
        return this.left;
    }
}
