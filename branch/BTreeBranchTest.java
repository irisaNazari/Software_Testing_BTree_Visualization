package CodeBasedTesting.branch;
import static org.junit.Assert.*;
import org.junit.Test;

public class BTreeBranchTest {
    @Test
    public void testBalanceDeletedNode() {
        // Test when balancing a deleted node
        BTree<Integer> bTree1 = new BTree<>(3);
        bTree1.insert(5);
        bTree1.insert(3);
        bTree1.insert(7);
        bTree1.delete(3);  // This will trigger balancing
        // Add assertions to check the balance
    }
}
