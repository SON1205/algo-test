package BOJ.BOJ1068;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] parents = new int[N];
        int result = 0;

        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }

        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            parents[i] = parent;

            if (parent == -1) {
                root = i;
                continue;
            }

            nodes.get(parent).add(i);
        }

        int remove = sc.nextInt();
        if (root == remove) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < nodes.get(parents[remove]).size(); i++) {
            if (nodes.get(parents[remove]).get(i) == remove) {
                nodes.get(parents[remove]).remove(i);
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (nodes.get(tmp).isEmpty()) {
                result++;
                continue;
            }

            for (Integer n : nodes.get(tmp)) {
                q.offer(n);
            }
        }

        System.out.println(result);
    }
}
