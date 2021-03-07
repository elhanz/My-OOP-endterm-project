package entities;

import java.time.LocalDate;

public class Employee  {
    private int id;
    private String name;
    private String surname;
    private String job;
    private LocalDate dateOfHiring;
    private int salary;

    public Employee() {

    }

    public Employee(int id, String name, String surname, String job, LocalDate dateOfHiring, int salary) {//to show employees
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job=job;
        this.dateOfHiring=dateOfHiring;
        this.salary = salary;
    }

    public Employee( String name, String surname, String job, LocalDate dateOfHiring, int salary) {// to add employees
        this.name = name;
        this.surname = surname;
        this.job=job;
        this.dateOfHiring=dateOfHiring;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(LocalDate dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", job='" + job + '\'' +
                ", dateOfHiring=" + dateOfHiring +
                ", salary=" + salary +
                '}';
    }
}