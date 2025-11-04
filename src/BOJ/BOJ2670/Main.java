package BOJ.BOJ2670;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
        }

        double result = arr[0];
        double dp = arr[0];

        for (int i = 1; i < N; i++) {
            dp = Math.max(arr[i], dp * arr[i]);
            result = Math.max(result, dp);
        }

        System.out.printf("%.3f\n", result);
    }
}
