package BOJ.BOJ2565;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }

        Arrays.sort(lines, Comparator.comparingInt(a -> a[0]));
        int[] levels = new int[N];
        int level = 0;
        levels[level++] = lines[0][1];

        for (int i = 1; i < N; i++) {
            int next = lines[i][1];

            if (next > levels[level - 1]) {
                levels[level++] = next;
            } else {
                int idx = Arrays.binarySearch(levels, 0, level, next);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                levels[idx] = next;
            }
        }

        System.out.println(N - level);
    }
}
