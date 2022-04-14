package oop.labor09.queue;

import java.util.ArrayList;

public class ArrayListQueue implements IQueue{

    private ArrayList<Object> items = new ArrayList<>();
    private final int CAPACITY;

    public ArrayListQueue(int capacity){
        this.CAPACITY = capacity;
    }
    @Override
    public void enQueue(Object newObj) {
        if(!isFull()){
            this.items.add(newObj);
        }

    }

    @Override
    public Object deQueue() {
        if(!isEmpty()){
            Object obj = items.get(0);
            items.remove(0);
            return obj;
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
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size()==CAPACITY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayListQueue that = (ArrayListQueue) o;
        if(this.items.size() != that.items.size())return false;

        for (int i = 0; i< this.items.size();i++) {
            if(!items.get(i).equals(that.items.get(i)))
                return false;
        }
        return true;
    }

}
