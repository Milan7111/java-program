public class ArrayQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T element) {
        if (size == array.length) {
            // Resize the array if it's full
            resize();
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T removedElement = (T) array[front];
        front = (front + 1) % array.length;
        size--;
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }

        array = newArray;
        front = 0;
        rear = size - 1;
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();

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
