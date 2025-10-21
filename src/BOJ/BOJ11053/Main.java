package BOJ.BOJ11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        int[] cnt = new int[N];
        for (int i = 0; i < N; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && maxValue < cnt[j]) {
                    maxValue = cnt[j];
                }
            }

            cnt[i] = maxValue + 1;
            result = Integer.max(result, cnt[i]);
        }

        System.out.println(result);
    }
}
