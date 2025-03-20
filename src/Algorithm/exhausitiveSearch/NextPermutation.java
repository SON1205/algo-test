package Algorithm.exhausitiveSearch;

import java.util.Arrays;

/*
 * 뒤쪽부터 탐색하면서 내림차순의 꼭대기 찾기
 * 그 꼭대기 앞과 수보다 큰 수 골라서 교환
 */
public class NextPermutation {
	public static void main(String[] args) {
		int[] arr = {2, 1, 3};
		
		nextPermutation(arr);
	}
	
	static void nextPermutation(int[] arr) {
		int idx = arr.length - 1;
		
		while (idx > 0 && arr[idx - 1] > arr[idx]) {
			idx--;
		}
		
		if (idx <= 0) {
			return;
		}
		
		int bigIdx = arr.length - 1;
		while (bigIdx > idx && arr[idx - 1] > arr[bigIdx]) {
			bigIdx--;
		}
		
		swap(arr, idx - 1, bigIdx);
		
		Arrays.sort(arr, idx, arr.length);
		
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
