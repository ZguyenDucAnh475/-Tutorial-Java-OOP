/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum RankType {
    EXCELLENCE(1, "Excelence"),
    GOOD(2, "Good"),
    FAIR(3, "Fair"),
    PORR(4, "Poor");

    private int typeRankChoice;
    private String typeRankString;

    private RankType(int typeRankChoice, String typeRankString) {
        this.typeRankChoice = typeRankChoice;
        this.typeRankString = typeRankString;
    }

    public int getTypeRankChoice() {
        return typeRankChoice;
    }

    public String getTypeRankString() {
        return typeRankString;
    }

    public static RankType fromRank(int number) {
        for (RankType type : RankType.values()) {
            if (type.getTypeRankChoice() == number) {
                return type;
            }
        }
        return null;
    }
}
