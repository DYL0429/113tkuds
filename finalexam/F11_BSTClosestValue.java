import java.util.*;

public class F11_BSTClosestValue {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 輸入 BST 層序序列 (-1 表 null)
        String[] nodes = sc.nextLine().split(" ");
        TreeNode root = buildTree(nodes);

        int target = sc.nextInt();

        int closest = findClosestValue(root, target);
        System.out.println(closest);
    }

    // 建樹 (同先前方法)
    public static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < data.length) {
            TreeNode curr = q.poll();
            if (i < data.length && !data[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(data[i]));
                q.offer(curr.left);
            }
            i++;
            if (i < data.length && !data[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(data[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 迭代尋找 BST 中與 target 差最小的節點值，差同取較小
    public static int findClosestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode current = root;

        while (current != null) {
            int currDiff = Math.abs(current.val - target);
            int closestDiff = Math.abs(closest - target);

            if (currDiff < closestDiff || (currDiff == closestDiff && current.val < closest)) {
                closest = current.val;
            }

            if (target < current.val) {
                current = current.left;
            } else if (target > current.val) {
                current = current.right;
            } else {
                // exact match
                break;
            }
        }
        return closest;
    }
}
