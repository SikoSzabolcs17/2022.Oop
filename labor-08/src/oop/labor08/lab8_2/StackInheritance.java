package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {
    private int capacity;

    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }
    public void pop(){
        if(!isEmpty()){
            this.remove(size()-1);
        }
    }
    public void push(Object object){
        if(size() < capacity){
            this.add(object);
        }
    }
    public Object top(){
        if(!isEmpty()){
            return this.get(size()-1);
        }
        return null;
    }
    public int getSize(){
        return this.size();
    }
}
