package BOJ.BOJ12015;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] lis = new int[N];
        lis[0] = arr[0];
        int len = 1;
        for (int i = 1; i < N; i++) {
            int next = arr[i];

            if (next > lis[len - 1]) {
                lis[len++] = next;
            } else {
                int idx = Arrays.binarySearch(lis, 0, len, next);
                if (idx < 0) {
                    idx = -idx - 1;
                }

                lis[idx] = next;
            }
        }

        System.out.println(len);
    }
}
