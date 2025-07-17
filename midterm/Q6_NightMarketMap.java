import java.util.*;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 建立地圖並初始化為 #
        char[][] map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(map[i], '#');
        }

        int m = Integer.parseInt(sc.nextLine());  // 攤位數

        // 標示熱門攤位
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split(" ");
            int r = Integer.parseInt(tokens[0]);
            int c = Integer.parseInt(tokens[1]);

            // 若座標合法，覆寫為 *
            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                map[r][c] = '*';
            }
        }

        // 輸出地圖
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();  // 換行
        }

        sc.close();
    }
}

