package BOJ.BOJ10709;

import java.util.Scanner;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        for (int i = 0; i < H; i++) {
            String input = sc.next();
            int lastCloud = -1;
            for (int j = 0; j < W; j++) {
                if (input.charAt(j) == 'c') {
                    lastCloud = j;
                    System.out.print(0 + " ");
                } else if (lastCloud == -1) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print((j - lastCloud) + " ");
                }
            }
            System.out.println();
        }
    }
}
