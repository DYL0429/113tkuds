import java.util.*;

public class TreeLevelTraversal {

    // TreeNode 定義
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 將每層節點分別存成List（標準層序遍歷）
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    // 2. 之字形層序遍歷（zigzag）
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    currentLevel.addLast(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(new ArrayList<>(currentLevel));
            leftToRight = !leftToRight; // 方向切換
        }
        return result;
    }

    // 3. 只印每層最後一個節點（給定層序結果）
    public static void printLastNodeEachLevel(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            if (!level.isEmpty()) {
                System.out.print(level.get(level.size() - 1) + " ");
            }
        }
        System.out.println();
    }

    // 主程式示範
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 1. 標準層序遍歷
        System.out.println("標準層序遍歷:");
        List<List<Integer>> levels = levelOrder(root);
        System.out.println(levels);
        System.out.print("每層最後節點: ");
        printLastNodeEachLevel(levels);  // 輸出: 1 3 7

        // 2. 之字形層序遍歷
        System.out.println("之字形層序遍歷:");
        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        System.out.println(zigzag);
        System.out.print("每層最後節點: ");
        printLastNodeEachLevel(zigzag);  // 輸出: 1 2 7
    }
}