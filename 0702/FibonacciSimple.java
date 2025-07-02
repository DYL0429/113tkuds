public class FibonacciSimple {
    public static void main(String[] args) {
        int n = 10; // 要印出前幾項
        int a = 0, b = 1;

        System.out.println("費氏數列前 " + n + " 項：");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}