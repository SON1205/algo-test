package BOJ.BOJ17829;

import java.util.Arrays;
import java.util.Scanner;

public class AnotherSolution {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(pool(0, 0, N));
    }

    static int pool(int x, int y, int size) {
        // base case: 1×1
        if (size == 1) {
            return arr[x][y];
        }

        int half = size / 2;

        // 4개의 영역 풀링
        int[] vals = new int[4];
        vals[0] = pool(x, y, half);
        vals[1] = pool(x, y + half, half);
        vals[2] = pool(x + half, y, half);
        vals[3] = pool(x + half, y + half, half);

        Arrays.sort(vals); // 정렬 후 두 번째 큰 값 반환
        return vals[2];
    }
}

