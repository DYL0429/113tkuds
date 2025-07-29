import java.util.*;

public class F08_ClimbStairsMemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 樓梯階數

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);  // 初始化為未計算

        int ways = climb(n, memo);
        System.out.println("Ways: " + ways);
    }
