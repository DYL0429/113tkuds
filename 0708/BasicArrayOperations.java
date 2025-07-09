public class BasicArrayOperations {
    public static void main(String[] args) {
        // 1. 宣告一個包含 10 個整數的陣列，初始值如下
        int[] numbers = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        // 2. 輸出陣列的長度
        System.out.println("陣列長度: " + numbers.length);

        // 3. 修改第 3 個位置（索引 2）的值為 99
        numbers[2] = 99;

        // 4. 修改最後一個位置的值為 100
        numbers[numbers.length - 1] = 100;

        // 5. 使用傳統 for 迴圈輸出所有元素，格式為「索引: 值」
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + ": " + numbers[i]);
        }
    }
}