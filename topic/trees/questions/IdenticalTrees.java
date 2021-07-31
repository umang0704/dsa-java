package topic.trees.questions;

import topic.trees.BinaryTreeNode;

public class IdenticalTrees {
    boolean isIdentical(BinaryTreeNode a, BinaryTreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null) return ((a.key == b.key)
                && isIdentical(a.left, b.left)
                && isIdentical(a.right, b.right));
        return false;
    }
}
