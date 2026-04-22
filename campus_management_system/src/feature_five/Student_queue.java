package feature_five;

public class Student_queue {
    private Node front;
    private Node rear;

    public Student_queue() {
        front = rear = null;
    }

    // Enqueue
    public void register(Student student) {
        Node newNode = new Node(student);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(student.getName() + " successfully registered.");
    }

    // Dequeue
    public void processRegistration() {
        if (front == null) {
            System.out.println("No students to process.");
            return;
        }

        System.out.println("Processing: " + front.data);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Display
    public void showQueue() {
        if (front == null) {
            System.out.println("No registered students.");
            return;
        }

        System.out.println("Registration Queue:");
        Node temp = front;
        int index = 1;
        while (temp != null) {
            System.out.println(index++ + ". " + temp.data);
            temp = temp.next;
        }
    }
}
