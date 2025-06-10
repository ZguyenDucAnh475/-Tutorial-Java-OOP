/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum Course {
    JAVA(1, "Java"),
    CPP(2, "Cpp"),
    PYTHON(3, "Python"),
    NET(4, "Net");

    private int numberCourseSelection;
    private String courseValueString;

    private Course(int numberCourseSelection, String courseValueString) {
        this.numberCourseSelection = numberCourseSelection;
        this.courseValueString = courseValueString;
    }

    public int getNumberCourseSelection() {
        return numberCourseSelection;
    }

    public String getCourseValueString() {
        return courseValueString;
    }

    public static Course fromCourse(int number) {
        for (Course course : Course.values()) {
            if (course.getNumberCourseSelection() == number) {
                return course;
            }
        }
        return null;
    }
}
