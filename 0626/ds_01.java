import java.util.Scanner;

public class ds_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("輸入第一個整數：");
        int a = sc.nextInt();
        System.out.print("輸入第二個整數：");
        int b = sc.nextInt();
        System.out.println("總和是：" + (a + b));
        sc.close();
    }
}