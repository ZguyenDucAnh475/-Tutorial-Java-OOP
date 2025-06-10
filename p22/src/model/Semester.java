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
    FALL(1, "Fall"),
    SUMMER(2, "Summer"),
    SPRING(3, "Spring");

    private int semesterChoice;
    private String semesterString;

    private Semester(int semesterChoice, String semesterString) {
        this.semesterChoice = semesterChoice;
        this.semesterString = semesterString;
    }

    public int getSemesterChoice() {
        return semesterChoice;
    }

    public String getSemesterString() {
        return semesterString;
    }

    public static Semester fromSemester(int semesterChoice) {
        for (Semester semester : Semester.values()) {
            if (semester.getSemesterChoice() == semesterChoice) {
                return semester;
            }
        }
        return null;
    }
}
