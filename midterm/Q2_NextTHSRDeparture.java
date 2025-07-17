import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        String[] timeStrs = new String[n];

        // 讀入時刻並轉為分鐘，同時保留原始字串
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            timeStrs[i] = t;
            times[i] = toMinutes(t);
        }

        String queryStr = sc.nextLine();
        int queryTime = toMinutes(queryStr);

        // 二分搜尋下一班 > queryTime 的時刻
        int left = 0, right = n - 1, idx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrs[idx]);
        }

        sc.close();
    }

    // 時間字串轉換為總分鐘數
    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}



/*
 * Time Complexity: O(log n)
 * 說明：利用二分搜尋在排序好的班次時間中尋找第一個大於查詢時間的索引。
 */