import java.util.*;

public class F09_BinaryTreeLeftView {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        TreeNode root = buildTree(input);
        List<Integer> leftView = getLeftView(root);

        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
    }

    // 根據層序陣列建立二元樹
    public static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < data.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < data.length && !data[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < data.length && !data[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 層序 BFS 取得左視圖
    public static List<Integer> getLeftView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 拿第一個節點值做為左視圖
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) view.add(node.val); // 第一個節點
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return view;
    }
}