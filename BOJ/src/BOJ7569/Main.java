package BOJ7569;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};

	static int[][][] tomato;
	static Deque<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		tomato = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = sc.nextInt();
					if (tomato[i][j][k] == 1) {
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}
		
		bfs();
		
		int result = 0;
		for (int p = 0; p < H; p++) {
			for (int q = 0; q < N; q++) {
				for (int r = 0; r < M; r++) {
					if (tomato[p][q][r] == 0) {
						System.out.println(-1);
						return;
					} else if (tomato[p][q][r] == -1) {
						continue;
					}
					
					if (tomato[p][q][r] > result) {
						result = tomato[p][q][r] - 1;
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs() {
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				int nz = tmp[2] + dz[i];
			
				if (nx < 0 || nx >= tomato.length 
						|| ny < 0 || ny >= tomato[0].length
						|| nz < 0 || nz >= tomato[0][0].length) {
					continue;
				}
				
				if (tomato[nx][ny][nz] == 1 || tomato[nx][ny][nz] == -1) {
					continue;
				}
				
				int day = tomato[tmp[0]][tmp[1]][tmp[2]] + 1;
				if (tomato[nx][ny][nz] == 0 || day < tomato[nx][ny][nz]) {
					tomato[nx][ny][nz] = day;
					queue.offer(new int[] {nx, ny, nz});
				}
			}	
		}
	}
}
