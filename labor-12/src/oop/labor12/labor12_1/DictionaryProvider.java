package oop.labor12.labor12_1;

public class DictionaryProvider {
    public static IDictionary createDictionary(DictionaryType dictionaryType ){

        IDictionary dictionary = null;

        switch( dictionaryType ){
            case ARRAY_LIST: dictionary= ArrayListDictionary.newInstance(); break;
            case HASH_SET : dictionary=HashSetDictionary.newInstance(); break;
            case TREE_SET : dictionary=TreeSetDictionary.newInstance(); break;
        }
        return dictionary;
    }

}
