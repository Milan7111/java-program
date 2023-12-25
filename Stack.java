import java.util.EmptyStackException;

public class Stack {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int size;
    
    // Constructor to initialize the stack with a default capacity
    public Stack() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // Method to push an element onto the stack
    public void push(int element) {
        // Check if the array is full, and resize if necessary
        if (size == array.length) {
            resizeArray();
        }
        
        array[size++] = element;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        return array[--size];
    }

    // Method to peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        return array[size - 1];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the stack
    public int size() {
        return size;
    }

    // Helper method to resize the array when it becomes full
    private void resizeArray() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public static void main(String[] args) {
        // Example usage of the Stack class
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Print the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Print the size of the stack
        System.out.println("Size of the stack: " + stack.size());
    }
}
