import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀入整數 n
        int n = scanner.nextInt();
        int sum = 0;

        // 加總 n 個整數
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            sum += num;
        }

        // 輸出總和與操作次數
        System.out.println(sum);
        System.out.println(n);

        scanner.close();
    }
}