package topic.trees;

public class BTree_to_DoublyLL {
    private static BinaryTreeNode prev = null;

    public static BinaryTreeNode fn(BinaryTreeNode root) {
        if (root == null) return null;

        BinaryTreeNode head = fn(root.left);

        if (prev == null) prev = head;
        else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;

        fn(root.right);
        return head;

    }

    public static void main(String[] args) {

    }
}
