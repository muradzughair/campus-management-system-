package feature_one;

public class main {
    public static void main(String[] args) {
        Found_lost_list list = new Found_lost_list();

        list.addItem(new Lost_item("Phone with 2 camera", "2025-06-10", "Library"));
        list.addItem(new Lost_item("Wallet", "2025-06-11", "Cafeteria"));
        list.addItem(new Lost_item("Keys", "2025-06-12", "Parking Lot"));

        list.displayItems();

        System.out.println("\nSearch for 'phone':");
        list.searchByDescription("phone");
    }
}
