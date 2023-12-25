import java.util.LinkedList;

public class LinkedQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Enqueue (add an element to the end of the queue)
    public void enqueue(T element) {
        list.addLast(element);
    }

    // Dequeue (remove and return the element from the front of the queue)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    // Peek (return the element at the front of the queue without removing it)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();

        // Enqueue elements
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Peek at the front element
        System.out.println("Peek: " + queue.peek());

        // Check if the queue is empty
        System.out.println("Is empty: " + queue.isEmpty());

        // Get the size of the queue
        System.out.println("Size: " + queue.size());
    }
}
