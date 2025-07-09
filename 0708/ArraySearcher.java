public class ArraySearcher {
    
    // 2. 搜尋指定的數值，找到回傳索引，否則回傳 -1
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // 找到就回傳索引
            }
        }
        return -1; // 找不到回傳 -1
    }

    // 4. 計算某個數值在陣列中出現的次數
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] numbers = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        // 5. 測試搜尋數字 67
        int target1 = 67;
        int index1 = findElement(numbers, target1);
        System.out.println("數字 " + target1 + " 的索引位置: " + index1);
        System.out.println("數字 " + target1 + " 出現次數: " + countOccurrences(numbers, target1));

        // 測試搜尋數字 100
        int target2 = 100;
        int index2 = findElement(numbers, target2);
        System.out.println("數字 " + target2 + " 的索引位置: " + index2);
        System.out.println("數字 " + target2 + " 出現次數: " + countOccurrences(numbers, target2));
    }
}