package Algorithm.binarySearch;

public class SearchMain {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        System.out.println(binarySearch(arr1, 1));

        int[] arr2 = new int[9];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        System.out.println(binarySearch(arr2, 4));
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    private static void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    static class TreeNode {
        TreeNode left;
        int value;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
