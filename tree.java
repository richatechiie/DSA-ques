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
    Node createTree(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);
        int i = 1;
        while (i < n) {
            Node curr = q.poll();
            curr.left = new Node(arr[i]);
            q.add(curr.left);
            i++;
            if (i < n) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
                i++;
            }
        }
        return root;
    }
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Main tree = new Main();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        tree.root = tree.createTree(arr);
        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.print("\nInorder: ");
        tree.inorder(tree.root);
        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }
}
