package test.UnitTests;

import static org.junit.Assert.*;

import algorithm.BTNode;
import org.junit.Test;

public class BTNodeTest {

     @Test
    public void testIsOverflow() {
        // Test when keys size is greater than order - 1
        BTNode<Integer> node1 = new BTNode<>(3);
        node1.getKeys().add(5);
        node1.getKeys().add(10);
        node1.getKeys().add(7);
        assertTrue(node1.isOverflow());

        // Test when keys size is equal to order - 1
        BTNode<Integer> node2 = new BTNode<>(3);
        node2.getKeys().add(5);
        node1.getKeys().add(10);
        assertFalse(node2.isOverflow());

        // Test when keys size is less than order - 1
        BTNode<Integer> node3 = new BTNode<>(3);
        assertFalse(node3.isOverflow());
    }
    @Test
    public void testIsNull() {
        // Test when keys is empty
        BTNode<Integer> node1 = new BTNode<>();
        assertTrue(node1.isNull());

        // Test when keys is not empty
        BTNode<Integer> node2 = new BTNode<>();
        node2.getKeys().add(5);
        assertFalse(node2.isNull());
    }
    @Test
    public void testBTNodeCreation() {
        BTNode<Integer> node = new BTNode<>(3);

        assertTrue(node.isNull());
        assertFalse(node.isFull());
        assertFalse(node.isOverflow());
        assertEquals(0, node.getSize());
        assertEquals(0, node.getChildren().size());
        assertNull(node.getFather());
    }

    @Test
    public void testAddAndRemoveKeys() {
        BTNode<String> node = new BTNode<>(4);

        assertTrue(node.isNull());
        assertFalse(node.isFull());

        node.addKey(0, "apple");
        node.addKey(1, "banana");

        assertFalse(node.isNull());
        assertFalse(node.isFull());
        assertEquals(2, node.getSize());
        assertEquals("apple", node.getKey(0));
        assertEquals("banana", node.getKey(1));

        node.removeKey(0);

        assertFalse(node.isNull());
        assertFalse(node.isFull());
        assertEquals(1, node.getSize());
        assertEquals("banana", node.getKey(0));
    }

    @Test
    public void testAddAndRemoveChildren() {
        BTNode<Integer> parent = new BTNode<>(3);
        BTNode<Integer> child1 = new BTNode<>(3);
        BTNode<Integer> child2 = new BTNode<>(3);

        parent.addChild(0, child1);
        parent.addChild(1, child2);

        assertEquals(2, parent.getChildren().size());
        assertEquals(child1, parent.getChild(0));
        assertEquals(child2, parent.getChild(1));

        parent.removeChild(0);

        assertEquals(1, parent.getChildren().size());
        assertEquals(child2, parent.getChild(0));
    }

    @Test
    public void testIsLastInternalNode() {
        BTNode<Integer> internalNode = new BTNode<>(3);
        BTNode<Integer> leafNode = new BTNode<>(3);

        internalNode.addChild(0, new BTNode<>(3));
        internalNode.addChild(1, new BTNode<>(3));

        assertFalse(internalNode.isLastInternalNode());

    }

    @Test
    public void testSetAndGetFather() {
        BTNode<Integer> parent = new BTNode<>(3);
        BTNode<Integer> child = new BTNode<>(3);

        assertNull(child.getFather());

        child.setFather(parent);

        assertEquals(parent, child.getFather());
    }
    @Test
    public void testIsLastInternalNode2() {
        // Test when keys size is 0
        BTNode<Integer> node1 = new BTNode<>();
        assertFalse(node1.isLastInternalNode());

        // Test when keys size is not 0 but children have keys
        BTNode<Integer> node2 = new BTNode<>();
        node2.getKeys().add(5);
        BTNode<Integer> childNode = new BTNode<>();
        childNode.getKeys().add(10);
        node2.getChildren().add(childNode);
        assertFalse(node2.isLastInternalNode());

        // Test when keys size is not 0 and children have no keys
        BTNode<Integer> node3 = new BTNode<>();
        node3.getKeys().add(5);
        BTNode<Integer> childNode2 = new BTNode<>();
        node3.getChildren().add(childNode2);
        assertTrue(node3.isLastInternalNode());
    }
    @Test
    public void testIsFull() {
        // Test when keys size is equal to order - 1
        BTNode<Integer> node1 = new BTNode<>(3);
        node1.getKeys().add(5);
        node1.getKeys().add(10);
        assertTrue(node1.isFull());

        // Test when keys size is less than order - 1
        BTNode<Integer> node2 = new BTNode<>(3);
        node2.getKeys().add(5);
        assertFalse(node2.isFull());
    }


}
