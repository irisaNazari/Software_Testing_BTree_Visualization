package mocking;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BTNodeTest {
    @Test
    void testIsLastInternalNode() {
        BTNode<Integer> node = new BTNode<>();
        assertFalse(node.isLastInternalNode());

        // Mock child nodes
        BTNode<Integer> child1 = mock(BTNode.class);
        BTNode<Integer> child2 = mock(BTNode.class);
        when(child1.getKeys()).thenReturn(new ArrayList<>());  // Empty keys for mock child
        when(child2.getKeys()).thenReturn(new ArrayList<>());  // Empty keys for mock child
        node.addChild(0, child1);
        node.addChild(1, child2);

        assertTrue(node.isLastInternalNode());

        // Add a key to the node and check again
        node.addKey(0, 42);
        assertFalse(node.isLastInternalNode());
    }

    @Test
    void testGetFather() {
        BTNode<Integer> node = new BTNode<>();
        assertNull(node.getFather());

        // Mock a father node
        BTNode<Integer> father = mock(BTNode.class);
        node.setFather(father);

        assertEquals(father, node.getFather());
    }

    // Add more tests for other methods in a similar way
    // ...

    @Test
    void testIsFull() {
        // Create a node with order = 4
        BTNode<Integer> node = new BTNode<>(4);

        assertFalse(node.isFull());

        // Add 3 keys to make it full
        node.addKey(0, 10);
        node.addKey(1, 20);
        node.addKey(2, 30);

        assertTrue(node.isFull());

        // Add one more key, should still be full
        node.addKey(3, 40);
        assertTrue(node.isFull());
    }

    @Test
    void testIsOverflow() {
        // Create a node with order = 2
        BTNode<Integer> node = new BTNode<>(2);

        assertFalse(node.isOverflow());

        // Add 3 keys, should be overflow
        node.addKey(0, 10);
        node.addKey(1, 20);
        node.addKey(2, 30);

        assertTrue(node.isOverflow());
    }

    @Test
    void testIsNull() {
        BTNode<Integer> node = new BTNode<>();

        assertTrue(node.isNull());

        // Add a key
        node.addKey(0, 42);

        assertFalse(node.isNull());
    }

    @Test
    void testGetSize() {
        BTNode<Integer> node = new BTNode<>();

        assertEquals(0, node.getSize());

        // Add keys
        node.addKey(0, 10);
        node.addKey(1, 20);

        assertEquals(2, node.getSize());
    }

}
