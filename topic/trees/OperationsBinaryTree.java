package topic.trees;

import java.util.LinkedList;
import java.util.Queue;

public class OperationsBinaryTree {
    public static int height(BinaryTreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void nodeAtKLevel(BinaryTreeNode root, int k) {
        if (root == null) return;
        if (k == 0) System.out.println(root.key);
        else {
            nodeAtKLevel(root.left, k - 1);
            nodeAtKLevel(root.right, k - 1);
        }
    }

    public static void levelOrderLineByline1(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (q.size() > 1) {
            BinaryTreeNode t = q.poll();
            if (t == null) {
                q.offer(null);
                System.out.println();
                continue;
            }
            System.out.print(t.key + " ");
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
    }

    public static void levelOrderLineByline2(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                BinaryTreeNode t = q.poll();
                System.out.print(t.key + " ");
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            System.out.println();
        }
    }

    public static int sizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) return 0;
        else return 1 + sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right);
    }

    public static int maxInBinaryTree(BinaryTreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        else return (Math.max(root.key, Math.max(maxInBinaryTree(root.left), maxInBinaryTree(root.right))));
    }

}

















