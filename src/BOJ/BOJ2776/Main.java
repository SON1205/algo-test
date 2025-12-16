package BOJ.BOJ2776;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(sc.nextInt());
            }

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int tmp = sc.nextInt();
                if (set.contains(tmp)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
