package BOJ.BOJ1072;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        long Z = (long) Y * 100 / X;  // 현재 승률(정수)

        // 불가능한 경우: Z가 99 이상이면 변화 없음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long result = -1;                // 기본 -1로 두고, 찾으면 갱신
        int low = 1, high = 1_000_000_000;
        while (low <= high) {
            int mid = (low + high) / 2;
            long nz = (long) (Y + mid) * 100 / (X + mid);
            if (nz > Z) {
                result = mid;
                high = mid - 1;         // 더 작은 해를 탐색
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}
