public class TreeStatistics {

    // 定義 TreeNode 類別
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 計算節點總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    // 2a. 找出最大值
    public static int max(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    // 2b. 找出最小值
    public static int min(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(min(root.left), min(root.right)));
    }

    // 3. 計算葉節點數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 4. 計算樹的深度（高度）
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // 測試主程式
    public static void main(String[] args) {
        // 建立一棵簡單的樹
        /*
                 5
               /   \
              3     8
             / \     \
            1   4     10
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(10);

        // 呼叫各方法
        System.out.println("節點總和: " + sum(root));                // 31
        System.out.println("最大值: " + max(root));                 // 10
        System.out.println("最小值: " + min(root));                 // 1
        System.out.println("葉節點數: " + countLeaves(root));       // 3
        System.out.println("樹的深度: " + depth(root));             // 3
    }
}