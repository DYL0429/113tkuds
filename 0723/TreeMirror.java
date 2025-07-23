public class TreeMirror {

    // 定義 TreeNode 類別
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 判斷樹是否對稱（左右互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 2. 將一棵樹轉成鏡像（左右子樹互換）
    public static void mirror(TreeNode root) {
        if (root == null) return;

        // 先遞迴鏡像左右子樹
        mirror(root.left);
        mirror(root.right);

        // 再交換左右子樹
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // 3. 判斷兩棵樹是否互為鏡像
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    //  測試用前序列印（方便觀察鏡像結果）
    public static void preOrderPrint(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("是否對稱: " + isSymmetric(root));  // true

        System.out.print("鏡像前: ");
        preOrderPrint(root);  // 1 2 3 4 2 4 3
        System.out.println();

        mirror(root);
        System.out.print("鏡像後: ");
        preOrderPrint(root);  // 1 2 3 4 2 4 3（左右對調順序）
        System.out.println();

        // 建立另一棵與原樹鏡像的樹來測試 isMirror
        TreeNode mirrorTree = new TreeNode(1);
        mirrorTree.left = new TreeNode(2);
        mirrorTree.right = new TreeNode(2);
        mirrorTree.left.left = new TreeNode(4);
        mirrorTree.left.right = new TreeNode(3);
        mirrorTree.right.left = new TreeNode(3);
        mirrorTree.right.right = new TreeNode(4);

        System.out.println("是否互為鏡像: " + isMirror(root, mirrorTree));  // true
    }
}