package BOJ.BOJ1940;

import java.util.Scanner;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        if (M > 200_000) {
            System.out.println(0);
            return;
        }

        int[] arr= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] == M) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
