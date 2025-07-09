public class ArrayStatistics {
    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        int max = numbers[0], min = numbers[0];
        int maxIndex = 0, minIndex = 0;
        int evenCount = 0, oddCount = 0;

        // 計算總和、最大/最小值、奇偶數
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            sum += n;

            if (n > max) {
                max = n;
                maxIndex = i;
            }
            if (n < min) {
                min = n;
                minIndex = i;
            }

            if (n % 2 == 0) evenCount++;
            else oddCount++;
        }

        double average = (double) sum / numbers.length;

        // 計算大於平均值的數量
        int aboveAvgCount = 0;
        for (int n : numbers) {
            if (n > average) aboveAvgCount++;
        }

        // 輸出結果（簡單格式）
        System.out.println("總和: " + sum);
        System.out.printf("平均值: %.2f\n", average);
        System.out.println("最大值: " + max + "（索引: " + maxIndex + "）");
        System.out.println("最小值: " + min + "（索引: " + minIndex + "）");
        System.out.println("大於平均值的數量: " + aboveAvgCount);
        System.out.println("偶數個數: " + evenCount);
        System.out.println("奇數個數: " + oddCount);
    }
}