public class SimpleBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 遞迴列印樹的結構（右邊在上）
    public static void printTree(TreeNode node, int depth) {
        if (node == null) return;

        printTree(node.right, depth + 1);
        System.out.println("  ".repeat(depth) + node.data);
        printTree(node.left, depth + 1);
    }

    public static void main(String[] args) {
        // 建立一個簡單的二元樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 原始列印方式
        System.out.println("樹的結構:");
        System.out.println("根節點: " + root.data);
        System.out.println("左子樹: " + root.left.data);
        System.out.println("右子樹: " + root.right.data);
        System.out.println("左子樹的左子樹: " + root.left.left.data);
        System.out.println("左子樹的右子樹: " + root.left.right.data);

        // 視覺化列印整棵樹
        System.out.println("\n樹狀圖:");
        printTree(root, 0);
    }
}