public class StudentGradeSystem {

    // 回傳成績等級
    public static String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else return "D";
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        int total = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        int a = 0, b = 0, c = 0, d = 0;

        // 計算總分、等級、最高/最低
        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];
            total += s;

            if (s > max) {
                max = s;
                maxIndex = i;
            }
            if (s < min) {
                min = s;
                minIndex = i;
            }

            String g = getGrade(s);
            if (g.equals("A")) a++;
            else if (g.equals("B")) b++;
            else if (g.equals("C")) c++;
            else d++;
        }

        double avg = (double) total / scores.length;

        // 計算高於平均的人數
        int above = 0;
        for (int s : scores) {
            if (s > avg) above++;
        }

        // 輸出結果
        System.out.println("=== 成績報告 ===");
        System.out.println("平均分數: " + String.format("%.2f", avg));
        System.out.println("最高分: " + max + "（學生編號: " + maxIndex + "）");
        System.out.println("最低分: " + min + "（學生編號: " + minIndex + "）");
        System.out.println("A 等級人數: " + a);
        System.out.println("B 等級人數: " + b);
        System.out.println("C 等級人數: " + c);
        System.out.println("D 等級人數: " + d);
        System.out.println("高於平均的學生比例: " + (above * 100 / scores.length) + "%");
        System.out.println("--------------");
        System.out.println("學生編號\t分數\t等級");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "\t\t" + scores[i] + "\t" + getGrade(scores[i]));
        }
    }
}