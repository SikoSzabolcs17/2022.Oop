package oop.labor12.labor12_1;

public interface IDictionary {

    String DICTIONARY_FILE = "dictionary.txt";
    boolean add(String newWord);
    boolean find(String word);
    int size();

}
