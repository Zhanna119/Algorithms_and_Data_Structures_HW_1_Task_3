package org.example;

public class Deque {
    private final int MAX_SIZE = 100;
    private int[] arr;
    private int front, rear, size;

    public Deque() {
        arr = new int[MAX_SIZE];
        front = rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public void pushBack(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot pushBack.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }

        arr[rear] = value;
        size++;
    }

    public void pushFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot pushFront.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + MAX_SIZE) % MAX_SIZE;
        }

        arr[front] = value;
        size++;
    }

    public void popBack() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot popBack.");
            return;
        }

        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + MAX_SIZE) % MAX_SIZE;
        }

        size--;
    }

    public void popFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot popFront.");
            return;
        }

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }

        size--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        int i = front;
        System.out.print("Deque: ");
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % MAX_SIZE;
        }
        System.out.println();
    }

    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Deque cleared.");
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.pushBack(1);
        dq.pushBack(2);
        dq.pushBack(3);
        dq.pushFront(0);

        dq.display(); // Output: Deque: 0 1 2 3

        dq.popBack();
        dq.popFront();

        dq.display(); // Output: Deque: 1 2

        System.out.println("Deque size: " + dq.size()); // Output: Deque size: 2

        dq.clear();
        dq.display(); // Output: Deque is empty.
    }
}
