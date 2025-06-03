package BOJ.BOJ1629;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(doLoop(A, B, C));
    }

    private static long doLoop(int A, int B, int C) {
        if (B == 1) {
            return A % C;
        }

        long half = doLoop(A, B / 2, C);
        long tmp = half * half % C;

        if (B % 2 == 1) {
            tmp = tmp * A % C;
        }

        return tmp;
    }
}
