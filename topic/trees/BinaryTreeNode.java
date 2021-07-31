package topic.trees;

public class BinaryTreeNode {
    public int key;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int key) {
        this.key = key;
    }

    public BinaryTreeNode(int key, BinaryTreeNode left, BinaryTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
