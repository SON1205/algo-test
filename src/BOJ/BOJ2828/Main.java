package BOJ.BOJ2828;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int J = sc.nextInt();
        int startIdx = 0;

        int result = 0;

        while (J-- > 0) {
            int fall = sc.nextInt() - 1;

            if (fall < startIdx) {
                result += startIdx - fall;
                startIdx = fall;
            } else if (startIdx + M <= fall) {
                result += fall - (startIdx + M - 1);
                startIdx = fall - M + 1;
            }
        }

        System.out.println(result);
    }
}
