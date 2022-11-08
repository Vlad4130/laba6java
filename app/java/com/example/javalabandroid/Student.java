package com.example.javalabandroid;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String name;
    private String groupNumber;

    public Student (String name, String groupNumber){
        this.name = name;
        this.groupNumber = groupNumber;

    }


    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }



    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    private final static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student("Іванов Іван", "301"),
                    new Student("Олександр Сергійович", "301"),
                    new Student("Сергій Іванович", "302"),
                    new Student("Андрій Володимирович", "302"),
                    new Student("Евген Сергійович", "306"),
                    new Student("Миколай Миколайович", "309")
            )
    );
    public static ArrayList<Student>getStudents(){
        return getStudents("");
    }
    public static ArrayList<Student> getStudents(String groupNumber){
        ArrayList<Student> stList = new ArrayList<>();
        for (Student s: students){
            if(s.getGroupNumber().equals(groupNumber)||(groupNumber == ""))
            {
                stList.add(s);
            }
        }
        return stList;
    }
}
