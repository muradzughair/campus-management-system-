package feature_one;

public class Found_lost_list {

    private Node head;

    public Found_lost_list() {
        this.head = null;
    }

    public void addItem(Lost_item item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void displayItems() {
        if (head == null) {
            System.out.println("No lost items.");
            return;
        }

        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.data.toString());
            temp = temp.next;
            index++;
        }
    }

    public void searchByDescription(String keyword) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        int found = 0;
        keyword = keyword.toLowerCase();

        while (temp != null) {
            String desc = temp.data.getDescription().toLowerCase();
            if (desc.contains(keyword)) {
                System.out.println(temp.data);
                found++;
            }
            temp = temp.next;
        }

        if (found == 0) {
            System.out.println("No items matched your search.");
        }
    }
}
