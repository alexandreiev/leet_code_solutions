package com.alex.andreiev.tree.easy;

import com.alex.andreiev.utils.TreeNode;

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        var tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
