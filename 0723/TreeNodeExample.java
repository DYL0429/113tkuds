public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // 顯示節點基本資訊
        public void displayNode() {
            System.out.println("節點值: " + data);
            System.out.println("左子節點: " + (left != null ? left.data : "null"));
            System.out.println("右子節點: " + (right != null ? right.data : "null"));
        }
    }

    // 印出樹的結構（倒過來印，右子樹在上）
    public static void printTree(TreeNode node, int depth) {
        if (node == null) return;

        printTree(node.right, depth + 1); // 先印右子節點
        System.out.println("  ".repeat(depth) + node.data); // 印當前節點，前面補空白表示深度
        printTree(node.left, depth + 1); // 再印左子節點
    }

    public static void main(String[] args) {
        // 建立樹
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = node1;
        leftChild.right = node2;

        // 印出每個節點資訊
        System.out.println("節點資訊：");
        root.displayNode();
        leftChild.displayNode();
        rightChild.displayNode();
        node1.displayNode();
        node2.displayNode();

        // 印出整棵樹的圖形結構
        System.out.println("\n樹狀結構如下：");
        printTree(root, 0);
    }
}