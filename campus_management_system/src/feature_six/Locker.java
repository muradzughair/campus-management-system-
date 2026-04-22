package feature_six;

public class Locker {
    private int studentId;
    private String lockerNumber;

    public Locker(int studentId, String lockerNumber) {
        this.studentId = studentId;
        this.lockerNumber = lockerNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Locker: " + lockerNumber;
    }
}
