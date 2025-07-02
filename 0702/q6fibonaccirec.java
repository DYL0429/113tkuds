import java.util.Scanner;

public class q6fibonaccirec {
    static int ops = 0; // 統計遞迴呼叫次數

    public static int fib(int n) {
        ops++; // 每次呼叫遞增
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 讀入 n (0 ≤ n ≤ 40)

        int result = fib(n);
        System.out.println(result); // 輸出 F(n)
        System.out.println(ops);    // 輸出遞迴呼叫次數

        scanner.close();
    }
}