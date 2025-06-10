/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public class Doctor {

    private String Code;
    private String Name;
    private SpecializationEnum Specialization;
    private int Availability;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public SpecializationEnum getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(SpecializationEnum Specialization) {
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    public Doctor(String Code, String Name, SpecializationEnum Specialization, int Availability) {
        this.Code = Code;
        this.Name = Name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    public Doctor() {
    }

    @Override
    public String toString() {
        String out = String.format("%-10s%-15s%-20s%-15s", getCode(), getName(),
                getSpecialization().getValueOFSpecialization(), String.valueOf(getAvailability()));
        return out;
    }

}
