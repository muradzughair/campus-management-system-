package feature_four;

public class Stack<T> {
	
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        return isEmpty() ? null : top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

  
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
