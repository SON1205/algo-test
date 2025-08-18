package BOJ.BOJ7795;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                listA.add(sc.nextInt());
            }
            for (int i = 0; i < B; i++) {
                listB.add(sc.nextInt());
            }
            listA.sort(Integer::compareTo);
            listB.sort(Integer::compareTo);

            int result = 0;
            int j = 0;
            for (int i = 0; i < listA.size(); i++) {
                int cur = listA.get(i);

                while (j < listB.size() && cur > listB.get(j)) {
                    j++;
                }

                result += j;
            }

            System.out.println(result);
        }
    }
}
