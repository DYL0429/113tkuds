import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 驗證是否為有效BST (利用中序遍歷特性)
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    // 限定節點值的區間 (min, max)
    private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return isValidBSTHelper(node.left, min, node.val)
            && isValidBSTHelper(node.right, node.val, max);
    }

    // 2. 找出不符合BST規則的節點（用中序遍歷找違反遞增的節點）
    public static List<TreeNode> findViolations(TreeNode root) {
        List<TreeNode> violations = new ArrayList<>();
        inorderFindViolations(root, violations, new TreeNode[]{null});
        return violations;
    }

    private static void inorderFindViolations(TreeNode node, List<TreeNode> violations, TreeNode[] prev) {
        if (node == null) return;
        inorderFindViolations(node.left, violations, prev);

        if (prev[0] != null && node.val <= prev[0].val) {
            violations.add(node);
            violations.add(prev[0]);
        }
        prev[0] = node;

        inorderFindViolations(node.right, violations, prev);
    }

    // 3. 計算最少移除節點數讓樹變成有效BST  
    //    (用 LIS 的概念計算中序遍歷結果的「最長嚴格遞增子序列」長度)
    public static int minRemovalsToBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // 找最長嚴格遞增子序列長度
        int lisLength = lengthOfLIS(inorder);
        return inorder.size() - lisLength;
    }

    // 中序遍歷取得節點值序列
    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    // 求嚴格遞增子序列長度（O(n log n) 解法）
    private static int lengthOfLIS(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(dp, num);
            if (idx < 0) idx = -(idx + 1);
            if (idx == dp.size()) dp.add(num);
            else dp.set(idx, num);
        }
        return dp.size();
    }

    // 測試
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println("是否為有效BST: " + isValidBST(root)); // false

        List<TreeNode> violations = findViolations(root);
        System.out.print("不符合BST規則節點值: ");
        for (TreeNode v : violations) {
            System.out.print(v.val + " ");
        }
        System.out.println();

        System.out.println("最少移除節點數讓變成BST: " + minRemovalsToBST(root)); // 2
    }
}