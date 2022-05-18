package oop.labor12.labor12_1;

import java.util.TreeSet;

public class TreeSetDictionary implements  IDictionary{
    private TreeSet<String> treeSet = new TreeSet<>();
    private static TreeSetDictionary instance;

    public TreeSetDictionary(){
        if(instance == null){
            instance = this;
        }
    }
    public static IDictionary newInstance() {
        if(instance == null){
            instance = new TreeSetDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String newWord) {
        treeSet.add(newWord);
        return true;
    }

    @Override
    public boolean find(String word) {
        if(treeSet.contains(word)){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return treeSet.size();
    }
}
