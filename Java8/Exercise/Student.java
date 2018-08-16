package Java8.Exercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Student {
    public enum Gender{
        FEMALE,MALE
    }

    public enum Department{
        CS,CN,EE,AM,CL,EL
    }

    private Long id;
    private  String name;
    private Gender gender;
    private Integer credit;
    private LocalDate entryDate;
    private Department department;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student(Long id, String name, Gender gender, Integer credit, LocalDate entryDate, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.credit = credit;
        this.entryDate = entryDate;
        this.department = department;
    }

    public boolean isMale(){
        return this.gender == Gender.MALE;
    }
    public boolean isFemale(){
        return this.gender == Gender.FEMALE;
    }
    public String toString(){
        return "Student { " +"id = "+id+", name = "+name+", gender = "+gender+", credit = "+credit+", entryDate = "+entryDate+", department = "+department+" }";
    }
}
