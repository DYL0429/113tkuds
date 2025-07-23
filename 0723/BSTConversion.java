public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // -------- 1. BST 轉雙向鏈結串列 (中序雙向鏈結串列) --------
    // 回傳雙向鏈表的頭節點
    public static TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode[] prev = new TreeNode[1];
        TreeNode[] head = new TreeNode[1];
        inorderToDoublyList(root, prev, head);

        // 使鏈表首尾相連（變成環狀雙向鏈表）
        head[0].left = prev[0];
        prev[0].right = head[0];

        return head[0];
    }

    private static void inorderToDoublyList(TreeNode node, TreeNode[] prev, TreeNode[] head) {
        if (node == null) return;
        inorderToDoublyList(node.left, prev, head);

        if (prev[0] == null) {
            head[0] = node;  // 第一個節點為頭節點
        } else {
            prev[0].right = node;
            node.left = prev[0];
        }
        prev[0] = node;

        inorderToDoublyList(node.right, prev, head);
    }

    // -------- 2. 排序陣列轉平衡BST --------
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length -1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid -1);
        root.right = sortedArrayToBSTHelper(nums, mid +1, right);
        return root;
    }

    // -------- 3. BST轉換，節點值改為大於等於自身節點值的總和 --------
    // 反中序遍歷累加 (右 -> 根 -> 左)
    public static void bstToGreaterSum(TreeNode root) {
        bstToGreaterSumHelper(root, new int[]{0});
    }

    private static void bstToGreaterSumHelper(TreeNode node, int[] sum) {
        if (node == null) return;
        bstToGreaterSumHelper(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        bstToGreaterSumHelper(node.left, sum);
    }

    // -------- 輔助：印中序 --------
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // -------- 輔助：印雙向鏈結串列 --------
    public static void printDoublyList(TreeNode head, int count) {
        TreeNode curr = head;
        for (int i=0; i<count; i++) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    // -------- 主程式測試 --------
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        // 1. BST 轉雙向鏈結串列
        TreeNode head = bstToDoublyList(root);
        System.out.print("雙向鏈結串列節點值: ");
        printDoublyList(head, 6);  // 預期：2 5 7 10 15 20

        // 2. 排序陣列轉平衡BST
        int[] sortedArr = {1,3,5,7,9,11};
        TreeNode balancedRoot = sortedArrayToBST(sortedArr);
        System.out.print("排序陣列轉平衡BST中序: ");
        printInOrder(balancedRoot); // 預期輸出: 1 3 5 7 9 11
        System.out.println();

        // 3. BST轉換為累加樹
        bstToGreaterSum(root);
        System.out.print("BST轉換後(大於等於節點值累加)中序: ");
        printInOrder(root);  // 預期: 59 57 52 45 35 20 (每個節點值為大於等於自己的值總和)
        System.out.println();
    }
}