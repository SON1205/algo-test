package BOJ.BOJ16434;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int attack = sc.nextInt();
        int[][] map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        long left = 1;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (go(map, mid, attack)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static boolean go(int[][] map, long maxHp, long att) {
        long nowHp = maxHp;

        for (int i = 0; i < map.length; i++) {
            int[] cur = map[i];
            if (map[i][0] == 1) {
                long cnt = (cur[2] + att - 1) / att;
                nowHp -= (cnt - 1) * cur[1];

                if (nowHp <= 0) {
                    return false;
                }
            } else {
                att += cur[1];
                nowHp = Math.min(nowHp + cur[2], maxHp);
            }
        }

        return true;
    }
}
