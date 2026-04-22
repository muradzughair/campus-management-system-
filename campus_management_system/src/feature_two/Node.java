package feature_two;

public class Node {
    RoomRequest data;
    Node next;

    public Node(RoomRequest data) {
        this.data = data;
        this.next = null;
    }
}
