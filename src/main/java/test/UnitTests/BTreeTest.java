package test.UnitTests;

import static org.junit.Assert.*;
import algorithm.BTree;
import org.junit.*;

public class BTreeTest {

    @Test
    public void testIsEmpty() {
        BTree<Integer> tree = new BTree<>(3);
        assertTrue(tree.isEmpty());

        tree.insert(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testGetRoot() {
        BTree<Integer> tree = new BTree<>(3);
        assertNull(tree.getRoot());

        tree.insert(1);
        assertNotNull(tree.getRoot());
    }

    @Test
    public void testGetTreeSize() {
        BTree<Integer> tree = new BTree<>(3);
        assertEquals(0, tree.getTreeSize());

        tree.insert(1);
        assertEquals(1, tree.getTreeSize());

        tree.insert(2);
        tree.insert(3);
        assertEquals(3, tree.getTreeSize());
    }

    @Test
    public void testGetHeight() {
        BTree<Integer> tree = new BTree<>(3);
        assertEquals(0, tree.getHeight());

        tree.insert(1);
        assertEquals(1, tree.getHeight());

        tree.insert(2);
        tree.insert(3);
        assertEquals(2, tree.getHeight());
    }

    @Test
    public void testGetNode() {
        BTree<Integer> tree = new BTree<>(3);
        assertNull(tree.getNode(1));

        tree.insert(1);
        assertNotNull(tree.getNode(1));

        tree.insert(2);
        tree.insert(3);
        assertNotNull(tree.getNode(2));
        assertNull(tree.getNode(4));
    }

    @Test
    public void testInsert() {
        BTree<Integer> tree = new BTree<>(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        assertEquals(6, tree.getTreeSize());
        assertEquals(2, tree.getHeight());

        assertNotNull(tree.getNode(1));
        assertNotNull(tree.getNode(2));
        assertNotNull(tree.getNode(3));
        assertNotNull(tree.getNode(4));
        assertNotNull(tree.getNode(5));
        assertNotNull(tree.getNode(6));
    }

    @Test
    public void testDelete() {
        BTree<Integer> tree = new BTree<>(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        tree.delete(1);
        tree.delete(2);
        tree.delete(3);

        assertEquals(3, tree.getTreeSize());
        assertEquals(2, tree.getHeight());

        assertNull(tree.getNode(1));
        assertNull(tree.getNode(2));
        assertNull(tree.getNode(3));
        assertNotNull(tree.getNode(4));
        assertNotNull(tree.getNode(5));
        assertNotNull(tree.getNode(6));
    }
}
