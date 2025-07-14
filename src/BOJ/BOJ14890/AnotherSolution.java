package BOJ.BOJ14890;

import java.util.Scanner;

public class AnotherSolution {
    static int N, L, ret;
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();

        a = new int[N][N]; // 가로 방향
        b = new int[N][N]; // 세로 방향 (행열 반전 저장)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
                b[j][i] = a[i][j]; // 행열 반전 저장
            }
        }

        solve(a); // 가로 방향 검사
        solve(b); // 세로 방향 검사

        System.out.println(ret); // 가능한 경로 수 출력
    }

    // 한 줄(행 또는 열)씩 검사하는 함수
    static void solve(int[][] map) {
        for (int i = 0; i < N; i++) {
            int cnt = 1; // 현재까지 같은 높이 칸 수 (또는 경사로 설치 중 상태)
            int j;

            for (j = 0; j < N - 1; j++) {
                int curr = map[i][j];       // 현재 칸
                int next = map[i][j + 1];   // 다음 칸

                if (curr == next) {
                    // 높이가 같으면 연속 카운트 증가
                    cnt++;
                } else if (curr + 1 == next && cnt >= L) {
                    // 오르막 경사로: 현재 < 다음 (높이차 +1)
                    // 이전에 같은 높이 칸이 L개 이상이어야 함
                    cnt = 1; // 오르막 놓고 난 다음 칸부터 다시 카운트
                } else if (curr - 1 == next && cnt >= 0) {
                    // 내리막 경사로: 현재 > 다음 (높이차 -1)
                    // 앞으로 L칸이 같아야 하므로 카운트를 음수로 시작
                    cnt = -L + 1;
                } else {
                    // 높이 차가 2 이상이거나 경사로 못 놓으면 불가능
                    break;
                }
            }

            // 한 줄 끝까지 갔고, 내리막 경사로도 다 설치 완료된 경우만 인정
            if (j == N - 1 && cnt >= 0) {
                ret++; // 가능한 경로 수 증가
            }
        }
    }
}
