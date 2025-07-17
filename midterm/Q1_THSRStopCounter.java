import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();           // 停靠站數
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();      // 一行輸入的 n 個三碼英文站名
        }

        String start = sc.next();      // 起點
        String end = sc.next();        // 終點

        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }

        sc.close();
    }
}



/*
 * Time Complexity: O(n)
 * 說明：一次走訪陣列找起點與終點索引，n 為停靠站數。
 */