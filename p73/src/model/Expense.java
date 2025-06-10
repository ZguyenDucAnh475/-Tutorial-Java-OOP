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
public class Expense {

    private int id;
    private Date date;
    private int money;
    private String content;

    public Expense() {
    }

    public Expense(int id, Date date, int money, String content) {
        this.id = id;
        this.date = date;
        this.money = money;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String out = String.format("%-5s%-20s%-15s%-15s",
                String.valueOf(getId()), String.valueOf(getDate()), String.valueOf(getMoney()), getContent());
        return out;
    }

}
