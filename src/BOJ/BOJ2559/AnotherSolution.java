package BOJ.BOJ2559;

import java.util.Scanner;

//누적합
public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                arr[i] = sc.nextInt();
                continue;
            }

            arr[i] = arr[i - 1] + sc.nextInt();
        }

        int result = arr[K - 1];
        for (int i = K; i < N; i++) {
            result = Math.max(result, arr[i] - arr[i - K]);
        }

        System.out.println(result);
    }
}
