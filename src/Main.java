import java.util.ArrayList;

/**
 * @author Carter Jorgensen
 * Date: 11 / 23 / 2026
 * Purpose: just a place to run my code
 */
public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> bTreeUno = generateRandomTree(10000);
        bTreeUno.findNode(500);
        System.out.println("Searched: " + bTreeUno.numNodesVisited + " nodes");

        //bTreeUno.printTree();
        //ArrayList<Integer> bTreeToArray = bTreeUno.getArrayListOfValues();
        //System.out.println(bTreeToArray);
    }

    public static BinaryTree<Integer> generateRandomTree(int length) {
        System.out.println("Creating a binary tree of length " + length + ", with random numbers: ");
        //create the binary tree object
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        //Add all the random numbers (from 1 to 1000)
        for (int i = 0; i < length; i++) {
            int randNum = ((int)(Math.random()*1000) + 1);
            binaryTree.insertNode(randNum);
        }

        System.out.println("Final tree height: " + binaryTree.calcTreeHeight(binaryTree.getRoot()));

        //return the tree
        return binaryTree;
    }
}
