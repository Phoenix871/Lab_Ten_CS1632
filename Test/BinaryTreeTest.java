import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Carter Jorgensen
 * Date: 11 / 24 / 2026
 * Purpose: to test the Binary Tree class
 */
class BinaryTreeTest {

    /**
     * A method to test the findNode method
     */
    @Test
    void findNode() {
        //Create binary tree object
        BinaryTree<Integer> bTestTree = new BinaryTree<>();

        //Add some nodes to it
        bTestTree.insertNode(4);
        bTestTree.insertNode(32);
        bTestTree.insertNode(9);
        bTestTree.insertNode(56);

        //testing time
        assertEquals(4, bTestTree.findNode(4).getData());
        assertNull(bTestTree.findNode(23123));
    }

    /**
     * A method to test the insertNode method
     */
    @Test
    void insertNode() {
        //Create binary tree object
        BinaryTree<Integer> bTestTree = new BinaryTree<>();

        //Add some nodes to it
        bTestTree.insertNode(4);
        bTestTree.insertNode(32);
        bTestTree.insertNode(9);
        bTestTree.insertNode(56);

        //testing time
        assertNull(bTestTree.findNode(3));
        bTestTree.insertNode(3);
        assertTrue(bTestTree.findNode(3).getData() == 3);
    }

    @Test
    void removeNode() {
        //Create binary tree object
        BinaryTree<Integer> bTestTree = new BinaryTree<>();

        //Add some nodes to it
        bTestTree.insertNode(4);
        bTestTree.insertNode(32);
        bTestTree.insertNode(9);
        bTestTree.insertNode(56);

        //testing time
        assertEquals(4, bTestTree.findNode(4).getData());
        bTestTree.removeNode(4);


    }

    /**
     * A method to test the calcTreeHeight function
     */
    @Test
    void calcTreeHeight() {
        //Create binary tree object
        BinaryTree<Integer> bTestTree = new BinaryTree<>();

        //Add some nodes to it
        bTestTree.insertNode(4);
        bTestTree.insertNode(32);
        bTestTree.insertNode(9);
        bTestTree.insertNode(56);

        //testing time
        assertEquals(3, bTestTree.calcTreeHeight(bTestTree.getRoot()));
    }

    /**
     * A method to test the getArrayListOfValues function
     */
    @Test
    void getArrayListOfValues() {
        //Create binary tree object
        BinaryTree<Integer> bTestTree = new BinaryTree<>();

        //Add some nodes to it
        bTestTree.insertNode(4);
        bTestTree.insertNode(32);
        bTestTree.insertNode(9);
        bTestTree.insertNode(56);

        //testing time
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4); test.add(9); test.add(32); test.add(56);

        assertEquals(test, bTestTree.getArrayListOfValues());
    }

    /**
     * A method to test the getRoot function
     */
    @Test
    void getRoot() {
        //Create binary tree object
        BinaryTree<Integer> bTestTree = new BinaryTree<>();

        //Add some nodes to it
        bTestTree.insertNode(4);
        bTestTree.insertNode(32);
        bTestTree.insertNode(9);
        bTestTree.insertNode(56);

        //testing time
        assertEquals(4, bTestTree.getRoot().getData());
    }
}