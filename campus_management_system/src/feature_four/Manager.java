package feature_four;

public class Manager {
	
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public Manager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void performAction(String action) {
        undoStack.push(action);
        redoStack.clear();
        System.out.println("Action performed: " + action);
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            String action = undoStack.pop();
            redoStack.push(action);
            System.out.println("Undone: " + action);
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
        } else {
            String action = redoStack.pop();
            undoStack.push(action);
            System.out.println("Redone: " + action);
        }
    }

    public void displayHistory() {
        if (undoStack.isEmpty()) {
            System.out.println("No actions in history.");
            return;
        }

        System.out.println("Action history (most recent first):");
        for (int i = undoStack.size() - 1; i >= 0; i--) {
            System.out.println("- " + undoStack.get(i));
        }
    }
}
