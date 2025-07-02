import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];
        int ops = 0;

        // 讀取矩陣 A
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = scanner.nextInt();

        // 讀取矩陣 B
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = scanner.nextInt();

        // 矩陣乘法 C = A x B
        for (int i = 0; i < n; i++) {         // 列
            for (int j = 0; j < n; j++) {     // 行
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    ops += 2; // 一次乘法 + 一次加法
                }
            }
        }

        // 輸出結果矩陣 C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        // 輸出操作次數
        System.out.println(ops);

        scanner.close();
    }
}