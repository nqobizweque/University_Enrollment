package com.bbd;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Student> students;
    private int capacity;
    static int numberOfCourses;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        Course.numberOfCourses += 1;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean enrollStudent(Student s){
        if (students.size() >= capacity)
            return false;
        return students.add(s);
    }

    public boolean unenrollStudent(Student s){
        return students.remove(s);
    }

    public Student getStudent(int i){
        try{
            return students.get(i);
        }catch (Exception e){
            return null;
        }
    }

    public boolean contains(Student s){
        return students.contains(s);
    }

    public int getStudentCount(){
        return students.size();
    }


}
