import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();             // 讀入元素數量
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {          // 讀入已排序陣列
            arr[i] = scanner.nextInt();
        }

        int key = scanner.nextInt();           // 讀入搜尋目標

        int left = 0, right = n - 1;
        int ops = 0;
        int result = -1;

        while (left <= right) {
            ops++;
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                result = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        System.out.println(ops);

        scanner.close();
    }
}