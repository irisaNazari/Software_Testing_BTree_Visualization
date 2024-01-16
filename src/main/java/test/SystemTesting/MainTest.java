package test.SystemTesting;

import application.Main;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextMatchers.hasText;

public class MainTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        new Main().start(primaryStage);
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Setup test conditions before each test, if needed
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
        clickOn("#keyText").write("42");
        clickOn("#insertButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Added Node: 42"));
    }

    @Test
    public void testDeletion() {
        clickOn("#keyText").write("42");
        clickOn("#deleteButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("Deleted Node: 42"));
    }

    @Test
    public void testSearch() {
        clickOn("#keyText").write("42");
        clickOn("#searchButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Searching Node: 42"));
    }

    @Test
    public void testClearScreen() {
        clickOn("#clearScreenButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Screen cleared!"));
    }

    @Test
    public void testOrderChange() {
        clickOn("#dropDownMenu").clickOn("4");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Screen cleared!"));
        verifyThat("#verticesText", hasText("Vertices\n      0"));
        verifyThat("#heightText", hasText("Height\n     0"));
    }

    @Test
    public void testInvalidInput() {
        clickOn("#keyText").write("InvalidInput");
        clickOn("#insertButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("Illegal input data!"));
    }

    @Test
    public void testEmptyInput() {
        clickOn("#insertButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("No data entered!"));

        clickOn("#deleteButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("No data entered!"));

        clickOn("#searchButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("No data entered!"));
    }

    @Test
    public void testSearchNotFound() {
        clickOn("#keyText").write("999");
        clickOn("#searchButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("Not in the tree!"));
    }

    @Test
    public void testMultipleInsertions() {
        // Test inserting multiple nodes
        clickOn("#keyText").write("42");
        clickOn("#insertButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Added Node: 42"));

        clickOn("#keyText").write("30");
        clickOn("#insertButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Added Node: 30"));

        clickOn("#keyText").write("55");
        clickOn("#insertButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText(">>>Added Node: 55"));
    }

    @Test
    public void testDeletionNotFound() {
        // Test deleting a node that is not in the tree
        clickOn("#keyText").write("999");
        clickOn("#deleteButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("Node not found for deletion: 999"));
    }

    @Test
    public void testSearchEmptyTree() {
        // Test searching in an empty tree
        clickOn("#keyText").write("42");
        clickOn("#searchButton");
        verifyThat("#historyText", isVisible());
        verifyThat("#historyText", hasText("Tree is empty. Cannot search."));
    }
}