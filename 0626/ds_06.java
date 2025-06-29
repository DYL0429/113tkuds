import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
            System.out.print(arr[i] + " ");
            if (arr[i] > max) max = arr[i];
        }

        System.out.println("\n最大值是：" + max);
    }
}