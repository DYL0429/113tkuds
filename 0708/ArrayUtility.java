public class ArrayUtility {
    
    // 列印陣列內容
    public static void voidPrintArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // 原地反轉陣列
    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    // 複製陣列
    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // 找出第二大的數值
    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                second = max;
                max = array[i];
            } else if (array[i] > second && array[i] < max) {
                second = array[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原始陣列：");
        voidPrintArray(numbers);

        int[] copy = copyArray(numbers);
        System.out.print("複製陣列：");
        voidPrintArray(copy);

        reverseArray(numbers);
        System.out.print("反轉陣列：");
        voidPrintArray(numbers);

        int second = findSecondLargest(numbers);
        System.out.println("第二大數值：" + second);
    }
}