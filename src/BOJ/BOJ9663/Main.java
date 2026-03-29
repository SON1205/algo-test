package BOJ.BOJ9663;

import java.util.Scanner;

public class Main {
    static int result = 0;
    static int[] col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        col = new int[N];
        dfs(0, N);

        System.out.println(result);
    }

    private static void dfs(int row, int N) {
        if (row == N) {
            result++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isValid(row, c)) {
                col[row] = c;
                dfs(row + 1, N);
            }
        }
    }

    private static boolean isValid(int row, int c) {
        for (int i = 0; i < row; i++) {
            if (col[i] == c) {
                return false;
            }
            
            if (Math.abs(row - i) == Math.abs(c - col[i])) {
                return false;
            }
        }
        return true;
    }
}