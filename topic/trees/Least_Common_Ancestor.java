package topic.trees;

import java.util.ArrayList;

public class Least_Common_Ancestor {
    public static boolean find_path(BinaryTreeNode root, ArrayList<BinaryTreeNode> p, int n) {
        if(root==null) return false;
        p.add(root);
        if(root.key==n) return true;
        if(find_path(root.left,p,n) || find_path(root.right,p,n))
            return true;
        p.remove(p.size()-1);
        return false;
    }

    public static BinaryTreeNode lca1(BinaryTreeNode root, int n1, int n2) {
        ArrayList<BinaryTreeNode> p1 = new ArrayList<>();
        ArrayList<BinaryTreeNode> p2 = new ArrayList<>();
        if (find_path(root, p1, n1) == false || find_path(root, p2, n2) == false)
            return null;
        for (int i = 0; i < p1.size() - 1 && i < p2.size() - 1; i++)
            if(p1.get(i+1)!=p2.get(i+1))
                return p1.get(i);
        return null;
    }

    public static BinaryTreeNode lca2(BinaryTreeNode root,int n1,int n2){
        if(root == null) return null;
        if(root.key==n1 || root.key==n2) return root;

        BinaryTreeNode lca_left_subtree = lca2(root.left,n1,n2);
        BinaryTreeNode lca_right_subtree = lca2(root.right,n1,n2);

        if(lca_left_subtree!=null && lca_right_subtree!=null)
            return root;
        if(lca_left_subtree!=null)
            return lca_left_subtree;
        else
            return lca_right_subtree;
    }

    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(10);
        root.left=new BinaryTreeNode(20);
        root.right=new BinaryTreeNode(30);
        root.right.left=new BinaryTreeNode(40);
        root.right.right=new BinaryTreeNode(50);
        int n1=20,n2=50;

        BinaryTreeNode ans=lca1(root,n1,n2);
        System.out.println("LCA: "+ans.key);
    }
}
