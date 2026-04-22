package feature_five;

public class Student {
    private String name;
    private String eventName;

    public Student(String name, String eventName) {
        this.name = name;
        this.eventName = eventName;
    }

    public String getName() {
        return name;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String toString() {
        return name + " registered for " + eventName;
    }
}
