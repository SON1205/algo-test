package BOJ.BOJ1940;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        boolean[] available = new boolean[100_001];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            available[nums[i]] = true;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (M - nums[i] <= 0 || M - nums[i] > 100_000) {
                continue;
            }

            if (!available[M - nums[i]]) {
                continue;
            }

            result++;
        }

        System.out.println(result / 2);
    }
}
