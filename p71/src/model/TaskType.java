/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");

    private int number;
    private String value;

    private TaskType(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public static TaskType fromType(int number) {
        for (TaskType o : TaskType.values()) {
            if (o.getNumber() == number) {
                return o;
            }
        }
        return null;
    }
}
