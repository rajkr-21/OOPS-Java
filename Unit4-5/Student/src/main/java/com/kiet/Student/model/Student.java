
package com.kiet.Student.model;

public class Student {

    private Long id;
    private String name;
    private String email;
    private String branch;
    private int year;
    private double cgpa;

    public Student(Long id, String name, String email,
            String branch, int year, double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
