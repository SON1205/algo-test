package BOJ.BOJ2559;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

            if (i < K) {
                result += arr[i];
            }
        }

        int pre = result;
        for (int i = 1; i < N - K + 1; i++) {
            int tmp = pre - arr[i - 1] + arr[i + K - 1];

            pre = tmp;
            result = Math.max(result, tmp);
        }

        System.out.println(result);
    }
}
