import java.util.Scanner;

public class StringReverse {

    /**
     * 遞迴反轉字串
     * @param str 要反轉的字串
     * @return 反轉後的字串
     */
    public static String reverseString(String str) {
        // 停止條件：空字串或只剩一個字元
        if (str.length() <= 1) {
            return str;
        }

        // 將最後一個字元移到前面，然後遞迴處理剩下的字串
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        // 建立 Scanner 物件讀取使用者輸入
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個字串：");

        // 讀入一整行字串
        String input = scanner.nextLine();

        // 呼叫遞迴方法並印出結果
        String reversed = reverseString(input);
        System.out.println("反轉結果：" + reversed);

        // 關閉 Scanner
        scanner.close();
    }
}