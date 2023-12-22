package IntegrationTesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BTNodeTest {
    @Test
    void testNodeInteractionWithBTree() {
        // Create a BTree
        BTree<Integer> bTree = new BTree<>(3); // Adjust the order as needed

        // Create nodes for testing
        BTNode<Integer> rootNode = new BTNode<>(3);
        BTNode<Integer> childNode1 = new BTNode<>(3);
        BTNode<Integer> childNode2 = new BTNode<>(3);

        // Add keys to nodes
        rootNode.addKey(0, 10);
        rootNode.addKey(1, 20);

        childNode1.addKey(0, 5);
        childNode1.addKey(1, 8);

        childNode2.addKey(0, 15);
        childNode2.addKey(1, 18);

        // Set up the tree structure
        rootNode.addChild(0, childNode1);
        rootNode.addChild(1, childNode2);

        // Set up the relationships
        childNode1.setFather(rootNode);
        childNode2.setFather(rootNode);

        // Insert the root node into the BTree
        bTree.setRoot(rootNode);

        // Perform actions and assertions based on the integration scenario
        // For example, insert a key into the BTree and check if it reflects in the node
        bTree.insert(25);

        // Assert that the node now contains the new key
        assertTrue(rootNode.getKeys().contains(25));
    }
    }
