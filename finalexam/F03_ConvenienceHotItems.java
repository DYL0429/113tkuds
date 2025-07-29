import java.util.*;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 商品數量（最多200）
        sc.nextLine(); // 讀掉換行

        Item[] items = new Item[n];

        // 讀入商品名稱與銷量
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);
            items[i] = new Item(name, qty);
        }

        // 插入排序：由大到小排序
        for (int i = 1; i < n; i++) {
            Item key = items[i];
            int j = i - 1;
            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }

        // 輸出前10名（或全部）
        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }
    }
}

/*
 * 時間複雜度分析：
 * - 讀入 n 筆資料：O(n)
 * - 插入排序（最壞情況）：O(n^2)
 * - 列出前 10 筆結果：O(1)（因為最多輸出10項）
 * => 總時間複雜度：O(n^2)

 * 空間複雜度分析：
 * - 使用一個大小為 n 的陣列儲存資料：O(n)
 * - 其他暫存變數與輸出不依賴 n：O(1)
 * => 總空間複雜度：O(n)
 */
