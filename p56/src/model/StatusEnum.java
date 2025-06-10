/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum StatusEnum {
    UP(1, "UP"),
    DOWN(2, "DOWN");

    private int numberStatus;
    private String numberString;

    private StatusEnum(int numberStatus, String numberString) {
        this.numberStatus = numberStatus;
        this.numberString = numberString;
    }

    public int getNumberStatus() {
        return numberStatus;
    }

    public String getNumberString() {
        return numberString;
    }

    public static StatusEnum fromStatus(int number) {
        for (StatusEnum o : StatusEnum.values()) {
            if (o.getNumberStatus() == number) {
                return o;
            }
        }
        return null;
    }
}
