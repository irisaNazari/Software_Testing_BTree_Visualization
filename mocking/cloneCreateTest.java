package mocking;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class cloneCreateTest {
    @Test
    public void testBTreeInsert() {
        // Create a BTree instance
        BTree<Integer> bTree = new BTree<>(3);

        // Mock dependencies (if any)
        BTNode<Integer> mockedRoot = Mockito.mock(BTNode.class);
        bTree.setRoot(mockedRoot);

        // Insert elements
        bTree.insert(5);

        // Verify interactions (if any)
        verify(mockedRoot, times(1)).addKey(0, 5);

        // Check if the tree has the correct size
        assertEquals(1, bTree.getTreeSize());
    }

    @Test
    public void testBTreeDelete() {
        // Create a BTree instance
        BTree<Integer> bTree = new BTree<>(3);

        // Mock dependencies (if any)
        BTNode<Integer> mockedRoot = Mockito.mock(BTNode.class);
        bTree.setRoot(mockedRoot);

        // Delete elements
        bTree.delete(5);

        // Verify interactions (if any)
        verify(mockedRoot, times(1)).removeKey(0);

        // Check if the tree has the correct size
        assertEquals(0, bTree.getTreeSize());
    }

    @Test
    public void testBTreeGetHeight() {
        // Create a BTree instance
        BTree<Integer> bTree = new BTree<>(3);

        // Mock dependencies (if any)
        BTNode<Integer> mockedRoot = Mockito.mock(BTNode.class);
        bTree.setRoot(mockedRoot);

        // Test getHeight method
        when(mockedRoot.isLastInternalNode()).thenReturn(true);
        when(mockedRoot.getChild(0)).thenReturn(mockedRoot); // assuming a simple structure for testing

        int height = bTree.getHeight();

        // Verify interactions (if any)
        verify(mockedRoot, times(1)).isLastInternalNode();
        verify(mockedRoot, times(1)).getChild(0);

        // Check if the height is correct
        assertEquals(1, height);
    }
}
