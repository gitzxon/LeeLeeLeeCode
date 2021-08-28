package study.tree.BinaryTreeTraversal.learn1.template.postorder;

import study.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                result.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return result;
    }
}