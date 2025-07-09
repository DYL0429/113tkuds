public class GradeProcessor {
    public static void main(String[] args) {
        // 1. 建立成績陣列
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        // 2. 計算總分與平均分數
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        double average = (double) total / scores.length;
        System.out.printf("總分: %d\n", total);
        System.out.printf("平均分數: %.2f\n", average);

        // 3. 找出最高分和最低分及其索引
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }
        System.out.println("最高分: " + max + "（索引: " + maxIndex + "）");
        System.out.println("最低分: " + min + "（索引: " + minIndex + "）");

        // 4. 計算超過平均分的學生數
        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAvg++;
            }
        }
        System.out.println("成績超過平均的學生人數: " + countAboveAvg);

        // 5. 輸出每位學生的成績
        System.out.println("學生成績列表:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("學生編號 " + i + ": " + scores[i]);
        }
    }
}