package utils;

import java.util.ArrayList;

public class Degree {

    public ArrayList<String> degreeList;

    public Degree(){
        this.degreeList = new ArrayList<>();
    }
    public void alreadyInList(String newDegree){

        if(!degreeList.contains(newDegree)){
            degreeList.add(newDegree);
        }
    }
}
