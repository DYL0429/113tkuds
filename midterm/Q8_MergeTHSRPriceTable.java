import java.util.*;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] stations = new String[n];
        int[][] price = new int[n][2];  // [i][0]=Standard, [i][1]=Business

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            stations[i] = parts[0];
            price[i][0] = Integer.parseInt(parts[1]);
            price[i][1] = Integer.parseInt(parts[2]);
        }

        // 輸出表頭
        System.out.println("Station|Standard|Business");

        // 輸出每站票價資料
        for (int i = 0; i < n; i++) {
            // 站名左對齊寬10，Standard/Biz 右對齊寬9
            System.out.printf("%-10s|%9d|%9d\n",
                stations[i], price[i][0], price[i][1]);
        }

        sc.close();
    }
}