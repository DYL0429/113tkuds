public static void inOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    inOrder(root.left);          // 先走訪左子樹
    System.out.print(root.val + " "); // 訪問根節點
    inOrder(root.right);         // 再走訪右子樹
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    inOrder(root);  // 輸出結果：4 2 5 1 3
}