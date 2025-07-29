import java.util.*;

public class F06_ArraySecondLargest {

    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    // 遞迴合併找最大與第二大
    public static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;

        Pair leftPair = findSecondMax(arr, left, mid);
        Pair rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        }

        return new Pair(max, second);
    }
}

/*
 * 時間複雜度分析：
 * - 每層遞迴將陣列分半，總共 log n 層，且每層合併花 O(1)
 * - 所以整體遞迴過程遍歷所有元素一次：O(n)
 * => 總時間複雜度：O(n)

 * 空間複雜度分析：
 * - 陣列為輸入：O(n)
 * - 遞迴呼叫堆疊深度為 O(log n)
 * - 每層回傳一個 Pair 物件：O(1)
 * => 總空間複雜度：O(log n)（額外空間，不含輸入）
 */