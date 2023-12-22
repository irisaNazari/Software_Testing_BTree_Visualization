package CodeBasedTesting.condition;
import static org.junit.Assert.*;
import org.junit.Test;

public class BTNodeConditionTest {

    @Test
    public void testIsNull() {
        // Test when keys is empty
        BTNode<Integer> node1 = new BTNode<>();
        assertTrue(node1.isNull());

        // Test when keys is not empty
        BTNode<Integer> node2 = new BTNode<>();
        node2.getKeys().add(5);
        assertFalse(node2.isNull());
    }

}
