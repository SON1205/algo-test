package exhausitiveSearch;

public class Combination {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] output = new int[3];
        boolean[] visited = new boolean[arr.length];

        comb(arr, output, visited, 0, 0);
    }

    static void comb(int[] arr, int[] output, boolean[] visited, int start, int cnt) {
        if (cnt == output.length) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = arr[i];
                comb(arr, output, visited, i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
