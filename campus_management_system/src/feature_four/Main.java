package feature_four;


public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.performAction("Booked Room A1");
        manager.performAction("Booked Room B2");
        manager.performAction("Added lost item: Phone");

        manager.displayHistory();

        System.out.println("\nUndoing last action:");
        manager.undo();
        manager.displayHistory();

        System.out.println("\nRedoing action:");
        manager.redo();
        manager.displayHistory();
    }
}
