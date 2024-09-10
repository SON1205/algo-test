package BOJ10972;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
		
		nextPermutation(arr);
	}
	
	static void nextPermutation(int[] arr) {
		int idx = arr.length - 1;
		
		while (idx > 0 && arr[idx - 1] > arr[idx]) {
			idx--;
		}
		
		if (idx <= 0) {
            System.out.println(-1);
			return;
		}
		
		int bigIdx = arr.length - 1;
		while (bigIdx > idx && arr[idx - 1] > arr[bigIdx]) {
			bigIdx--;
		}
		
		swap(arr, idx - 1, bigIdx);
		
		Arrays.sort(arr, idx, arr.length);
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        
        System.out.print(sb);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}