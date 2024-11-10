import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testBinaryTree {
    static binaryTree<Integer> treeSearch = new binaryTree<Integer>();

    @BeforeEach 
    public void before() {
        treeSearch.clear();

        treeSearch.add(treeSearch.getRoot(), 5);
        treeSearch.add(treeSearch.getRoot(), 8);
        treeSearch.add(treeSearch.getRoot(), 7);
        treeSearch.add(treeSearch.getRoot(), 6);
        treeSearch.add(treeSearch.getRoot(), 3);
        treeSearch.add(treeSearch.getRoot(), 2);
        treeSearch.add(treeSearch.getRoot(), 4);
    }

    @Test 
    public void testCopyTree() {
        binaryTree<Integer> copiedTree = new binaryTree<Integer>(treeSearch);
        Assertions.assertEquals(treeSearch.getSize(), copiedTree.getSize());
        Assertions.assertEquals(treeSearch.toString(), copiedTree.toString());
    }

    @Test 
    public void testSearch() {
        Assertions.assertFalse(treeSearch.findElement(treeSearch.getRoot(), 1));
        Assertions.assertTrue(treeSearch.findElement(treeSearch.getRoot(), 2));
        Assertions.assertFalse(treeSearch.findElement(treeSearch.getRoot(), -4));
        Assertions.assertFalse(treeSearch.findElement(treeSearch.getRoot(), 11));
        Assertions.assertTrue(treeSearch.findElement(treeSearch.getRoot(), 5));
        Assertions.assertTrue(treeSearch.findElement(treeSearch.getRoot(), 7));
    }

    @Test 
    public void testClearTree() {
        treeSearch.clear();
        Assertions.assertEquals(0, treeSearch.getSize());
    }

    public static void main(String[] args) {
        System.out.println("\t\t add 5");
        treeSearch.add(treeSearch.getRoot(), 5);
        System.out.println("\t\t add 8");
        treeSearch.add(treeSearch.getRoot(), 8);
        System.out.println("\t\t add 7");
        treeSearch.add(treeSearch.getRoot(), 7);
        System.out.println("\t\t add 6");
        treeSearch.add(treeSearch.getRoot(), 6);
        System.out.println("\t\t add 3");
        treeSearch.add(treeSearch.getRoot(), 3);
        System.out.println("\t\t add 2");
        treeSearch.add(treeSearch.getRoot(), 2);
        System.out.println("\t\t add 4");
        treeSearch.add(treeSearch.getRoot(), 4);
    }
}
