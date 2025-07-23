import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 找出所有根到葉的路徑
    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        dfsPaths(root, new ArrayList<>(), paths);
        return paths;
    }

    private static void dfsPaths(TreeNode node, List<Integer> current, List<List<Integer>> paths) {
        if (node == null) return;
        current.add(node.val);
        if (node.left == null && node.right == null) {  // 到葉子了
            paths.add(new ArrayList<>(current));
        } else {
            dfsPaths(node.left, current, paths);
            dfsPaths(node.right, current, paths);
        }
        current.remove(current.size() - 1);
    }

    // 2. 判斷是否存在和為 target 的根到葉路徑
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        return hasPathSum(root.left, target - root.val)
                || hasPathSum(root.right, target - root.val);
    }

    // 3. 找出和最大的根到葉路徑
    public static List<Integer> maxSumPath(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return maxSumPathHelper(root).path;
    }

    // 輔助類別，保存最大和及對應路徑
    static class Result {
        int maxSum;
        List<Integer> path;
        Result(int sum, List<Integer> p) {
            maxSum = sum;
            path = p;
        }
    }

    private static Result maxSumPathHelper(TreeNode node) {
        if (node == null) return new Result(Integer.MIN_VALUE, new ArrayList<>());
        if (node.left == null && node.right == null) {
            return new Result(node.val, new ArrayList<>(List.of(node.val)));
        }

        Result left = maxSumPathHelper(node.left);
        Result right = maxSumPathHelper(node.right);

        if (left.maxSum > right.maxSum) {
            List<Integer> path = new ArrayList<>();
            path.add(node.val);
            path.addAll(left.path);
            return new Result(node.val + left.maxSum, path);
        } else {
            List<Integer> path = new ArrayList<>();
            path.add(node.val);
            path.addAll(right.path);
            return new Result(node.val + right.maxSum, path);
        }
    }

    // 測試程式
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(15);

        // 1. 所有根到葉路徑
        System.out.println("所有根到葉路徑:");
        List<List<Integer>> paths = allRootToLeafPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        // 2. 判斷是否存在和為 22 的路徑
        System.out.println("是否存在和為 22 的路徑: " + hasPathSum(root, 22));  // true (10->5->7)

        // 3. 找出和最大的根到葉路徑
        System.out.println("和最大的根到葉路徑: " + maxSumPath(root));  // [10,12,15]
    }
}