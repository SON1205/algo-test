package exhausitiveSearch;

public class Subset {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        boolean[] visited = new boolean[arr.length];

        subsetByRecur(arr, visited, 0);

        subsetByBit(arr);
    }

    static void subsetByRecur(int[] arr, boolean[] visited, int cnt) {
        if (cnt == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }

            System.out.println(sb);
            return;
        }

        visited[cnt] = true;
        subsetByRecur(arr, visited, cnt + 1);
        visited[cnt] = false;
        subsetByRecur(arr, visited, cnt + 1);
    }

    static void subsetByBit(int[] arr) {
        for (int i = 0; i < (1 << arr.length); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    sb.append(arr[j]).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
