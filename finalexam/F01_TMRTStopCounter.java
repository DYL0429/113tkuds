import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // 讀取停靠站數量
        String[] stops = new String[n];
        
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();  // 讀取各站代碼
        }

        String start = sc.next();  // 起站代碼
        String end = sc.next();    // 終站代碼
        
        int startIdx = -1;
        int endIdx = -1;

        // 找出起站與終站的索引
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
    }
}

/*
 * 時間複雜度分析：
 * - 讀取 n 個停靠站並儲存：O(n)
 * - 搜尋起點與終點索引（最多各掃一次）：O(n)
 * - 結果輸出：O(1)
 * => 總時間複雜度：O(n)
 *
 * 空間複雜度分析：
 * - 儲存 n 個站代碼的陣列：O(n)
 * - 其他變數與輸入使用固定空間：O(1)
 * => 總空間複雜度：O(n)
 */
