package test.IntegrationTesting;
import application.Main;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static Stage stage;

    @BeforeAll
    public static void init() {
        // Launch JavaFX application
        Thread thread = new Thread(() -> Application.launch(Main.class));
        thread.setDaemon(true);
        thread.start();

        // Wait for the JavaFX application to be initialized
        try {
            Thread.sleep(3000); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Access the JavaFX application's stage
        stage = Main.getPrimaryStage();
    }

    @AfterAll
    public static void tearDown() {
        // Close the JavaFX application
        if (stage != null) {
            stage.close();
        }
    }

    @Test
    public void testInsertValue() {
        // TODO: Implement your integration test for insertValue() method
        // You can simulate user interactions, input values, and then verify the expected outcome
        // For example, you can use JavaFXTest library or TestFX for UI testing
        // Here, you can test if the inserted value is displayed correctly in the UI or updatePaneLayout() is working as expected
        fail("Not implemented yet");
    }

    @Test
    public void testDeleteValue() {
        // TODO: Implement your integration test for deleteValue() method
        // Similar to testInsertValue(), you can simulate user interactions and verify the expected outcome
        fail("Not implemented yet");
    }

    @Test
    public void testSearchValue() {
        // TODO: Implement your integration test for searchValue() method
        // Simulate user interactions and verify the expected outcome, e.g., checking if the searched node is highlighted
        fail("Not implemented yet");
    }

    // Add more tests for other methods as needed

}