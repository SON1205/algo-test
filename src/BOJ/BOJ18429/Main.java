package BOJ.BOJ18429;

import java.util.Scanner;

public class Main {
    static final int POWER = 500;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        go(arr, K, POWER, 0, new boolean[N]);

        System.out.println(result);
    }

    private static void go(int[] arr, int K, int now, int day, boolean[] visited) {
        if (now < POWER) {
            return;
        }

        if (day == arr.length) {
            result++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                go(arr, K, now + arr[i] - K, day + 1, visited);
                visited[i] = false;
            }
        }
    }
}
