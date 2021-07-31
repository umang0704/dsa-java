package topic.trees;

public class BalancedTree {
    public static boolean solNaive(BinaryTreeNode root) {
        if (root == null) return true;

        int hl = OperationsBinaryTree.height(root);
        int hr = OperationsBinaryTree.height(root);
        return (Math.abs(hl - hr) <= 1 &&
                solNaive(root.left) &&
                solNaive(root.right));
    }

    public static int solEfficient(BinaryTreeNode root) {
        if (root == null) return 0;
        int hl = solEfficient(root.left);
        if (hl == -1) return -1;
        int hr = solEfficient(root.right);
        if (hr == -1) return -1;
        return Math.abs(hl - hr) > 1 ? -1 : Math.max(hl, hr) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(30);
        root.right.left = new BinaryTreeNode(15);
        root.right.right = new BinaryTreeNode(20);

        System.out.println(solNaive(root));
        System.out.println(solEfficient(root));

    }
}
