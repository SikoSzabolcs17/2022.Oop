package oop.labor12.labor12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static HashMap<Integer,Student> readFromFileStudents(String fileName){
        HashMap<Integer,Student> students = new HashMap<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] args = line.split(" ");
                int id = 0;
                try {
                    id = Integer.parseInt(args[0].trim());
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
                String firstName = args[1].trim();
                String lastName = args[2].trim();
                students.put(id,new Student(id,firstName,lastName));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return students;
    }
    public static void readMarkFromFile(String fileName,String subject,Bac bac){

        HashMap<Integer,Student> student = bac.getStudentHashMap();

        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] args = line.split(" ");
                int id = 0;
                double grade=0;
                try {
                    id = Integer.parseInt(args[0].trim());
                    grade = Double.parseDouble(args[1].trim());
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
                student.get(id).getMarks().add(new Mark(grade,subject));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    public static HashSet<Student> failedStudents(Bac bac){
        HashMap<Integer,Student> students = bac.getStudentHashMap();

        HashSet<Student> failedStundens = new HashSet<>();

        for (Integer key:students.keySet()){
            double avg = 0;
            for (Mark mark:students.get(key).getMarks()){
                if(mark.getGrade() < 5){
                    avg = -1;
                    break;
                }
                avg+= mark.getGrade();
            }
            avg = avg / students.get(key).getMarks().size();
            if(avg <6){
                failedStundens.add(students.get(key));
            }
        }
        return failedStundens;
    }

    public static void main(String[] args) {
        Bac bac = new Bac(readFromFileStudents("nevek1.txt"));
        readMarkFromFile("matek.txt","matek",bac);
        readMarkFromFile("magyar.txt","magyar",bac);
        readMarkFromFile("roman.txt","roman",bac);


        HashSet<Student> failedStudents = failedStudents(bac);

        System.out.println("From " + bac.getStudentHashMap().size() + " students " + (bac.getStudentHashMap().size()-failedStudents.size()) + " has passed the bac!");


        ArrayList<Student> sortedList = new ArrayList<>(failedStudents);

        sortedList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String name1 = o1.getFirstName() + o1.getLastName();
                String name2 = o2.getFirstName() + o2.getLastName();
                return name1.compareTo(name2);
            }
        });

        for (Student student:sortedList){
            System.out.println(student);
        }

    }
}
