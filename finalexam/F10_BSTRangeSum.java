import java.util.*;

public class F10_BSTRangeSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入層序序列建立 BST (-1 表 null)
        String[] nodes = sc.nextLine().split(" ");

        TreeNode root = buildTree(nodes);

        // 輸入區間 L, R
        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println(sum);
    }

    // 建樹（與先前類似）
    public static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < data.length) {
            TreeNode curr = queue.poll();

            if (i < data.length && !data[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(curr.left);
            }
            i++;

            if (i < data.length && !data[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 中序遍歷＋剪枝計算區間和
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;

        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }
}