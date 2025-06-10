/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Comparator;
import model.Doctor;
import model.SpecializationEnum;
import utils.InputHandle;
import view.DoctorView;

/**
 *
 * @author NguyenDucAnh
 */
public class DoctorController {

    private DoctorView view = new DoctorView();
    private InputHandle inputHandle = new InputHandle();
    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public void generateDB() {
        doctorList.add(new Doctor("DOC 1", "Kien", SpecializationEnum.orthodontic, 1));
        doctorList.add(new Doctor("DOC 2", "An", SpecializationEnum.orthodontic, 5));
        doctorList.add(new Doctor("DOC 5", "Duy", SpecializationEnum.obstetrics, 4));
        doctorList.add(new Doctor("DOC 6", "Huy", SpecializationEnum.obstetrics, 6));
        doctorList.add(new Doctor("DOC 7", "Lan", SpecializationEnum.obstetrics, 1));
        doctorList.add(new Doctor("DOC 8", "Minh", SpecializationEnum.orthodontic, 7));
        doctorList.add(new Doctor("DOC 9", "Nam", SpecializationEnum.orthopedics, 2));
        doctorList.add(new Doctor("DOC 10", "Tuan", SpecializationEnum.orthopedics, 3));
        doctorList.add(new Doctor("DOC 3", "Bao", SpecializationEnum.orthopedics, 3));
        doctorList.add(new Doctor("DOC 4", "Chi", SpecializationEnum.orthodontic, 2));

    }

    // ---------------------------------- VIEW ----------------------------------
    private void displayResult(ArrayList<Doctor> result) {
        if (!result.isEmpty()) {
            view.printTitleView("Result");
            view.printResultView();
            for (Doctor o : result) {
                System.out.println(o.toString());
            }
        } else {
            System.err.println("This list empty!");
        }
    }

    public void displayList() {
        if (!doctorList.isEmpty()) {
            view.printResultView();
            for (Doctor o : doctorList) {
                System.out.println(o.toString());
            }
        } else {
            System.err.println("This list empty!");
        }
    }

    public void displayDoctorMenu() {
        view.displayDoctorMenu();
    }

    // ---------------------------------- ADD TASK ----------------------------------
    public void addTask() {
        view.printTitleView("Add Doctor");
        String code = inputHandle.CodeValidate("Enter Code: ");
        while (isDuplicatedCode(code)) {
            System.err.println("Your code is duplicated in list! please input agian:");
            code = inputHandle.CodeValidate("Enter new Code: ");
        }
        String name = inputHandle.getString("Enter Name: ");
        SpecializationEnum spec = getSpecInput("Enter Specialization: ");
        int avai = inputHandle.getInt("Enter Availability: ");
        addController(code, name, spec, avai);
    }

    private void addController(String code, String name, SpecializationEnum spec, int avai) {
        doctorList.add(new Doctor(code, name, spec, avai));
        System.out.println("Add Successfull!");
    }

    // ---------------------------------- UPDATE TASK ----------------------------------
    public void updateTask() {
        view.printTitleView("Update Doctor");
        String code = inputHandle.CodeValidate("Enter Code: ");
        //updateController(code);
        updateChoice(code);
    }

    private void updateController(String code) {
        Doctor doctor = findDoctorByCode(code);

        while (doctor == null) {
            System.err.println(String.format("No %s found! re-input:", code));
            code = inputHandle.CodeValidate("Enter Code: ");
        }
        String name = inputHandle.getString("Enter Name: ");
        SpecializationEnum spec = getSpecInput("Enter Specialization: ");
        int avai = inputHandle.getInt("Enter Availability: ");
        setValueForUpdate(code, name, spec, avai);
    }

    private void updateChoice(String code) {
        Doctor doctor = findDoctorByCode(code);
        if (doctor == null) {
            System.out.println("No doctor found!");
            return;
        }

        while (true) {
            System.out.println("What do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Specialization");
            System.out.println("3. Availability");
            int choice = getChoice(1, 3);
            switch (choice) {
                case 1:
                    String newName = inputHandle.getString("Enter new name: ");
                    doctor.setName(newName);
                    view.printUpdateView("Name");
                    break;
                case 2:
                    SpecializationEnum newSpec = getSpecInput("Enter new specialization: ");
                    doctor.setSpecialization(newSpec);
                    view.printUpdateView("Specialization");
                    break;
                case 3:
                    int newAvai = inputHandle.getInt("Enter new availability: ");
                    doctor.setAvailability(newAvai);
                    view.printUpdateView("Availability");
                    break;
            }

            boolean getYN = inputHandle.checkYN("Do you want to continue updating this doctor? (Y/N): ");
            if (!getYN) {
                break;
            }
        }

        System.out.println("Doctor updated successfully!");
    }

