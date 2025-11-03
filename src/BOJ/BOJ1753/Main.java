package BOJ.BOJ1753;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final String INF = "INF";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int start = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            graph.get(sc.nextInt()).add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (distance[now[0]] < now[1]) {
                continue;
            }

            for (int[] next : graph.get(now[0])) {
                int nextCost = now[1] + next[1];
                if (nextCost < distance[next[0]]) {
                    distance[next[0]] = nextCost;
                    pq.offer(new int[]{next[0], nextCost});
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? INF : distance[i]);
        }
    }
}

