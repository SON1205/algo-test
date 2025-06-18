package BOJ.BOJ2529;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static char[] signs;
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        signs = new char[K];
        for (int i = 0; i < K; i++) {
            signs[i] = sc.next().charAt(0);
        }

        visited = new boolean[10];
        dfs(0, new int[K + 1]);

        Collections.sort(results);

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    private static void dfs(int idx, int[] tmp) {
        if (idx == tmp.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.length; i++) {
                sb.append(tmp[i]);
            }

            results.add(sb.toString());
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (idx == 0 || (
                    (signs[idx - 1] == '<' && tmp[idx - 1] < i) || (signs[idx - 1] == '>' && tmp[idx - 1] > i)
            )) {
                tmp[idx] = i;
                visited[i] = true;
                dfs(idx + 1, tmp);
                visited[i] = false;
            }
        }
    }
}
