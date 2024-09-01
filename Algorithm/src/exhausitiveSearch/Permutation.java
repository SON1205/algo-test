package exhausitiveSearch;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] output = new int[2];
        boolean[] visited = new boolean[arr.length];

        perm(arr, output, visited, 0);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int cnt) {
        if (cnt == output.length) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = arr[i];
                perm(arr, output, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
