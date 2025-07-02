import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();      // 讀入元素個數
        int[] arr = new int[n];         // 陣列本身雖不影響計算，但根據格式還是讀取

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int pairCount = 0;

        // 使用雙層迴圈計算不同索引的成對數量
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairCount++;  // 每一對不同索引 (i, j)
            }
        }

        // 輸出成對數量與操作次數
        System.out.println(pairCount);
        System.out.println(pairCount); // ops 就是 pairCount 次
        scanner.close();
    }
}