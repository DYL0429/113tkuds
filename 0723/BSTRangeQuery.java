import java.util.ArrayList;

public class BSTRangeQuery {

    // 定義 TreeNode 類別
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 插入節點（建樹用）
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // 主要方法：範圍查詢，回傳排序的 ArrayList
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    // 中序走訪 + 範圍剪枝
    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        // 只走訪左子樹若有可能包含範圍內的值
        if (node.val > min) {
            inOrderRange(node.left, min, max, result);
        }

        // 如果當前節點在範圍內，加入結果
        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }

        // 只走訪右子樹若有可能包含範圍內的值
        if (node.val < max) {
            inOrderRange(node.right, min, max, result);
        }
    }

    // 測試主程式
    public static void main(String[] args) {
        // 建立 BST：[20, 10, 30, 5, 15, 25, 35]
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        // 查詢範圍 [12, 27]
        ArrayList<Integer> result = rangeQuery(root, 12, 27);
        System.out.println(result);  // 輸出: [15, 20, 25]
    }
}