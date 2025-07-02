import java.util.Scanner;

public class q7permutation {
    static int ops = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 輸入 n

        int[] nums = new int[n];
        boolean[] used = new boolean[n];

        // 初始化陣列為 1~n
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        backtrack(nums, used, new int[n], 0);

        // 輸出操作次數
        System.out.println(ops);
        scanner.close();
    }

    // 回溯法列出所有排列
    public static void backtrack(int[] nums, boolean[] used, int[] perm, int depth) {
        if (depth == nums.length) {
            // 印出目前的排列
            for (int i = 0; i < nums.length; i++) {
                System.out.print(perm[i]);
                if (i < nums.length - 1) System.out.print(" ");
            }
            System.out.println();
            ops++; // 紀錄一個排列
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = nums[i];
                backtrack(nums, used, perm, depth + 1);
                used[i] = false;
            }
        }
    }
}