/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum Semester {
    SPRING(1, "Spring"),
    SUMMER(2, "Summer"),
    FALL(3, "Fall");

    private int numberSemesterSelection;
    private String semesterValueString;

    private Semester(int numberSemesterSelection, String semesterValueString) {
        this.numberSemesterSelection = numberSemesterSelection;
        this.semesterValueString = semesterValueString;
    }

    public int getNumberSemesterSelection() {
        return numberSemesterSelection;
    }

    public String getSemesterValueString() {
        return semesterValueString;
    }

    public static Semester fromSemester(int number) {
        for (Semester semester : Semester.values()) {
            if (semester.getNumberSemesterSelection() == number) {
                return semester;
            }
        }
        return null;
    }
}
