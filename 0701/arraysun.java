public class arraysun{

    //計算陣列元素總和的函數
    public static int sun(int[] arr, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        return total;
    } 

    public static void main(string[] args) {
        int[] data ={10,20,30,40,50};
        int result = sum(data,data.length);
        System.out.println("陣列總和為 :" + result);
    }
}