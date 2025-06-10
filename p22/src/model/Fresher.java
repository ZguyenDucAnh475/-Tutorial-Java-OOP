/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Year;

/**
 *
 * @author NguyenDucAnh
 */
public class Fresher {

    private Year graduationDate;
    private RankType graduationRank;
    private String education; // University name

    public Fresher(Year graduationDate, RankType graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Year getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Year graduationDate) {
        this.graduationDate = graduationDate;
    }

    public RankType getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(RankType graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

}
