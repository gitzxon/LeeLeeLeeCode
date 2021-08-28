package study.tree.BinaryTreeTraversal.learn1.inorder;

import study.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}