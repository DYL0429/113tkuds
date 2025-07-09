class ScoreStatistics {
    public static void main(String[] args) {
        int[] scores = {85, 92, 77, 60, 88, 95, 73, 68, 89, 91};
        
        // 使用增強型 for 迴圈走訪陣列計算總分
        // 這是循序存取（Sequential Access）的典型應用
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        
        // 計算統計數據
        double average = (double) sum / scores.length;
        int studentCount = scores.length;
        
        System.out.println("=== 成績統計報表 ===");
        System.out.printf("學生人數：%d 人\n", studentCount);
        System.out.printf("總分：%d 分\n", sum);
        System.out.printf("平均分數：%.2f 分\n", average);
        
        // 顯示所有成績
        System.out.println("\n個別成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("第 %2d 位學生：%d 分\n", i + 1, scores[i]);
        }
    }
}