import java.util.Scanner;

public class FactorialExampleinput {

    /**
     * 遞迴計算階乘，並印出計算過程
     * @param n 欲計算階乘的整數
     * @return n 的階乘值
     */
    public static int factorial(int n) {
        // 基底條件：0! 和 1! 都等於 1
        if (n <= 1) {
            System.out.print("1"); // 最後一項只印 1 不加乘號
            return 1;
        }

        // 印出當前階乘項，例如：5 * 4 * ...
        System.out.print(n + " * ");
        
        // 遞迴呼叫計算 (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // 建立 Scanner 物件，用來讀取使用者輸入
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個非負整數：");

        // 檢查輸入是否為整數
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            // 檢查是否為負數
            if (num < 0) {
                System.out.println("錯誤：不能輸入負數！");
            } else {
                // 印出階乘展開式，例如：5! = 5 * 4 * 3 * 2 * 1 = 120
                System.out.print(num + "! = ");
                int result = factorial(num); // 呼叫階乘方法
                System.out.println(" = " + result); // 印出最終結果
            }
        } else {
            // 如果輸入不是整數，顯示錯誤訊息
            System.out.println("錯誤：請輸入正確的整數！");
        }

        // 關閉 Scanner 避免資源浪費
        scanner.close();
    }
}