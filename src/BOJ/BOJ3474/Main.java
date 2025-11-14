package BOJ.BOJ3474;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int cnt = 0;
            while (num > 0) {
                cnt += num / 5;
                num = num / 5;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
