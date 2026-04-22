package feature_six;


public class Main {
    public static void main(String[] args) {
        Locker_bst tree = new Locker_bst();

        tree.insert(new Locker(1002, "L02"));
        tree.insert(new Locker(1001, "L01"));
        tree.insert(new Locker(1003, "L03"));

        tree.displayInOrder();

        System.out.println("\n-- Search for student 1002 --");
        tree.search(1002);

        System.out.println("\n-- Delete student 1002 --");
        tree.delete(1002);
        tree.displayInOrder();
    }
}
