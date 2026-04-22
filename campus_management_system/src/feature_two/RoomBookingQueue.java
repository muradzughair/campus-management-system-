package feature_two;

public class RoomBookingQueue {
    private Node head;

    public RoomBookingQueue() {
        this.head = null;
    }

    public void addRequest(RoomRequest request) {
        Node newNode = new Node(request);

        if (head == null || request.getPriority() < head.data.getPriority()) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data.getPriority() <= request.getPriority()) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void displayRequests() {
        if (head == null) {
            System.out.println("No room requests.");
            return;
        }

        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data.toString());
            current = current.next;
            index++;
        }
    }

}
