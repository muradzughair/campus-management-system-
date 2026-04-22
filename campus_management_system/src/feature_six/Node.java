package feature_six;

public class Node {
    Locker data;
    Node left, right;

    public Node(Locker data) {
        this.data = data;
        this.left = this.right = null;
    }
}
