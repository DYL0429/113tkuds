public static void printReverse(ListNode head) {
    if (head == null) {
        return;
    }
    printReverse(head.next);  // 先遞迴到底
    System.out.print(head.val + " ");  // 再印出節點值
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);

    printReverse(head);  // 輸出：3 2 1
}