package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(2);
        //root.right = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(3);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.right = new TreeNode(4);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }
}

/**
 * 思路：对每个结点的左儿子和右儿子进行深度优先遍历，获取到当前结点的最大儿子深度。因此需要
 *  定义一个新的方法来获取结点的左右最大深度。在isBalanced方法中对结点的左右儿子都获取
 *  最大深度，对这两个深度进行判断是否超出范围，超出范围返回false，没有超出范围返回true
 *  对isBalanced方法进行递归，每个结点都执行这个操作。
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = search(root.left);
        int r = search(root.right);
        if (Math.abs(l-r)>1)return false;
        boolean flag = isBalanced(root.left);
        if (!flag)return false;
        return isBalanced(root.right);
    }

    int search(TreeNode root) {
        if (root == null) return 0;
        int l, r;
        l = 1 + search(root.left);
        r = 1 + search(root.right);
        return Math.max(l, r);
    }
}