package feature_six;

public class Locker_bst {
    private Node root;

    public void insert(Locker locker) {
        root = insertRecursive(root, locker);
    }

    private Node insertRecursive(Node node, Locker locker) {
        if (node == null) return new Node(locker);

        if (locker.getStudentId() < node.data.getStudentId()) {
            node.left = insertRecursive(node.left, locker);
        } else if (locker.getStudentId() > node.data.getStudentId()) {
            node.right = insertRecursive(node.right, locker);
        } else {
            System.out.println("Student ID " + locker.getStudentId() + " already has a locker.");
        }
        return node;
    }

    public void search(int studentId) {
        Locker found = searchRecursive(root, studentId);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Locker not found for student ID " + studentId);
        }
    }

    private Locker searchRecursive(Node node, int studentId) {
        if (node == null) return null;

        if (studentId == node.data.getStudentId()) return node.data;
        if (studentId < node.data.getStudentId()) return searchRecursive(node.left, studentId);
        else return searchRecursive(node.right, studentId);
    }

    public void delete(int studentId) {
        root = deleteRecursive(root, studentId);
    }

    private Node deleteRecursive(Node node, int studentId) {
        if (node == null) {
            System.out.println("Student ID " + studentId + " not found.");
            return null;
        }

        if (studentId < node.data.getStudentId()) {
            node.left = deleteRecursive(node.left, studentId);
        } else if (studentId > node.data.getStudentId()) {
            node.right = deleteRecursive(node.right, studentId);
        } else {
            // Node found
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Replace with smallest in right subtree
            Locker min = findMin(node.right);
            node.data = min;
            node.right = deleteRecursive(node.right, min.getStudentId());
        }
        return node;
    }

    private Locker findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No lockers assigned.");
            return;
        }
        System.out.println("Locker Assignments (in order):");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }
}
