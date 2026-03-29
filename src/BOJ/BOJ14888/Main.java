package BOJ.BOJ14888;

import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(arr, operators, arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int[] arr, int[] operators, int cur, int cnt) {
        if (cnt == arr.length) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] <= 0) {
                continue;
            }

            operators[i]--;
            if (i == 0) {
                dfs(arr, operators, cur + arr[cnt], cnt + 1);
            } else if (i == 1) {
                dfs(arr, operators, cur - arr[cnt], cnt + 1);
            } else if (i == 2) {
                dfs(arr, operators, cur * arr[cnt], cnt + 1);
            } else {
                dfs(arr, operators, cur / arr[cnt], cnt + 1);
            }
            operators[i]++;
        }
    }
}
