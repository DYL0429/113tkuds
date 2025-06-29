import java.util.Scanner;

public class ds_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int sum = 0;

        // 讓使用者輸入 10 個整數
        System.out.println("請輸入 10 個整數：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("第 " + (i + 1) + " 個整數：");
            numbers[i] = sc.nextInt();
            sum += numbers[i]; // 累加總和
        }

        // 輸出總和
        System.out.println("\n所有整數的總和是：" + sum);

        sc.close();
    }
}