package com.lambdaschool.webemployees.models;

import javax.persistence.Entity;

//table in my database
//this now considered a bean - control/manage by the spring framework
//bean @Entity - annotation
//POJO - plain ol java objects - do not have @Entity - are not managed by spring framework
@Entity
public class Employee
{
//    long vs. int - long works best in spring
    private long empid;
    private String fname;
    private String lname;
    private double salary;
}
