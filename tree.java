import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    Node root;

    Node createTree(int[] arr, int i) {
        if (i >= arr.length)
            return null;

        Node node = new Node(arr[i]);

        node.left = createTree(arr, 2 * i + 1);
        node.right = createTree(arr, 2 * i + 2);

        return node;
    }

    void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Main tree = new Main();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        tree.root = tree.createTree(arr, 0);
        System.out.print("Preorder: ");
        tree.preorder(tree.root);

        System.out.print("\nInorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }
}
