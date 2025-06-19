public class CircularQueue {
    private int[] data;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.data = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full!");
        }
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
        }
        int val = data[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
        }
        return data[front];
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.peek());
        System.out.println(queue.isFull());
        System.out.println("Item removed: " + queue.dequeue());
        System.out.println(queue.peek());
    }
}
