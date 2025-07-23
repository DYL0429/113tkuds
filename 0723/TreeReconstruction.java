import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ------------------------
    // 1. 前序 + 中序重建
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length -1,
                          inorder, 0, inorder.length -1, inMap);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPreIn(preorder, preStart +1, preStart + leftTreeSize,
                              inorder, inStart, inRootIndex -1, inMap);
        root.right = buildPreIn(preorder, preStart + leftTreeSize +1, preEnd,
                               inorder, inRootIndex +1, inEnd, inMap);
        return root;
    }

    // ------------------------
    // 2. 後序 + 中序重建
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length)
            return null;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length -1,
                           inorder, 0, inorder.length -1, inMap);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + leftTreeSize -1,
                               inorder, inStart, inRootIndex -1, inMap);
        root.right = buildPostIn(postorder, postStart + leftTreeSize, postEnd -1,
                                inorder, inRootIndex +1, inEnd, inMap);
        return root;
    }

    // ------------------------
    // 3. 驗證：印出前序、中序、後序遍歷

    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    // ------------------------
    // 主程式測試
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode rootFromPreIn = buildTreeFromPreIn(preorder, inorder);
        System.out.println("從前序 + 中序重建:");
        System.out.print("前序: ");
        printPreOrder(rootFromPreIn);
        System.out.println();
        System.out.print("中序: ");
        printInOrder(rootFromPreIn);
        System.out.println();
        System.out.print("後序: ");
        printPostOrder(rootFromPreIn);
        System.out.println("\n");

        TreeNode rootFromPostIn = buildTreeFromPostIn(postorder, inorder);
        System.out.println("從後序 + 中序重建:");
        System.out.print("前序: ");
        printPreOrder(rootFromPostIn);
        System.out.println();
        System.out.print("中序: ");
        printInOrder(rootFromPostIn);
        System.out.println();
        System.out.print("後序: ");
        printPostOrder(rootFromPostIn);
        System.out.println();
    }
}