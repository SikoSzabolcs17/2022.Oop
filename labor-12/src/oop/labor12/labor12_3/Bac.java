package oop.labor12.labor12_3;

import java.util.HashMap;

public class Bac {
    public HashMap<Integer,Student> studentHashMap;

    public Bac(HashMap<Integer, Student> studentHashMap) {
        this.studentHashMap = studentHashMap;
    }

    public HashMap<Integer, Student> getStudentHashMap() {
        return studentHashMap;
    }
}
