package oop.labor09.queue;

public interface IQueue {
     void enQueue(Object newObj);
     Object deQueue();
     void printQueue();
     boolean isEmpty();
     boolean isFull();
}
