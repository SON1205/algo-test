package BOJ.BOJ10709;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            String input = sc.next();
            for (int j = 0; j < W; j++) {
                if (input.charAt(j) == '.') {
                    result[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (result[i][j] == 0) {
                    int min = 1;

                    for (int k = j + 1; k < W; k++) {
                        if (result[i][k] == -1) {
                            result[i][k] = min++;
                            continue;
                        }

                        result[i][k] = Math.min(result[i][k], min++);
                    }
                }
            }
        }

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }

            System.out.println();
        }
    }
}
