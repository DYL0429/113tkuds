import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        int[] times = new int[n];

        // 讀入 n 行已遞增的時間，並轉換為分鐘數
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            times[i] = toMinutes(line);
        }

        // 讀入查詢時間，轉為分鐘數
        String queryStr = sc.nextLine().trim();
        int query = toMinutes(queryStr);

        // 二分搜尋：找出首個大於 query 的索引
        int idx = Arrays.binarySearch(times, query + 1);
        if (idx < 0) {
            idx = -idx - 1;
        }

        if (idx >= n) {
            System.out.println("No bike");
        } else {
            System.out.println(toHHMM(times[idx]));
        }
    }

    // 將 "HH:mm" 轉為總分鐘數
    private static int toMinutes(String hhmm) {
        String[] parts = hhmm.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    // 將分鐘數轉回 "HH:mm" 格式（補零）
    private static String toHHMM(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}

/*
 * 時間複雜度分析：
 * - 讀取並轉換 n 個時間字串：O(n)
 * - 二分搜尋首個大於查詢時間的索引：O(log n)
 * - 結果輸出：O(1)
 * => 總時間複雜度：O(n + log n) = O(n)
 *
 * 空間複雜度分析：
 * - 儲存 n 個時間的陣列：O(n)
 * - 其他輔助變數使用固定空間：O(1)
 * => 總空間複雜度：O(n)
 */