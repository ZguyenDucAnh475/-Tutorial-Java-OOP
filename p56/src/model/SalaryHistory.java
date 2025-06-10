/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NguyenDucAnh
 */
public class SalaryHistory {

    private String workerCode;
    private int salary;
    private String status;
    private Date date;

    public SalaryHistory() {
    }

    public SalaryHistory(String workerID, int salary, String status, Date date) {
        this.workerCode = workerID;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public String getWorkerCode() {
        return workerCode;
    }

    public int getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatted = sdf.format(date);
        String out = String.format("%-15s%-15s%-15s%-15s",
                getWorkerCode(),String.valueOf(getSalary()),getStatus(),formatted);
        return out;
    }

}
