import java.util.*;

public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 檢查是否平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 回傳節點高度，若不平衡回傳 -1
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 2. 計算節點平衡因子 (左高 - 右高)，回傳 Map<節點, 平衡因子>
    public static Map<TreeNode, Integer> balanceFactors(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        computeBalance(root, map);
        return map;
    }

    private static int computeBalance(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        int left = computeBalance(node.left, map);
        int right = computeBalance(node.right, map);
        int bf = left - right;
        map.put(node, bf);
        return Math.max(left, right) + 1;
    }

    // 3. 找出最不平衡節點（平衡因子絕對值最大）
    public static TreeNode mostUnbalancedNode(TreeNode root) {
        Map<TreeNode, Integer> bfMap = balanceFactors(root);
        TreeNode worstNode = null;
        int maxAbsBF = -1;
        for (Map.Entry<TreeNode, Integer> entry : bfMap.entrySet()) {
            int absBF = Math.abs(entry.getValue());
            if (absBF > maxAbsBF) {
                maxAbsBF = absBF;
                worstNode = entry.getKey();
            }
        }
        return worstNode;
    }

    // 輔助：中序印節點值及其平衡因子
    public static void printBalanceFactors(TreeNode root) {
        Map<TreeNode, Integer> map = balanceFactors(root);
        printBalanceFactorsHelper(root, map);
    }

    private static void printBalanceFactorsHelper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return;
        printBalanceFactorsHelper(node.left, map);
        System.out.println("節點 " + node.val + " 平衡因子 = " + map.get(node));
        printBalanceFactorsHelper(node.right, map);
    }

    // -------- 主程式測試 --------
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(25);

        System.out.println("是否為平衡樹: " + isBalanced(root));  // false

        System.out.println("節點平衡因子：");
        printBalanceFactors(root);

        TreeNode worst = mostUnbalancedNode(root);
        System.out.println("最不平衡節點值: " + (worst != null ? worst.val : "無"));
    }
}