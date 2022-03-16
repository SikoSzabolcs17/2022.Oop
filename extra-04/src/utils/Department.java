package utils;

import java.util.ArrayList;

public class Department {
    ArrayList<String> departmentList;

    public Department(){
        this.departmentList = new ArrayList<>();
    }
    public void alreadyInList(String newDepartment){

        if(!departmentList.contains(newDepartment)){
            departmentList.add(newDepartment);
        }
    }
}
