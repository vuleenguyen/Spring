package com.lee;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Student> studentSet = new HashSet<>();
        Student student = new Student(15, "vu");
        Student student2 = new Student(15, "vu");
        studentSet.add(student);
        studentSet.add(student2);
        System.out.println(studentSet.size());
        System.out.println(student.equals(student2));
    }
}


class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }
//
    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
