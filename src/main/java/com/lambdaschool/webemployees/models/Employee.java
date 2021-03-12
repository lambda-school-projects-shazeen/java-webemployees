package com.lambdaschool.webemployees.models;

import javax.persistence.*;

//table in my database
//this now considered a bean - control/manage by the spring framework
//bean @Entity - annotation
//POJO - plain ol java objects - do not have @Entity - are not managed by spring framework
@Entity
//annotations
//class named singular - tables is named plural
@Table(name = "employees")
public class Employee
{
//    long vs. int - long works best in spring - more number options
//    fields - what the class knows - fields that will become a column

    //primary key - field annotation of Id - makes the next line an Id - empid = Id
    @Id
    //tell spring how i want the id to be generated
    @GeneratedValue(strategy = GenerationType.AUTO) //let the data pick and assign Id - however it sees fit
    private long empid; //primary key - unique - auto generated
    private String fname;
    private String lname;
    private double salary;

    public Employee()
    {
        //default constructor needed for JPA
    }

    public Employee(
        String fname,
        String lname,
        double salary)
    {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }

    public long getEmpid()
    {
        return empid;
    }

    //needed when we run automated test
    public void setEmpid(long empid)
    {
        this.empid = empid;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    //roughly mirrors a JSON object
    @Override
    public String toString()
    {
        return "Employee{" +
            "empid=" + empid +
            ", fname='" + fname + '\'' +
            ", lname='" + lname + '\'' +
            ", salary=" + salary +
            '}';
    }
}
