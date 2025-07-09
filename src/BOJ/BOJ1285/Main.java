package BOJ.BOJ1285;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] coinRows = new int[N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            int rowMask = 0;
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == 'H') {
                    rowMask |= (1 << j);
                }
            }
            coinRows[i] = rowMask;
        }

        int result = Integer.MAX_VALUE;

        for (int bit = 0; bit < (1 << N); bit++) {
            int[] flipped = new int[N];

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    flipped[i] = ~coinRows[i] & ((1 << N) - 1);
                } else {
                    flipped[i] = coinRows[i];
                }
            }

            int cnt = 0;
            for (int col = 0; col < N; col++) {
                int head = 0;
                for (int row = 0; row < N; row++) {
                    if ((flipped[row] & (1 << col)) == 0) {
                        head++;
                    }
                }
                cnt += Math.min(head, N - head);
            }

            result = Math.min(result, cnt);
        }

        System.out.println(result);
    }
}
