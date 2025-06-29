import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入您的姓名：");
        String name = sc.nextLine();

        System.out.print("請輸入您的年齡：");
        int age = sc.nextInt();
        sc.nextLine(); // 吸收換行符號，避免影響後續輸入

        System.out.print("請輸入您居住的城市：");
        String city = sc.nextLine();

        System.out.println("\n--- 您輸入的資訊如下 ---");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("城市：" + city);

        sc.close();
    }
}