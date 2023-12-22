package FunctionalTesting;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TestBTNode {
    @Test
    public void testIsLastInternalNode() {
        BTNode<Integer> nodeUnderTest = new BTNode<>(/* Constructor parameters */);

        // Test when no keys in the node
        assertTrue(nodeUnderTest.isLastInternalNode());

        // Test when one child with keys, others without keys
        // Add keys to some children
        assertFalse(nodeUnderTest.isLastInternalNode());

        // Test when all children without keys
        nodeUnderTest.getChildren().clear();
        assertTrue(nodeUnderTest.isLastInternalNode());

        // Test when all children with keys
        // Add keys to all children
        assertFalse(nodeUnderTest.isLastInternalNode());
    }
    @Test
    public void testIsLastInternalNode() {
        BTNode<Integer> nodeUnderTest = new BTNode<>(/* Constructor parameters */);

        // Test when no keys in the node
        assertTrue(nodeUnderTest.isLastInternalNode());

        // Test when one child with keys, others without keys
        // Add keys to some children
        assertFalse(nodeUnderTest.isLastInternalNode());

        // Test when all children without keys
        nodeUnderTest.getChildren().clear();
        assertTrue(nodeUnderTest.isLastInternalNode());

        // Test when all children with keys
        // Add keys to all children
        assertFalse(nodeUnderTest.isLastInternalNode());
    }
    @Test
    public void testIsNull() {
        BTNode<Integer> nodeUnderTest = new BTNode<>(/* Constructor parameters */);

        // Test when node is empty
        assertTrue(nodeUnderTest.isNull());

        // Test when node has keys
        // Add keys
        assertFalse(nodeUnderTest.isNull());
    }

    @Test
    public void testGetSize() {
        BTNode<Integer> nodeUnderTest = new BTNode<>(/* Constructor parameters */);

        // Test when node is empty
        assertEquals(0, nodeUnderTest.getSize());

        // Test when node has one key
        // Add one key
        assertEquals(1, nodeUnderTest.getSize());

        // Test when node has keys up to the maximum limit (order - 1)
        // Add keys up to the limit
        assertEquals(/* order - 1 */, nodeUnderTest.getSize());
    }
}
