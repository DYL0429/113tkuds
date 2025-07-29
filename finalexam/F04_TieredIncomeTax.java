import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 輸入筆數
        int[] incomes = new int[n];

        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
        }

        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            int tax = calcTax(incomes[i]);
            System.out.println("Tax: $" + tax);
            totalTax += tax;
        }

        int avgTax = totalTax / n;
        System.out.println("Average: $" + avgTax);
    }

    // 段階稅率稅額計算
    private static int calcTax(int income) {
        if (income <= 560000) {
            return (int) (income * 0.05);
        } else if (income <= 1260000) {
            return (int) (income * 0.12 - 39200);
        } else if (income <= 2520000) {
            return (int) (income * 0.20 - 130000);
        } else if (income <= 4720000) {
            return (int) (income * 0.30 - 382000);
        } else {
            return (int) (income * 0.40 - 854000);
        }
    }
}

/*
 * 時間複雜度分析：
 * - 讀入 n 筆收入：O(n)
 * - 計算每筆稅額（段階稅率為常數條件判斷）：O(n)
 * - 總和與平均計算：O(n)
 * - 結果輸出：O(n)
 * => 總時間複雜度：O(n)

 * 空間複雜度分析：
 * - 儲存 n 筆收入的陣列：O(n)
 * - 其他變數與運算為固定空間：O(1)
 * => 總空間複雜度：O(n)
 */
