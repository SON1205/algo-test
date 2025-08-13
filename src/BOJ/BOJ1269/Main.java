package BOJ.BOJ1269;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < A; i++) {
            set1.add(sc.nextInt());
        }
        for (int i = 0; i < B; i++) {
            set2.add(sc.nextInt());
        }

        int result = set1.size() + set2.size();
        for (Integer i : set2) {
            if (set1.contains(i)) {
                result -= 2;
            }
        }

        System.out.println(result);
    }
}
