package oop.labor12.labor12_1;

import java.util.HashSet;

public class HashSetDictionary implements IDictionary {
    private HashSet<String>hashSet = new HashSet<>();
    private static HashSetDictionary instance;

    public HashSetDictionary(){
        if(instance == null){
            instance = this;
        }
    }
    public static IDictionary newInstance() {
        if(instance == null){
            instance = new HashSetDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String newWord) {
        hashSet.add(newWord);
        return true;
    }

    @Override
    public boolean find(String word) {
        if(hashSet.contains(word)){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return hashSet.size();
    }


}
