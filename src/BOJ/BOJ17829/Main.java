package BOJ.BOJ17829;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        PriorityQueue<Integer> pq;

        while (arr.length > 1) {
            int[][] tmp = new int[arr.length / 2][arr.length / 2];
            for (int i = 0; i < arr.length; i += 2) {
                for (int j = 0; j < arr[0].length; j += 2) {
                    pq = new PriorityQueue<>(Comparator.reverseOrder());
                    for (int x = 0; x < 2; x++) {
                        for (int y = 0; y < 2; y++) {
                            pq.offer(arr[i + x][j + y]);
                        }
                    }

                    pq.poll();
                    tmp[i / 2][j / 2] = pq.poll();
                }
            }

            arr = tmp;
        }

        System.out.println(arr[0][0]);
    }
}
