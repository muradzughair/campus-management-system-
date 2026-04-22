package feature_five;


public class Main {
    public static void main(String[] args) {
        Student_queue queue = new Student_queue();

        queue.register(new Student("Alice", "AI Workshop"));
        queue.register(new Student("Bob", "Cybersecurity Talk"));
        queue.register(new Student("Charlie", "Startup Pitch"));

        queue.showQueue();

        System.out.println("\n--- Processing registrations ---");
        queue.processRegistration();
        queue.showQueue();
    }
}
