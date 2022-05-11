package oop.labor11.labor11_4;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Object>items = new ArrayList<>();
    private final int capacity;

    public Stack(int capacity){
        this.capacity = capacity;
    }
    public boolean isFull(){
        return items.size() == capacity;
    }
    public void push(Object newObj) throws StackException{
        if(isFull()){
            throw new StackException("Stack is Full!");
        }
        items.add(newObj);
    }
    public void pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is Empty!");
        }
        items.remove(items.size()-1);
    }
    public boolean isEmpty(){
        return items.size() == 0;
    }
    public Object top() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is Empty!");
        }
        return items.get(items.size()-1);
    }
    public int getSize(){
        return items.size();
    }
}
