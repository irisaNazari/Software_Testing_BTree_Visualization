package PathTesting;

public class BTNodeTest {
    public static void main(String[] args) {
        // Create instances of BTNode for testing
        BTNode<Integer> node1 = new BTNode<>();
        BTNode<Integer> node2 = new BTNode<>(3); // Assuming order is 4

        // Testing isLastInternalNode
        System.out.println("isLastInternalNode Test:");
        System.out.println("Path 1: " + node1.isLastInternalNode()); // Expected: false
        System.out.println("Path 2: " + node2.isLastInternalNode()); // Expected: true
        node2.keys.add(10);
        node2.children.add(new BTNode<>(3));
        System.out.println("Path 3: " + node2.isLastInternalNode()); // Expected: false
        System.out.println();

        // Testing getFather and setFather
        System.out.println("getFather and setFather Test:");
        System.out.println("Path 1: " + (node1.getFather() == null)); // Expected: true
        BTNode<Integer> fatherNode = new BTNode<>(3);
        node1.setFather(fatherNode);
        System.out.println("Path 2: " + (node1.getFather() == fatherNode)); // Expected: true
        System.out.println();

        // Testing getChildren, getChild, addChild, removeChild
        System.out.println("getChildren, getChild, addChild, removeChild Test:");
        BTNode<Integer> childNode1 = new BTNode<>(3);
        BTNode<Integer> childNode2 = new BTNode<>(3);
        node2.addChild(0, childNode1);
        node2.addChild(1, childNode2);
        System.out.println("Path 1: " + (node2.getChildren().size() == 2)); // Expected: true
        System.out.println("Path 2: " + (node2.getChild(0) == childNode1)); // Expected: true
        node2.removeChild(1);
        System.out.println("Path 3: " + (node2.getChildren().size() == 1)); // Expected: true
        System.out.println();

        // Testing getKey, addKey, removeKey
        System.out.println("getKey, addKey, removeKey Test:");
        node1.addKey(0, 5);
        System.out.println("Path 1: " + (node1.getKey(0) == 5)); // Expected: true
        node1.removeKey(0);
        System.out.println("Path 2: " + node1.getKeys().isEmpty()); // Expected: true
        System.out.println();

        // Testing isFull
        System.out.println("isFull Test:");
        System.out.println("Path 1: " + (!node1.isFull())); // Expected: true
        node1.addKey(0, 5);
        node1.addKey(1, 10);
        node1.addKey(2, 15);
        System.out.println("Path 2: " + node1.isFull()); // Expected: true
    }
}
