package CodeBasedTesting.statement;
import static org.junit.Assert.*;
import org.junit.Test;

public class BTNodeStatementTest {

    @Test
    public void testIsLastInternalNode() {
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
