import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] parts = sc.nextLine().split(" ");
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(parts[i]);
        }

        // 第一次走訪：計數五星攤位
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("None");
        } else {
            // 第二次走訪：記錄索引
            int[] idx = new int[count];
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 5) {
                    idx[j++] = i;
                }
            }

            // 輸出結果
            for (int i = 0; i < count; i++) {
                System.out.print(idx[i]);
                if (i < count - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}