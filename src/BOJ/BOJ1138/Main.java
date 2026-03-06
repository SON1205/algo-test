package BOJ.BOJ1138;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            int cnt = 0;
            while (cnt < arr[i]) {
                if (ans[tmp] == 0) {
                    cnt++;
                }
                tmp++;
            }

            while (ans[tmp] != 0) {
                tmp++;
            }

            ans[tmp] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}
