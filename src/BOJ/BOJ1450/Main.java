package BOJ.BOJ1450;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Long> A = new ArrayList<>();
    static ArrayList<Long> B = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long C = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        int mid = N / 2;

        dfs(0, mid, 0, arr, A, C);
        dfs(mid, N, 0, arr, B, C);
        Collections.sort(A);
        Collections.sort(B);

        long answer = 0;
        for (long x : A) {
            if (x > C) {
                continue;
            }

            long remain = C - x;
            int idx = upperBound(B, remain);
            answer += idx;
        }

        System.out.println(answer);
    }

    static void dfs(int idx, int end, long sum, long[] arr, ArrayList<Long> list, long C) {
        if (sum > C) {
            return;
        }

        if (idx == end) {
            list.add(sum);
            return;
        }

        dfs(idx + 1, end, sum + arr[idx], arr, list, C);
        dfs(idx + 1, end, sum, arr, list, C);
    }

    static int upperBound(ArrayList<Long> list, long target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
