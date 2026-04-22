package feature_two;

public class Main {
    public static void main(String[] args) {
        RoomBookingQueue queue = new RoomBookingQueue();

        queue.addRequest(new RoomRequest("Alice", "A1", "10:00 AM", 2));
        queue.addRequest(new RoomRequest("Bob", "B2", "09:00 AM", 1));
        queue.addRequest(new RoomRequest("Charlie", "C3", "11:00 AM", 3));

        System.out.println("=== Room Booking Queue ===");
        queue.displayRequests();

        System.out.println("\n=== Booked rooms  ===");
        queue.displayRequests();
    }
}
