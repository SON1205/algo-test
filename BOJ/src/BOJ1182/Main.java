package BOJ1182;

import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		visited = new boolean[N];
		subset(0, input, S);
		
		if (S == 0) {
			result--;
		}
		
		System.out.println(result);
	}
	
	static void subset(int cnt, int[] input, int S) {
		if (cnt == visited.length) {
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sum += input[i];
				}
			}
			
			if (sum == S) {
				result++;
			}
			return;
		}
		
		visited[cnt] = true;
		subset(cnt + 1, input, S);
		visited[cnt] = false;
		subset(cnt + 1, input, S);
	}
}
