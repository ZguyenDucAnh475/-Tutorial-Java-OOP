/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author NguyenDucAnh
 */
public class Worker {

    private String code;
    private String name;
    private int age;
    private int salary;
    private Date date;

    public Worker(String id, String name, int age, int salary, Date date) {
        this.code = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Worker{" + "code=" + code + ", name=" + name + ", age=" + age + ", salary=" + salary + ", date=" + date + '}';
    }

}
