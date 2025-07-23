import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 計算兩節點距離
    // 利用最近公共祖先(LCA) + 深度計算距離
    public static int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        int distP = distanceFromAncestor(lca, p, 0);
        int distQ = distanceFromAncestor(lca, q, 0);
        return distP + distQ;
    }

    // 求最近公共祖先 (LCA)
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 計算祖先到目標節點距離（邊數）
    private static int distanceFromAncestor(TreeNode ancestor, TreeNode target, int dist) {
        if (ancestor == null) return -1;
        if (ancestor == target) return dist;
        int left = distanceFromAncestor(ancestor.left, target, dist + 1);
        if (left != -1) return left;
        return distanceFromAncestor(ancestor.right, target, dist + 1);
    }

    // 2. 找樹的直徑 (任意兩節點間最大距離)
    // 透過DFS紀錄子樹深度及最大直徑
    public static int treeDiameter(TreeNode root) {
        int[] diameter = new int[1];  // 用陣列模擬引用
        depthForDiameter(root, diameter);
        return diameter[0];
    }

    private static int depthForDiameter(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        int leftDepth = depthForDiameter(node.left, diameter);
        int rightDepth = depthForDiameter(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 3. 找出距離根節點為指定距離的所有節點 (距離指邊數)
    public static List<TreeNode> nodesAtDistance(TreeNode root, int distance) {
        List<TreeNode> result = new ArrayList<>();
        findNodesAtDistance(root, distance, result);
        return result;
    }

    private static void findNodesAtDistance(TreeNode node, int dist, List<TreeNode> res) {
        if (node == null) return;
        if (dist == 0) {
            res.add(node);
            return;
        }
        findNodesAtDistance(node.left, dist -1, res);
        findNodesAtDistance(node.right, dist -1, res);
    }

    // -------- 主程式測試 --------
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        // 1. 計算兩節點距離
        int dist = distanceBetweenNodes(root, root.left.left, root.right.left.left);
        System.out.println("節點4與節點7距離: " + dist);  // 預期：4

        // 2. 計算樹的直徑
        int diameter = treeDiameter(root);
        System.out.println("樹的直徑: " + diameter);  // 預期：5 (4->2->1->3->5->7)

        // 3. 找距離根節點2的所有節點
        List<TreeNode> distNodes = nodesAtDistance(root, 2);
        System.out.print("距離根節點為2的節點值: ");
        for (TreeNode n : distNodes) System.out.print(n.val + " ");
        System.out.println();  // 預期：4 5 6
    }
}