package BOJ.BOJ1991;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] tree = new int[N][2];
        for (int i = 0; i < N; i++) {
            char[] chars = sc.nextLine().toCharArray();
            tree[chars[0] - 'A'][0] = chars[2] - 'A';
            tree[chars[0] - 'A'][1] = chars[4] - 'A';
        }

        StringBuilder sb = new StringBuilder();
        preorder(tree, sb, 0);
        sb.append("\n");
        inorder(tree, sb, 0);
        sb.append("\n");
        postorder(tree, sb, 0);
        sb.append("\n");

        System.out.println(sb.toString());
    }

    private static void preorder(int[][] tree, StringBuilder sb, int idx) {
        sb.append((char) (idx + 'A'));
        if (tree[idx][0] > 0) {
            preorder(tree, sb, tree[idx][0]);
        }
        if (tree[idx][1] > 0) {
            preorder(tree, sb, tree[idx][1]);
        }
    }

    private static void inorder(int[][] tree, StringBuilder sb, int idx) {
        if (tree[idx][0] > 0) {
            inorder(tree, sb, tree[idx][0]);
        }
        sb.append((char) (idx + 'A'));
        if (tree[idx][1] > 0) {
            inorder(tree, sb, tree[idx][1]);
        }
    }

    private static void postorder(int[][] tree, StringBuilder sb, int idx) {
        if (tree[idx][0] > 0) {
            postorder(tree, sb, tree[idx][0]);
        }
        if (tree[idx][1] > 0) {
            postorder(tree, sb, tree[idx][1]);
        }
        sb.append((char) (idx + 'A'));
    }


}
