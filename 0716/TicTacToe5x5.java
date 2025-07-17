import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        while (true) {
            int row = -1, col = -1;
            boolean validMove = false;

            // 輪流輸入直到合法
            while (!validMove) {
                System.out.print("玩家 " + currentPlayer + " 請輸入 row col (0~4): ");
                if (!sc.hasNextInt()) {
                    sc.next(); // 跳過錯誤輸入
                    System.out.println("輸入格式錯誤，請輸入兩個整數。");
                    continue;
                }
                row = sc.nextInt();
                if (!sc.hasNextInt()) {
                    sc.next();
                    System.out.println("輸入格式錯誤，請輸入兩個整數。");
                    continue;
                }
                col = sc.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("錯誤：座標超出範圍，請重新輸入。");
                } else if (board[row][col] != '.') {
                    System.out.println("錯誤：該位置已被佔用，請重新輸入。");
                } else {
                    validMove = true;
                }
            }

            board[row][col] = currentPlayer;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard();

            if (checkWin(row, col)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                break;
            }

            if (isDraw()) {
                System.out.println("平手！");
                break;
            }

            // 換人
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkWin(int r, int c) {
        char p = board[r][c];
        // 檢查列
        boolean win = true;
        for (int col = 0; col < SIZE; col++) {
            if (board[r][col] != p) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // 檢查行
        win = true;
        for (int row = 0; row < SIZE; row++) {
            if (board[row][c] != p) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // 檢查主對角線（r==c時才需檢查）
        if (r == c) {
            win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][i] != p) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // 檢查反對角線（r+c==SIZE-1時才需檢查）
        if (r + c == SIZE - 1) {
            win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][SIZE - 1 - i] != p) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }
}