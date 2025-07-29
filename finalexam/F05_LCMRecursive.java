import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = recursiveGCD(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    // 輾轉相減法：求最大公因數 GCD(a, b)
    public static int recursiveGCD(int a, int b) {
        if (a == b) return a;
        if (a > b) return recursiveGCD(a - b, b);
        return recursiveGCD(a, b - a);
    }
}

/*
 * 時間複雜度分析：
 * - GCD 使用輾轉相減法（遞迴），最壞情況下類似 O(max(a, b))
 *   例如當 a=1000000, b=1 時會遞迴 999999 次
 * - LCM 計算為 O(1)
 * => 總時間複雜度：最壞 O(max(a, b))

 * 空間複雜度分析：
 * - 輾轉相減法使用遞迴堆疊，最壞情況下會呼叫 max(a, b) 次
 * => 空間複雜度（遞迴深度）：O(max(a, b))
 */