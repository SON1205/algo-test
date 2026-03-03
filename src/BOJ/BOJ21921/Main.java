package BOJ.BOJ21921;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i <= N - X; i++) {
            int tmp = arr[i + X] - arr[i];

            if (tmp < max) {
                continue;
            }

            if (tmp == max) {
                cnt++;
                continue;
            }

            max = tmp;
            cnt = 1;
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}
