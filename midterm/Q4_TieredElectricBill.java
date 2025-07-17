import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            int bill = calc(kWh);
            total += bill;
            System.out.println("Bill: $" + bill);
        }

        int average = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);

        sc.close();
    }

    // 計算電費（分段電價）
    static int calc(int kWh) {
        double amount = 0;
        int remaining = kWh;

        if (remaining > 1000) {
            amount += (remaining - 1000) * 8.46;
            remaining = 1000;
        }
        if (remaining > 700) {
            amount += (remaining - 700) * 6.24;
            remaining = 700;
        }
        if (remaining > 500) {
            amount += (remaining - 500) * 5.04;
            remaining = 500;
        }
        if (remaining > 330) {
            amount += (remaining - 330) * 3.70;
            remaining = 330;
        }
        if (remaining > 120) {
            amount += (remaining - 120) * 2.45;
            remaining = 120;
        }
        amount += remaining * 1.68;

        return (int) Math.round(amount);
    }
}



/*
 * Time Complexity: O(n)
 * 說明：每筆用電量呼叫一次 calc()，calc() 固定段數計算，故整體為線性。
 */