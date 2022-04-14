package oop.labor09.queue;

public class CircularQueue implements IQueue{

    private int front;
    private int rear;
    private Object items[];
    public final int CAPACITY;

    public CircularQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        items = new Object[CAPACITY];
        front = -1;
        rear = -1;
    }

    @Override
    public void enQueue(Object newObj) {
        if(!isFull()){
            if(front == -1) {
                front = 0;
            }
            rear = (rear+1) % CAPACITY;
            this.items[rear] = newObj;

        }
    }

    @Override
    public Object deQueue() {
        if(!isEmpty()){
            // Itt meg kell kod
            Object element = items[front];

            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % CAPACITY;
            }
            return element;
        }
        return null;
    }

    @Override
    public void printQueue() {
        for (Object obj:items){
            System.out.println(obj);
        }
    }

    @Override
    public boolean isEmpty() {
        return front == rear && front == -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
