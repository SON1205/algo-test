package BOJ2979;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] duration = new int[101];

        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j < end; j++) {
                duration[j]++;
            }
        }

        int result = 0;

        for (int i = 1; i < duration.length; i++) {
            if (duration[i] == 0) {
                continue;
            }

            if (duration[i] == 1) {
                result += A;
            } else if (duration[i] == 2) {
                result += 2 * B;
            } else {
                result += 3 * C;
            }
        }

        System.out.println(result);
    }
}
