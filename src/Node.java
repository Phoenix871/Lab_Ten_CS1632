/**
 * @author Carter Jorgensen
 * Date: 11 / 23 / 2026
 * Purpose: help implement binary trees for lab 10 in CS 1632
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
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
     * A method to set a new data variable
     * @param newData The new data to be stored
     */
    public void setData(T newData) {
        this.data = newData;
    }

    /**
     * A get method for the right child
     * @return The right child
     */
    public Node<T> getRight() {
        return this.right;
    }

    /**
     * A method to set a new right node
     * @param newRight The new right node
     */
    public Node<T> setRight(Node<T> newRight) {
        this.right = newRight;
        return right;
    }

    /**
     * A get method for the left child
     * @return The left child
     */
    public Node<T> getLeft() {
        return this.left;
    }

    /**
     * A method to set a new left node
     * @param newLeft The new left node
     */
    public Node<T> setLeft(Node<T> newLeft) {
        this.left = newLeft;
        return left;
    }

    /**
     * A method to compare nodes by whatever values they have
     * @param other the object to be compared.
     * @return Whether the object is larger, smaller, or the same
     */
    @Override
    public int compareTo(Node<T> other) {
        return data.compareTo(other.getData());
    }
}
