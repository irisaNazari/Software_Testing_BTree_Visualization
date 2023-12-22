package CodeBasedTesting.statement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.JOptionPane;

public class MainStatementTest {
    private Main main;

    @BeforeEach
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testInsertValueWithBlankInputException() {
        main.keyText.setText(""); // Set the keyText to an empty string

        assertDoesNotThrow(() -> main.insertValue());

        // Add assertions based on expected behavior, for example, checking if a warning dialog is displayed
        assertEquals("Warning!", main.lastWarningDialogTitle);
        assertEquals("No data entered!", main.lastWarningDialogMessage);
    }

    @Test
    public void testInsertValueWithNumberFormatException() {
        main.keyText.setText("abc"); // Set the keyText to a non-numeric string

        assertDoesNotThrow(() -> main.insertValue());

        // Add assertions based on expected behavior, for example, checking if a warning dialog is displayed
        assertEquals("Warning!", main.lastWarningDialogTitle);
        assertEquals("Illegal input data!", main.lastWarningDialogMessage);
    }

    @Test
    public void testInsertValueWithSuccessfulInsertion() {
        main.keyText.setText("42"); // Set a valid numeric value

        assertDoesNotThrow(() -> main.insertValue());

        // Add assertions based on expected behavior, for example, checking if historyText is updated
        assertEquals(">>>Added Node: 42", main.historyText.getText());
    }

    @Test
    public void testDeleteValueWithBlankInputException() {
        main.keyText.setText(""); // Set the keyText to an empty string

        assertDoesNotThrow(() -> main.deleteValue());

        // Add assertions based on expected behavior, for example, checking if a warning dialog is displayed
        assertEquals("Warning!", main.lastWarningDialogTitle);
        assertEquals("No data entered!", main.lastWarningDialogMessage);
    }

    @Test
    public void testDeleteValueWithNumberFormatException() {
        main.keyText.setText("xyz"); // Set the keyText to a non-numeric string

        assertDoesNotThrow(() -> main.deleteValue());

        // Add assertions based on expected behavior, for example, checking if a warning dialog is displayed
        assertEquals("Warning!", main.lastWarningDialogTitle);
        assertEquals("Illegal input data!", main.lastWarningDialogMessage);
    }

    @Test
    public void testDeleteValueWithKeyNotInTree() {
        main.keyText.setText("99"); // Set a key that is not in the tree

        assertDoesNotThrow(() -> main.deleteValue());

        // Add assertions based on expected behavior, for example, checking if historyText is updated
        assertEquals("Not in the tree!", main.lastWarningDialogMessage);
    }

}
