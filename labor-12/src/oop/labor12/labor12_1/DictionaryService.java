package oop.labor12.labor12_1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {

    private IDictionary dictionary;

    public DictionaryService(DictionaryType dictionaryType){

        dictionary = DictionaryProvider.createDictionary(dictionaryType);
        findWordsFile("dict.txt");
    }
    public boolean findWord(String word){
        return dictionary.find(word);
    }
    public ArrayList<String> findWordsFile(String fileName){

        ArrayList<String> words = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String word = scanner.next();

                if(!findWord(word)){
                    words.add(word);
                    dictionary.add(word);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return words;
    }
}
