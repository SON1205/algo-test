package BOJ2606;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edge = sc.nextInt();

        List<List<Integer>> network = new ArrayList<>();

        for (int i = 0; i <= vertex; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            network.get(u).add(v);
            network.get(v).add(u);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(network.get(i));
        }

        visited = new boolean[vertex + 1];

        checkingConnection(network, 1);
        System.out.println(cnt);
    }

    static boolean[] visited;
    static int cnt = 0;

    static void checkingConnection(List<List<Integer>> network, int start) {
        visited[start] = true;

        for (int i = 0; i < network.get(start).size(); i++) {
            int tmp = network.get(start).get(i);
            if (visited[tmp]) {
                continue;
            }

            cnt++;
            checkingConnection(network, tmp);
        }
    }
}
