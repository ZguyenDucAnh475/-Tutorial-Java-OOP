/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum SpecializationEnum {
    orthopedics("Orthopedics", "1"),
    obstetrics("Obstetrics", "2"),
    orthodontic("Orthodontic", "3");

    private String valueOFSpecialization;
    private String numberSpecialization;

    private SpecializationEnum(String valueOFSpecialization, String numberSpecialization) {
        this.valueOFSpecialization = valueOFSpecialization;
        this.numberSpecialization = numberSpecialization;
    }

    public String getValueOFSpecialization() {
        return valueOFSpecialization;
    }

    public String getNumberSpecialization() {
        return numberSpecialization;
    }

    public static SpecializationEnum getValue(String number) {
        for (SpecializationEnum sp : SpecializationEnum.values()) {
            if (sp.getNumberSpecialization().equalsIgnoreCase(number)) {
                return sp;
            }
        }

        return null;
    }
}
