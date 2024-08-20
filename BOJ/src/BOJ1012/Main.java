package BOJ1012;

import java.util.Scanner;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			boolean[][] batt = new boolean[M][N];
			
			for (int j = 0; j < K; j++) {
				batt[sc.nextInt()][sc.nextInt()] = true;
			}
			
			int cnt = 0;
			visited = new boolean[M][N];
			
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && batt[j][k]) {
						cnt++;
						dfs(j, k, batt);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static void dfs(int x, int y, boolean[][] batt) {
		visited[x][y] = true;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= visited.length || ny < 0 || ny >= visited[0].length) {
				continue;
			}
			
			if (visited[nx][ny] || !batt[nx][ny]) {
				continue;
			}
			
			dfs(nx, ny, batt);
		}
	}
}