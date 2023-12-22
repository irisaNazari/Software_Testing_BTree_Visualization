package IntegrationTesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class cloneCreateTest {
    @Test
    public void testInsertionAndSearch() {
        BTree<Integer> bTree = new BTree<>(3);

        // Insert keys
        bTree.insert(10);
        bTree.insert(5);
        bTree.insert(15);

        // Search for keys
        assertNotNull(bTree.getNode(10));
        assertNotNull(bTree.getNode(5));
        assertNotNull(bTree.getNode(15));
        assertNull(bTree.getNode(7));  // Not inserted
    }

    @Test
    public void testDeletion() {
        BTree<Integer> bTree = new BTree<>(3);

        // Insert keys
        bTree.insert(10);
        bTree.insert(5);
        bTree.insert(15);

        // Delete keys
        bTree.delete(5);
        assertNull(bTree.getNode(5));

        // Attempt to delete a non-existing key
        bTree.delete(7);
        assertNotNull(bTree.getNode(10));
        assertNotNull(bTree.getNode(15));
    }

    @Test
    public void testTreeStructure() {
        BTree<Integer> bTree = new BTree<>(3);

        // Insert keys to cause tree growth
        for (int i = 1; i <= 10; i++) {
            bTree.insert(i);
        }

        // Verify BTree properties
        assertEquals(2, bTree.getHeight());

        // Delete keys to cause tree shrinkage
        for (int i = 1; i <= 5; i++) {
            bTree.delete(i);
        }

        // Verify BTree properties
        assertEquals(1, bTree.getHeight());
    }

    @Test
    public void testSerializationAndDeserialization() {
        BTree<Integer> bTree = new BTree<>(3);

        // Insert keys
        for (int i = 1; i <= 5; i++) {
            bTree.insert(i);
        }

        // Serialize and deserialize
        BTree<Integer> deserializedTree = cloneCreate.clone(bTree);

        // Verify that the deserialized tree is equal to the original
        assertEquals(bTree.getTreeSize(), deserializedTree.getTreeSize());
        assertEquals(bTree.getHeight(), deserializedTree.getHeight());
        // Add more assertions based on your implementation details
    }
}
