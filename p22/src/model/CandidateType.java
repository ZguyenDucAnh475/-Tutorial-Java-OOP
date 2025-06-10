/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum CandidateType {
    EXPERIENCE(1, "For Experience candidate"),
    FRESHER(2, "For fresher candidate"),
    INTERN(3, "For Intern candidate");

    private int candidateTypeChoice;
    private String candidateTypeString;

    private CandidateType(int candidateTypeChoice, String candidateTypeString) {
        this.candidateTypeChoice = candidateTypeChoice;
        this.candidateTypeString = candidateTypeString;
    }

    public int getCandidateTypeChoice() {
        return candidateTypeChoice;
    }

    public String getCandidateTypeString() {
        return candidateTypeString;
    }

    public static CandidateType fromType(int number) {
        for (CandidateType type : CandidateType.values()) {
            if (type.getCandidateTypeChoice() == number) {
                return type;
            }
        }
        return null;
    }
}
