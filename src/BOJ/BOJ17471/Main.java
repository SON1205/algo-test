package BOJ.BOJ17471;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] population = new int[N];
        for (int i = 0; i < N; i++) {
            population[i] = sc.nextInt();
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int e = sc.nextInt();
            for (int j = 0; j < e; j++) {
                int neighbor = sc.nextInt() - 1;
                graph.get(i).add(neighbor);
            }
        }

        for (int bit = 1; bit < (1 << N) - 1; bit++) {
            boolean[] group = new boolean[N];
            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    group[i] = true;
                }
            }

            if (isValidGroup(group, graph)) {
                int populationA = 0, populationB = 0;
                for (int i = 0; i < N; i++) {
                    if (group[i]) {
                        populationA += population[i];
                    } else {
                        populationB += population[i];
                    }
                }

                result = Math.min(result, Math.abs(populationA - populationB));
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static boolean isValidGroup(boolean[] group, List<List<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[group.length];
        boolean start = group[0];
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> neighbours = graph.get(curr);
            for (int neighbor : neighbours) {
                if (!visited[neighbor] && group[neighbor] == start) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 1; i < group.length; i++) {
            if (group[i] != start) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> neighbours = graph.get(curr);

            for (int neighbor : neighbours) {
                if (!visited[neighbor] && group[neighbor] == !start) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
