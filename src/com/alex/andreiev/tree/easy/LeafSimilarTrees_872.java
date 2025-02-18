package com.alex.andreiev.tree.easy;

import com.alex.andreiev.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Consider all the leaves of a binary tree, from left to right order,
the values of those leaves form a leaf value sequence.
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false

Constraints:
    The number of nodes in each tree will be in the range [1, 200].
    Both of the given trees will have values in the range [0, 200].
 */

public class LeafSimilarTrees_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var list1 = new ArrayList<Integer>();
        dfs(root1, list1);

        var list2 = new ArrayList<Integer>();
        dfs(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }

        for (var i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root, List<Integer> resultList) {
        if (root.right == null && root.left == null) {
            resultList.add(root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, resultList);
        }

        if (root.right != null) {
            dfs(root.right, resultList);
        }
    }
}
