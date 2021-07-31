package topic.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
    public static void inorder(BinaryTreeNode root) {
        if (root != null) {
            postorder(root.left);
            System.out.print(root.key);
            postorder(root.right);
        }
    }

    public static void postorder(BinaryTreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key);
        }
    }

    public static void preorder(BinaryTreeNode root) {
        if (root != null) {

            System.out.print(root.key);
            inorder(root.left);
            inorder(root.right);
        }
    }

    public static void levelOrder(BinaryTreeNode root){
        if(root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode t = q.poll();
            System.out.println(t.key);
            if(t.left!=null) q.offer(t.left);
            if(t.right!=null) q.offer(t.right);
        }
    }

    public static void main(String[] args) {
//        BinaryTreeNode root=new BinaryTreeNode(10);
//        root.left=new BinaryTreeNode(20);
//        root.right=new BinaryTreeNode(30);
//        root.left.left=new BinaryTreeNode(40);
//        root.left.right=new BinaryTreeNode(50);
//        root.right.left=new BinaryTreeNode(60);
//        root.right.right=new BinaryTreeNode(70);
        BinaryTreeNode root=new BinaryTreeNode(20);
        root.left=new BinaryTreeNode(8);
        root.right=new BinaryTreeNode(12);
        root.right.left=new BinaryTreeNode(3);
        root.right.right=new BinaryTreeNode(9);
        System.out.println(ChildrenSumProperty.sol(root));
    }

}
