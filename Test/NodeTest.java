import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Carter Jorgensen
 * Date: 11 / 23 / 2026
 * Purpose: To test the Node class
 */
class NodeTest {

    /**
     * A method to test the getData method
     */
    @Test
    void getData() {
        //Create a node
        Node<Integer> testNode = new Node<>(1);

        //Test the method
        assertEquals(1, testNode.getData());
    }

    /**
     * A method to test the setData method
     */
    @Test
    void setData() {
        //Create a node
        Node<Integer> testNode = new Node<>(1);

        //try setting data
        testNode.setData(34);

        //Test the method
        assertEquals(34, testNode.getData());
    }

    /**
     * A method to test the getRight and setRight method
     */
    @Test
    void getRight() {
        //Create a node
        Node<Integer> testNode = new Node<>(1);

        //Add children
        Node<Integer> testRightChild = new Node<>(3);
        Node<Integer> testLeftChild = new Node<>(45);

        testNode.setRight(testRightChild);
        testNode.setLeft(testLeftChild);

        //Test the method
        assertEquals(testRightChild, testNode.getRight());
    }

    /**
     * A method to test the getLeft and setLeft methods
     */
    @Test
    void getLeft() {
        //Create a node
        Node<Integer> testNode = new Node<>(1);

        //Add children
        Node<Integer> testRightChild = new Node<>(3);
        Node<Integer> testLeftChild = new Node<>(45);

        testNode.setRight(testRightChild);
        testNode.setLeft(testLeftChild);

        //Test the method
        assertEquals(testRightChild, testNode.getRight());
    }

    /**
     * A method to test the compareTo method
     */
    @Test
    void compareTo() {
        //Create a node
        Node<Integer> testNode = new Node<>(1);

        //Create a second and third node that should equal the first
        Node<Integer> testNodeTwo = new Node<>(1);
        Node<Integer> testNodeThree = new Node<>(31);

        //Test the method
        assertEquals(0, testNode.compareTo(testNodeTwo));
        assertNotEquals(0, testNode.compareTo(testNodeThree));
    }

    /**
     * A method to test the toString method
     */
    @Test
    void testToString() {
        //Create a node
        Node<Integer> testNode = new Node<>(1);

        //Test the method
        assertEquals("1", testNode.toString());
    }
}