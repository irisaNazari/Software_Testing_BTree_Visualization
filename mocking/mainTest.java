package mocking;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class mainTest {
    @Mock
    private BTreePane btPane;

    @Mock
    private BTree<Integer> bTree;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertValue() {
        Main main = new Main();
        main.setBTree(bTree);
        main.setBtPane(btPane);

        // Mock the behavior of BTree and BTreePane
        when(bTree.getStepTrees()).thenReturn(new LinkedList<>());
        when(bTree.getHeight()).thenReturn(1);

        // Call the insertValue method
        main.insertValue();

        // Verify that certain methods were called
        verify(btPane, times(1)).updatePaneLayout(bTree);
        verify(btPane, times(1)).checkNext();

        // You can also use assertions to check the state of your Main class
        assertEquals(1, Main.vertices);
    }
}
