package topic.trees;

import java.util.*;

public class TreeTraversalInSprial {
    public static void fn2(BinaryTreeNode root) {
        if (root == null) return;


        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                BinaryTreeNode t = s1.pop();
                System.out.println(t.key);
                if (t.left != null) s2.push(t.left);
                if (t.right != null) s2.push(t.right);
            }
            while (!s2.isEmpty()){
                BinaryTreeNode t = s2.pop();
                System.out.println(t.key);
                if (t.right != null) s1.push(t.right);
                if (t.left != null) s1.push(t.left);
            }
        }

    }

    public static void fn1(BinaryTreeNode root) {
        if (root == null) return;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        Stack<BinaryTreeNode> b = new Stack<>();

        q.offer(root);

        //false-backward, true-forward
        boolean dir = false;

        while (!q.isEmpty()) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                BinaryTreeNode t = q.poll();

                if (dir)
                    b.push(t);
                else
                    System.out.println(t.key);

                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);

            }

            if (dir)
                while (!b.isEmpty())
                    System.out.println(b.pop().key);

            dir = !dir;
        }

    }

    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.right=new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(5);
        root.right.left=new BinaryTreeNode(6);
        root.right.right=new BinaryTreeNode(7);
        //fn1(root);
        fn2(root);
    }
}
