package BOJ.BOJ2138;

import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        String startStr = sc.next();
        String targetStr = sc.next();

        boolean[] start = new boolean[N];
        boolean[] target = new boolean[N];

        for (int i = 0; i < N; i++) {
            start[i] = startStr.charAt(i) == '1';
            target[i] = targetStr.charAt(i) == '1';
        }

        int res1 = solve(start.clone(), target, false);
        int res2 = solve(start.clone(), target, true);

        int ans = Math.min(res1, res2);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static int solve(boolean[] cur, boolean[] target, boolean firstPress) {
        int cnt = 0;

        if (firstPress) {
            press(cur, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (cur[i - 1] != target[i - 1]) {
                press(cur, i);
                cnt++;
            }
        }

        return check(cur, target) ? cnt : Integer.MAX_VALUE;
    }

    private static void press(boolean[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < N) {
                arr[i] = !arr[i];
            }
        }
    }

    private static boolean check(boolean[] a, boolean[] b) {
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
