package BOJ.BOJ1912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cur = sc.nextInt();
        int max = cur;

        for (int i = 1; i < N; i++) {
            int num = sc.nextInt();
            cur = Math.max(num, cur + num);
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
