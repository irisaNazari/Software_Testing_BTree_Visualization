package IntegrationTesting;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest{
    private BTreePane bTreePane;
    private BTree<Integer> bTree;

    @BeforeEach
    void setUp() {
        // Initialize JavaFX
        new JFXPanel();

        // Initialize your BTree and BTreePane
        bTree = new BTree<>(3);
        bTreePane = new BTreePane(0, 0, bTree);

        // Set up the GUI on the JavaFX Application Thread
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(bTreePane, 600, 400));
            stage.show();
        });
    }

    @AfterEach
    void tearDown() {
        // Clean up resources, close the GUI, etc.
        // Note: This method might need more specific implementation based on your application's structure.
    }

    @Test
    void testInsertValue() {
        Platform.runLater(() -> {
            keyText.setText("42");  // Replace with your actual UI components
            insertButton.fire();    // Replace with your actual UI components
        });
        // Add assertions to verify the state of the BTree or GUI after the insertion
        assertEquals(1, bTree.getHeight());
        assertEquals(">>>Added Node: 42", historyText.getText());
    }

    @Test
    void testDeleteValue() {
        Platform.runLater(() -> {
            keyText.setText("42");  // Replace with your actual UI components
            deleteButton.fire();    // Replace with your actual UI components
        });
        // Add assertions to verify the state of the BTree or GUI after the deletion
        assertEquals(0, bTree.getHeight());  // Assuming it's the last node
        assertEquals("Deleted Node: 42", historyText.getText());
    }

    @Test
    void testSearchValue() {
        Platform.runLater(() -> {
            keyText.setText("42");  // Replace with your actual UI components
            searchButton.fire();    // Replace with your actual UI components
        });
        // Add assertions to verify the state of the BTree or GUI after the search
        assertEquals(">>>Searching Node: 42 :: Animation speed: Medium", historyText.getText());
    }

    @Test
    void testNext() {
        Platform.runLater(() -> nextButton.fire());  // Replace with your actual UI components
        // Add assertions to verify the state of the BTree or GUI after moving to the next step
        // You may need to keep track of the expected state based on the sequence of operations
    }

    @Test
    void testReset() {
        Platform.runLater(() -> resetButton.fire());  // Replace with your actual UI components
        // Add assertions to verify the state of the BTree or GUI after resetting
        assertEquals(0, bTree.getHeight());
        assertEquals(">>>Screen cleared!", historyText.getText());
    }
}