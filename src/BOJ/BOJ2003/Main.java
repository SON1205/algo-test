package BOJ.BOJ2003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (sum >= M) {
                if (sum == M) {
                    result++;
                }
                sum -= arr[start++];
            } else {
                if (end == N) {
                    break;
                }
                sum += arr[end++];
            }
        }

        System.out.println(result);
    }
}
