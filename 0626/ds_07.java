public class ds_07 {
    public static void main(String[] args) {
        // 建立一個 3x3 的二維陣列
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 輸出陣列中的所有元素
        System.out.println("3x3 二維陣列的內容為：");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // 換行
        }
    }
}