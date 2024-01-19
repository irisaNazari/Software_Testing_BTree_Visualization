package test.SystemTesting;

import application.Main;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextMatchers.hasText;

public class MainTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        new Main().start(primaryStage);
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Cleanup after each test, if needed
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testInsertion() {
        clickOn("#key").write("42");
        clickOn("#InsertBut");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals(">>>Added Node: 42", actualText);

    }

    @Test
    public void testDeletion() {
        clickOn("#key").write("42");
        clickOn("#InsertBut");
        clickOn("#key").write("42");
        clickOn("#DeleteBut");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals("Deleted Node: 42", actualText);
    }

    @Test
    public void testSearch() {
        clickOn("#key").write("42");
        clickOn("#InsertBut");
        clickOn("#key").write("42");
        clickOn("#SearchBut");

        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals(">>>Searching Node: 42 :: Animation speed: Medium", actualText);

    }

    @Test
    public void testClearScreen() {
        clickOn("#clearScreenButton");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals(">>>Screen cleared!", actualText);

    }

    @Test
    public void testOrderChange() {
        clickOn("#dropDownMenu").clickOn("4");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals(">>>Screen cleared!", actualText);

        // Verify verticesText
        Label verticesTextLabel = lookup("#verticesText").query();
        String verticesText = verticesTextLabel.getText();
        assertEquals("Vertices\n      0", verticesText);

        // Verify heightText
        Label heightTextLabel = lookup("#heightText").query();
        String heightText = heightTextLabel.getText();
        assertEquals("Height\n     0", heightText);
    }

    @Test
    public void testInvalidInput() {
        clickOn("#key").write("InvalidInput");
        clickOn("#InsertBut");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals("History appears here", actualText);

    }
    /*
    @Test
    public void testEmptyInput() {
        clickOn("#InsertBut");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("No data entered!"));

        clickOn("#DeleteBut");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("No data entered!"));

        clickOn("#SearchBut");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("No data entered!"));
    }

    @Test
    public void testSearchNotFound() {
        clickOn("#key").write("999");
        clickOn("#SearchBut");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("Not in the tree!"));
    }*/

    @Test
    public void testMultipleInsertions() {
        // Test inserting multiple nodes
        clickOn("#key").write("42");
        clickOn("#InsertBut");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals(">>>Added Node: 42", actualText);

        clickOn("#key").write("30");
        clickOn("#InsertBut");
        String actualText1 = historyTextLabel.getText();
        assertEquals(">>>Added Node: 30", actualText1);

        clickOn("#key").write("55");
        clickOn("#InsertBut");
        String actualText2 = historyTextLabel.getText();
        assertEquals(">>>Added Node: 55", actualText2);
    }}

  /*  @Test
    public void testDeletionNotFound() {
        // Test deleting a node that is not in the tree
        clickOn("#key").write("999");
        clickOn("#DeleteBut");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals("Node not found for deletion: 999", actualText);

    }

    @Test
    public void testSearchEmptyTree() {
        // Test searching in an empty tree
        clickOn("#key").write("42");
        clickOn("#SearchBut");
        // Get the actual text from the label
        Label historyTextLabel = lookup("#historyText").query();
        String actualText = historyTextLabel.getText();

        // Verify that the actual text matches the expected text
        assertEquals("Node not found for deletion: 999", actualText);
    }
}*/
