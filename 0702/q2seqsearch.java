import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();         // 讀入陣列大小
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {      // 讀入 n 個數字
            arr[i] = scanner.nextInt();
        }

        int key = scanner.nextInt();       // 讀入要搜尋的 key

        boolean found = false;
        int ops = 0;

        for (int i = 0; i < n; i++) {
            ops++;
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Yes" : "No");
        System.out.println(ops);

        scanner.close();
    }
}