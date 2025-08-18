package BOJ.BOJ6236;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int p = sc.nextInt();
            list.add(p);
            max = Math.max(max, p);
        }

        int left = max;
        int right = 10_000 * N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(list, mid, M)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static boolean check(List<Integer> list, int mid, int M) {
        int cnt = 1;
        int tmp = mid;

        for (Integer p : list) {
            if (tmp - p < 0) {
                tmp = mid - p;
                cnt++;
                continue;
            }

            tmp -= p;
        }

        if (cnt <= M) {
            return true;
        }

        return false;
    }
}
