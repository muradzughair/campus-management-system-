package feature_two;

public class RoomRequest {
    private String studentName;
    private String roomNumber;
    private String bookingTime;
    private int priority;  

    public RoomRequest(String studentName, String roomNumber, String bookingTime, int priority) {
        this.studentName = studentName;
        this.roomNumber = roomNumber;
        this.bookingTime = bookingTime;
        this.priority = priority;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[Priority: " + priority + "] " + studentName + " - Room " + roomNumber + " at " + bookingTime;
    }
}
