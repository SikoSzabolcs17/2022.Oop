package oop.labor09.dictionary;

import java.util.ArrayList;

public class ArrayListDictionary implements IDictionary {

    private ArrayList<String> words = new ArrayList<>();
    private static ArrayListDictionary instance;

    private ArrayListDictionary(){
        if(instance == null){
            instance = this;
        }
    }

    public static IDictionary newInstance() {
        if(instance == null){
            instance = new ArrayListDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String newWord) {
        if(!find(newWord)){
            words.add(newWord);
            return true;
        }
        return false;
    }

    @Override
    public boolean find(String word) {

        return words.contains(word);
    }

    @Override
    public int size() {
        return words.size();
    }
}
