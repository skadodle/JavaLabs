import java.util.NoSuchElementException;

public class binaryTree<T extends Comparable<T>> {
    private int size;
    private Node root;
    private class Node {
        private T value;
        private Node left = null;
        private Node right = null;

        Node(T value) { this.value = value; }
    }

    binaryTree() {
        size = 0;
        root = null;
    }

    binaryTree(binaryTree<T> otherBinaryTree) {
        this();
        if (otherBinaryTree.root != null) {
            this.root = copy(otherBinaryTree.root);
            this.size = otherBinaryTree.size;
        }
    }

    private Node copy(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.value);
        newNode.left = copy(node.left);
        newNode.right = copy(node.right);
        return newNode;
    }

    public void add(Node node, T value) {
        if (size == 0) {
            root = new Node(value);
            //System.out.println("Root = " + value.toString());
        }
        else if (node.value == value) { return; }
        else if (node.value.compareTo(value) > 0) {
            if (node.left != null) {
                //System.out.println("go left");
                add(node.left, value);
            } else {
                //System.out.println("add new left");
                node.left = new Node(value);
            }
        } else if (node.value.compareTo(value) < 0) {
            if (node.right != null) {
                //System.out.println("go right");
                add(node.right, value);
            } else {
                //System.out.println("add new right");
                node.right = new Node(value);
            }
        }
        size++;
    }

    public void clear() {
        this.size = 0;
        this.root = null;
    }

    public boolean findElement(Node node, T value) {
        if (node == null) return false;
        if (value.compareTo(node.value) == 0) return true;
        return (node.value.compareTo(value) > 0) ? findElement(node.left, value) : findElement(node.right, value);
    }

    public int getSize() { return this.size; }
    public Node getRoot() { return this.root; }

    public void printTree(Node node) {
        String result = this.toString();
        System.out.println(result);
    }

    @Override
    public String toString() {
        return "<" + toString(this.root) + ">";
    }

    private String toString(Node node) {
        if (node == null) return "";
        return toString(node.left) + " " + node.value.toString() + " " + toString(node.right);
    }
}
