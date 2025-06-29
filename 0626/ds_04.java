public class ds_04 {
    public static void main(String[] args) {
        // 建立包含 5 個整數的一維陣列
        int[] numbers = {10, 20, 30, 40, 50};

        // 輸出所有陣列元素
        System.out.println("陣列中的元素有：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("第 " + (i + 1) + " 個元素是：" + numbers[i]);
        }
    }
}
