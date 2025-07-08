package BOJ.BOJ19942;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] minimum = new int[4];
    static int[][] foods;
    static int result = Integer.MAX_VALUE;
    static List<Integer> bestCombination = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            minimum[i] = sc.nextInt();
        }

        foods = new int[N][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                foods[i][j] = sc.nextInt();
            }
        }

        for (int bit = 1; bit < (1 << N); bit++) {
            int[] nutrient = new int[4];
            int cost = 0;
            List<Integer> selected = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    for (int j = 0; j < 4; j++) {
                        nutrient[j] += foods[i][j];
                    }
                    cost += foods[i][4];
                    selected.add(i + 1);
                }
            }

            if (checkValid(nutrient)) {
                if (cost < result) {
                    result = cost;
                    bestCombination = new ArrayList<>(selected);
                } else if (cost == result) {
                    if (compareList(selected, bestCombination) < 0) {
                        bestCombination = new ArrayList<>(selected);
                    }
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            for (int idx : bestCombination) {
                System.out.print(idx + " ");
            }
        }
    }

    static boolean checkValid(int[] nutrient) {
        for (int i = 0; i < 4; i++) {
            if (nutrient[i] < minimum[i]) {
                return false;
            }
        }
        return true;
    }

    static int compareList(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) - b.get(i);
            }
        }
        return a.size() - b.size();
    }
}
