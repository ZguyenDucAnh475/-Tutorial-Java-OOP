/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public class User {

    private String name;
    private String address;
    private double salary;

    public User() {
    }

    public User(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String salaryString = String.valueOf(String.format("%.1f", getSalary()));
        String out = String.format("%-15s%-15s%-15s",
                getName(), getAddress(), salaryString);
        return out;
    }

}