    private void setValueForUpdate(String code, String name, SpecializationEnum spec, int avai) {
        for (Doctor o : doctorList) {
            if (o.getCode().equals(code)) {
                o.setName(name);
                o.setSpecialization(spec);
                o.setAvailability(avai);
            }
        }
        System.out.println("Update Successfull!");
    }

    // ---------------------------------- DELETE TASK ----------------------------------
    public void deleteDoctor() {
        view.printTitleView("Delete Doctor");
        String delete = inputHandle.CodeValidate("Enter Code: ");
        deleteByCode(delete);
    }

    private void deleteByCode(String code) {
        Doctor doctor = findDoctorByCode(code);

        while (doctor == null) {
            System.err.println(String.format("No [%s] be found!", code));
            String inputAgain = inputHandle.CodeValidate("Enter Code: ");
            doctor = findDoctorByCode(inputAgain);
        }

        doctorList.remove(doctor);

        System.out.println("Remove Successfull!");
    }

    // ---------------------------------- SEARCH TASK ----------------------------------
    public void searchTask() {
        view.printTitleView("Search Doctor");
        String text = inputHandle.getString("Enter text: ");
        ArrayList<Doctor> newResult = searchDoctorByText(text);
        displayResult(newResult);
        newResult.clear();
    }

    private ArrayList<Doctor> searchDoctorByText(String keywordText) {
        ArrayList<Doctor> result = new ArrayList<>();
        boolean matched = false;
        sortByName("Sort list increase by name!");
        for (Doctor o : doctorList) {
            if (o.getName().toLowerCase().contains(keywordText.toLowerCase())
                    || o.getCode().toLowerCase().contains(keywordText.toLowerCase())
                    || o.getSpecialization().getValueOFSpecialization().toLowerCase().contains(keywordText.toLowerCase())
                    || String.valueOf(o.getAvailability()).equalsIgnoreCase(keywordText)) {
                result.add(o);
                matched = true;

            }
        }

        if (!matched) {
            System.err.println("No match found for keyword: " + keywordText);
        }

        return result;
    }

    private ArrayList<Doctor> sortByName(String msg) {
        System.out.println(msg);
        doctorList.sort(Comparator.comparing(Doctor::getName)); // tăng dần
//        doctorList.sort(Comparator.comparing(Doctor::getName).reversed()); // giảm dần 
        return doctorList;
    }

    // ---------------------------------- SUPPORT FUNCTION ----------------------------------
    private Doctor findDoctorByCode(String code) {
        for (Doctor o : doctorList) {
            if (o.getCode().equals(code)) {
                return o;
            }
        }
        return null;
    }

    private void printSlectionSpecView() {
        for (SpecializationEnum specE : SpecializationEnum.values()) {
            System.out.println(specE.getNumberSpecialization() + " - " + specE.getValueOFSpecialization());
        }
    }

    private boolean isDuplicatedCode(String code) {
        for (Doctor o : doctorList) {
            if (o.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    // ---------------------------------- INPUT FUNCTION ----------------------------------
    private String getSpecializationInput(String msg) {
        return inputHandle.getString(msg);
    }

    protected SpecializationEnum getSpecInput(String msg) {
        printSlectionSpecView();
        System.out.println("Choose number in list!");
        String input = getSpecializationInput(msg);
        while (SpecializationEnum.getValue(input) == null) {
            System.err.println("Plese re-input value in list:");
            printSlectionSpecView();
            input = getSpecializationInput(msg);
        }
        return SpecializationEnum.getValue(input);
    }

    public int getChoice(int min, int max) {
        return inputHandle.getuserLimit("Your choice: ", min, max);
    }

    public boolean isDBEmpty() {
        return doctorList.isEmpty();
    }

}
