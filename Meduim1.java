//Meduim2

package lovelocal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Meduim1 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static TreeNode constructBST(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < values.length; i += 2) {
            TreeNode current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }

            if (i + 1 < values.length && values[i + 1] != null) {
                current.right = new TreeNode(values[i + 1]);
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("root=");
        String treeInput = scanner.nextLine();
        Integer[] treeValues = parseInput(treeInput);

        System.out.print(" p=");
        int valueP = scanner.nextInt();

        System.out.print("q=");
        int valueQ = scanner.nextInt();

        TreeNode root = constructBST(treeValues);
        TreeNode nodeP = findNode(root, valueP);
        TreeNode nodeQ = findNode(root, valueQ);

        TreeNode lca = lowestCommonAncestor(root, nodeP, nodeQ);

        if (lca != null) {
            System.out.println(lca.val);
        } else {
            System.out.println("No common ancestor found.");
        }
    }

    public static TreeNode findNode(TreeNode root, int value) {
        if (root == null || root.val == value) {
            return root;
        }

        if (value < root.val) {
            return findNode(root.left, value);
        } else {
            return findNode(root.right, value);
        }
    }

    public static Integer[] parseInput(String input) {
        String[] values = input.replaceAll("[\\[\\]]", "").split(",");
        Integer[] result = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i].equals("null")) ? null : Integer.parseInt(values[i]);
        }
        return result;
    }
}
