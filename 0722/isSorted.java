public static boolean isSorted(int[] arr, int index) {
    // 如果到倒數第二個元素或只有一個元素，則視為已排序
    if (index == arr.length - 1 || arr.length <= 1) {
        return true;
    }
    // 若當前元素大於下一個元素，則不是升序
    if (arr[index] > arr[index + 1]) {
        return false;
    }
    // 遞迴檢查下一個元素
    return isSorted(arr, index + 1);
}

public static void main(String[] args) {
    int[] a = {1, 2, 3, 5, 7};
    int[] b = {10, 8, 9};
    System.out.println(isSorted(a, 0)); // true
    System.out.println(isSorted(b, 0)); // false
}