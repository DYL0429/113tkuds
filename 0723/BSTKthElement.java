public class BSTKthElement {

    // 定義 TreeNode
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 包裝類：用來記錄目前走訪次數與結果
    static class Counter {
        int count = 0;   // 計數器
        int result = -1; // 結果（預設為 -1，視情況可處理找不到）
    }

    // 主要方法：找出第 k 小元素
    public static int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inOrderFind(root, k, counter);
        return counter.result;
    }

    // 中序走訪 + 提早中止
    private static void inOrderFind(TreeNode node, int k, Counter counter) {
        if (node == null || counter.count >= k) return;

        inOrderFind(node.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = node.val;
            return;
        }

        inOrderFind(node.right, k, counter);
    }

    // 輔助：插入節點（建 BST）
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // 主程式測試
    public static void main(String[] args) {
        
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("第 1 小元素: " + kthSmallest(root, 1)); // 5
        System.out.println("第 3 小元素: " + kthSmallest(root, 3)); // 15
        System.out.println("第 5 小元素: " + kthSmallest(root, 5)); // 25
    }
}