import java.util.*;

public class F12_TreeDiameter {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 輸入層序序列 (-1 表 null)
        String[] nodes = sc.nextLine().split(" ");
        TreeNode root = buildTree(nodes);

        int diameter = treeDiameter(root);
        System.out.println(diameter);
    }

    // 建樹 (與先前相同)
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

    static int maxDiameter = 0;

    // 主函式：取得直徑
    public static int treeDiameter(TreeNode root) {
        maxDiameter = 0;
        dfsHeight(root);
        return maxDiameter;
    }

    // 後序遞迴：回傳節點高度，同時更新直徑
    private static int dfsHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfsHeight(node.left);
        int rightHeight = dfsHeight(node.right);

        // 以此節點為樞紐的最大路徑長（邊數） = 左高 + 右高
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // 回傳此節點高度 = max(左高,右高)+1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
