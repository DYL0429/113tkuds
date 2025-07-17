import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());        // 總場次
        String[] tokens = sc.nextLine().split(" ");     // 勝敗紀錄 1 or 0
        int[] games = new int[n];
        for (int i = 0; i < n; i++) {
            games[i] = Integer.parseInt(tokens[i]);
        }

        int k = Integer.parseInt(sc.nextLine());        // 查詢前 k 場

        // 建立前綴和陣列
        int[] prefix = new int[n + 1];  // prefix[0] = 0
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + games[i - 1];
        }

        // 輸出前 k 場的累積勝場
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + prefix[i]);
        }

        System.out.println();  // 換行
        sc.close();
    }
}



/*
 * Time Complexity: O(n)
 * 說明：建構前綴和陣列需一次遍歷 n 場，查詢則為 O(1)。
 */