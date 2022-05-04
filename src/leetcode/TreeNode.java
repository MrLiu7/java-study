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
 * ˼·����ÿ����������Ӻ��Ҷ��ӽ���������ȱ�������ȡ����ǰ������������ȡ������Ҫ
 *  ����һ���µķ�������ȡ�������������ȡ���isBalanced�����жԽ������Ҷ��Ӷ���ȡ
 *  �����ȣ�����������Ƚ����ж��Ƿ񳬳���Χ��������Χ����false��û�г�����Χ����true
 *  ��isBalanced�������еݹ飬ÿ����㶼ִ�����������
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