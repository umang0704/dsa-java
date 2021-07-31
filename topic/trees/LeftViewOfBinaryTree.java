package topic.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    private static int maxLevel = 0;

    private static void op(BinaryTreeNode root, int level) {
        if (root == null) return;
        if (level > maxLevel) {
            System.out.println(root.key);
            maxLevel = level;
        }
        op(root.left, level + 1);
        op(root.right, level + 1);
    }

    public static void sol2(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                BinaryTreeNode t = q.poll();
                if (i == 0) System.out.println(t.key);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
    }

    public static void print(BinaryTreeNode root) {
        op(root, 1);
    }
}
