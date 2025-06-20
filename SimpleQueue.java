public class SimpleQueue {
    private int[] queue;
    private int size, capacity, front, rear;

    public SimpleQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = -1;
        this.rear = 0;
        this.queue = new int[capacity];
    }

    public boolean isFull() {
        return rear == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        queue[rear++] = value;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Item removed is: " + queue[++front]);
        size--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("The current queue is: ");
        for (int i = front + 1; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.display();
    }
}
