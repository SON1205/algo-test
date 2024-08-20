package BOJ2468;

import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int result = 1;
		
		for (int i = 1; i <= 100; i++) {
			visited = new boolean[N][N];
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && map[j][k] > i) {
						cnt++;
						dfs(j, k, i);
					}
				}
			}
			
			if (cnt <= 0)
				break;
			
			if (cnt > result) {
				result = cnt;
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int high) {
		visited[x][y] = true;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= visited.length || ny < 0 || ny >= visited.length) {
				continue;
			}
			
			if (visited[nx][ny] || map[nx][ny] <= high) {
				continue;
			}
			
			dfs(nx, ny, high);
		}
	}
}
