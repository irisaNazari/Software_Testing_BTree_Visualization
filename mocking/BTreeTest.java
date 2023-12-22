package mocking;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BTreeTest {
    @Test
    void testInsert() {
        // Create a BTree with a specific order
        BTree<Integer> bTree = new BTree<>(3);

        // Create a mock BTNode
        BTNode<Integer> mockNode = mock(BTNode.class);

        // Set up the mock behavior
        when(mockNode.getSize()).thenReturn(0);
        when(mockNode.getChild(0)).thenReturn(new BTNode<>());
        when(mockNode.getKey(0)).thenReturn(42);

        // Set the mock node as the root of the BTree
        bTree.setRoot(mockNode);

        // Perform the insert operation
        bTree.insert(42);

        // Verify that the mockNode's methods were called as expected
        verify(mockNode, times(1)).getSize();
        verify(mockNode, times(1)).getChild(0);
        verify(mockNode, times(1)).getKey(0);

        // Add more assertions based on your actual implementation and requirements
    }

    @Test
    void testDelete() {
        // Create a BTree with a specific order
        BTree<Integer> bTree = new BTree<>(3);

        // Create a mock BTNode
        BTNode<Integer> mockNode = mock(BTNode.class);

        // Set up the mock behavior
        when(mockNode.getSize()).thenReturn(1);
        when(mockNode.getChild(0)).thenReturn(new BTNode<>());
        when(mockNode.getKey(0)).thenReturn(42);

        // Set the mock node as the root of the BTree
        bTree.setRoot(mockNode);

        // Perform the delete operation
        bTree.delete(42);

        // Verify that the mockNode's methods were called as expected
        verify(mockNode, times(1)).getSize();
        verify(mockNode, times(1)).getChild(0);
        verify(mockNode, times(1)).getKey(0);

        // Add more assertions based on your actual implementation and requirements
    }
}
