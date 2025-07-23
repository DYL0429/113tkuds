import java.util.*;

public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 判斷兩棵樹是否完全相同（結構和值相同）
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 2. 判斷 t 是否是 s 的子樹 (s 中存在子樹和 t 完全相同)
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true; // 空樹是任何樹的子樹
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3. 找最大公共子樹（最大公共子樹節點數）
    public static int maxCommonSubtreeSize(TreeNode root1, TreeNode root2) {
        Map<String, Integer> memo = new HashMap<>();
        return helperMaxCommon(root1, root2, memo);
    }

    // 輔助方法，計算最大公共子樹節點數
    private static int helperMaxCommon(TreeNode n1, TreeNode n2, Map<String, Integer> memo) {
        String key = (n1 == null ? "N" : n1.val) + "," + (n2 == null ? "N" : n2.val);
        if (memo.containsKey(key)) return memo.get(key);

        if (n1 == null || n2 == null) {
            memo.put(key, 0);
            return 0;
        }

        int res = 0;
        if (n1.val == n2.val) {
            int left = helperMaxCommon(n1.left, n2.left, memo);
            int right = helperMaxCommon(n1.right, n2.right, memo);
            res = 1 + left + right;
        } else {
            // 不匹配時，分別移動左或右子樹找最大公共子樹
            res = Math.max(helperMaxCommon(n1.left, n2, memo),
                           helperMaxCommon(n1.right, n2, memo));
            res = Math.max(res,
                           Math.max(helperMaxCommon(n1, n2.left, memo),
                                    helperMaxCommon(n1, n2.right, memo)));
        }

        memo.put(key, res);
        return res;
    }

    // -------- 主程式測試 --------
    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println("是否完全相同: " + isSameTree(s, t));           // false
        System.out.println("t 是 s 的子樹? " + isSubtree(s, t));          // true
        System.out.println("最大公共子樹節點數: " + maxCommonSubtreeSize(s, t));  // 3
    }
}