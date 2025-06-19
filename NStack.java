public class NStack {
    int[] data;
    int size;
    int top;

    public NStack(int size) {
        this.size = size;
        this.data = new int[size];
        this.top = -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("Stack is Full!");
        }
        data[++top] = value;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
        }
        System.out.println("Item popped is: " + data[top--]);
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
        }
        System.out.println(data[top]);
    }

    public static void main(String[] args) {
        NStack stack = new NStack(5);
        System.out.println(stack.isEmpty());;
        stack.push(1); 
        stack.push(2); 
        stack.push(3); 
        stack.push(4); 
        stack.push(5);
        stack.peek();
        System.out.println(stack.isFull());
        stack.pop();
        System.out.println(stack.isFull());
        stack.peek();
    }
}
