package com.ideas2it.employeemanagement.model;

/**
 * POJO class used to create object of employee that contains
 * Name , DOB , Salary and Mobile Number
 * 
 * @author  sibi
 * @created 2021-02-23
 */
public class Employee {

    private int employeeId;
    private String employeeName;
    private byte employeeBirthDate;
    private byte employeeBirthMonth;
    private short employeeBirthYear;
    private float employeeSalary;
    private String employeeMobileNumber;

    private Employee() {
    }

    public Employee(int id, String name, byte date, byte month, short year, float salary, String mobileNumber) {
        this.employeeId = id;
        this.employeeName = name;
        this.employeeBirthDate = date;
        this.employeeBirthMonth = month;
        this.employeeBirthYear = year;
        this.employeeSalary = salary;
        this.employeeMobileNumber = mobileNumber;
    }

    public void setId (int id) {
        this.employeeId = id;
    }

    public void setName(String name) {
        this.employeeName = name;
    }
    
    public void setBirthDate(byte date) {
        this.employeeBirthDate = date;
    }

    public void setBirthMonth(byte month) {
        this.employeeBirthMonth = month;
    }

    public void setBirthYear(short year) {
        this.employeeBirthYear = year;
    }

    public void setSalary(float salary) {
        this.employeeSalary = salary;
    }

    public void setMobileNumber(String mobileNumber) {
        this.employeeMobileNumber = mobileNumber;
    }

    public int getId () {
        return employeeId;
    }

    public String getName() {
        return employeeName;
    }

    public byte getBirthDate() {
        return employeeBirthDate;
    }

    public byte getBirthMonth() {
        return employeeBirthMonth;
    }

    public short getBirthYear() {
        return employeeBirthYear;
    }

    public float getSalary() {
        return employeeSalary;
    }

    public String getMobileNumber() {
        return employeeMobileNumber;
    }

}