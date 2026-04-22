package feature_one;

public class Lost_item {
    private String description;
    private String date;
    private String location;

    public Lost_item(String description, String date, String location) {
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return description + " | " + date + " | " + location;
    }
}
