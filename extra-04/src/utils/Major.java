package utils;

import java.util.ArrayList;

public class Major {
    ArrayList<String> majorList;

    public Major(){
        majorList = new ArrayList<>();
    }
    public void alreadyInList(String newMajor){
        if(!majorList.contains(newMajor)){
            majorList.add(newMajor);
        }
    }
}
