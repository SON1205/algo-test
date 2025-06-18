package BOJ.BOJ1987;

import java.util.Scanner;

public class Main {
    static int result = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[] alphabet = new boolean[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] board = new char[R][C];
        for (int i = 0; i < board.length; i++) {
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
            }
        }

        alphabet[board[0][0] - 'A'] = true;
        dfs(0, 0, 1, board);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int count, char[][] board) {
        if (result < count) {
            result = count;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }

            if (alphabet[board[nx][ny] - 'A']) {
                continue;
            }

            alphabet[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, count + 1, board);
            alphabet[board[nx][ny] - 'A'] = false;
        }
    }
}
