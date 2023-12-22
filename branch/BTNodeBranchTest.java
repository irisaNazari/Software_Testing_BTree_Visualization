package CodeBasedTesting.branch;
import static org.junit.Assert.*;
import org.junit.Test;

public class BTNodeBranchTest {

    @Test
    public void testIsOverflow() {
        // Test when keys size is greater than order - 1
        BTNode<Integer> node1 = new BTNode<>(3);
        node1.getKeys().add(5);
        node1.getKeys().add(10);
        assertTrue(node1.isOverflow());

        // Test when keys size is equal to order - 1
        BTNode<Integer> node2 = new BTNode<>(3);
        node2.getKeys().add(5);
        assertFalse(node2.isOverflow());

        // Test when keys size is less than order - 1
        BTNode<Integer> node3 = new BTNode<>(3);
        node3.getKeys().add(5);
        node3.getKeys().add(10);
        assertFalse(node3.isOverflow());
    }
}
