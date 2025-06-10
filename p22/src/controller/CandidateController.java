/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Candidate;
import model.CandidateType;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.RankType;
import model.Semester;
import utils.CandidateHandle;
import utils.ExperienceHandle;
import utils.FresherHandle;
import utils.InputHandle;
import utils.InternHandle;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class CandidateController {

    private Candidate candidate = new Candidate();
    private ProgramView view = new ProgramView();
    private InputHandle inputHandle = new InputHandle();

    private Map<Candidate, Experience> candidateExpMap = new HashMap<>();
    private Map<Candidate, Fresher> candidateFreMap = new HashMap<>();
    private Map<Candidate, Intern> candidateInternMap = new HashMap<>();

    // ------------------------------- VIEW -------------------------------
    public void getMenu() {
        view.printMenu();
    }

    private void printCandidateInfo(Candidate c, int type) {
        String fullName = c.getLastName() + c.getFirstName();
        view.printResult("%-20s%-15s%-15s%-15s%-15s", fullName,
                c.getBirthDate(), c.getAddress(), c.getPhone(), type);
    }

    public void printResultExp() {
        view.printView("experince candidate".toUpperCase());
        for (Map.Entry<Candidate, Experience> entry : candidateExpMap.entrySet()) {
            Candidate c = entry.getKey();
            view.printFullName(c.getFirstName(), c.getLastName());
        }
    }

    public void printResultFre() {
        view.printView("fresher candidate".toUpperCase());
        for (Map.Entry<Candidate, Fresher> entry : candidateFreMap.entrySet()) {
            Candidate c = entry.getKey();
            view.printFullName(c.getFirstName(), c.getLastName());
        }
    }

    public void printResultInte() {
        view.printView("Intern candidate".toUpperCase());
        for (Map.Entry<Candidate, Intern> entry : candidateInternMap.entrySet()) {
            Candidate c = entry.getKey();
            view.printFullName(c.getFirstName(), c.getLastName());
        }
    }

    // --------------------------------- CREATE -----------------------------------
    private Candidate createCandidate() {
        String newCandidateID = candidate.getCandidateID();
        String newFirstName = CandidateHandle.getStringName("First Name: ");
        String newLastName = CandidateHandle.getStringName("Last Name: ");
        Year birthDate = CandidateHandle.getBirthDate("Birth Date(1900 - now): ");
        String newAddress = CandidateHandle.getAddress("Address: ");
        String newPhone = CandidateHandle.getPhone("Phone: ");
        CandidateType type = candidate.getType();

        return new Candidate(newCandidateID, newFirstName, newLastName,
                birthDate, newAddress, newPhone, type);
    }

    private Experience createExperience() {
        int ExpInYear = ExperienceHandle.getExpInYear("Experience in year: ", 0, 100);
        String proSkill = ExperienceHandle.getProSkill("Pro skill: ");

        return new Experience(ExpInYear, proSkill);
    }

    private Fresher createFresher() {
        Year newGraduationDate = FresherHandle.getGraduationDate("Graduation Date(1900 - now) [yyyy]: ");
        RankType graduationRank = getRankType();
        String education = FresherHandle.getEducation("Education: ");

        return new Fresher(newGraduationDate, graduationRank, education);
    }

    private Intern createIntern() {
        String newMajor = InternHandle.getMajors("Majors: ");
        Semester newSemeter = getSemester();
        String newUniversityName = InternHandle.getUniversityName("university Name: ");

        return new Intern(newMajor, newSemeter, newUniversityName);
    }

    // ------------------------------------- RUN --------------------------------------------
    public void runCandidateExp() {
        String candidateID = CandidateHandle.candidateID("Enter ID (CD 1): ");
        while (containsCandidateIDExp(candidateID)) {
            System.err.println("candidate ID is existed!");
            candidateID = CandidateHandle.candidateID("Enter ID (CD 1): ");
        }
        candidate.setType(CandidateType.EXPERIENCE);
        candidate.setCandidateID(candidateID);
        Candidate c = createCandidate();
        Experience e = createExperience();

        candidateExpMap.put(c, e);
    }

    public void runCandidateFres() {
        String candidateID = CandidateHandle.candidateID("Enter ID (CD 1): ");
        while (containsCandidateIDFres(candidateID)) {
            System.err.println("candidate ID is existed!");
            candidateID = CandidateHandle.candidateID("Enter ID (CD 1): ");
        }
        candidate.setType(CandidateType.FRESHER);
        candidate.setCandidateID(candidateID);
        Candidate c = createCandidate();
        Fresher f = createFresher();

        candidateFreMap.put(c, f);
    }

    public void runCandidateIntern() {
        String candidateID = CandidateHandle.candidateID("Enter ID (CD 1): ");
        while (containsCandidateIDIntern(candidateID)) {
            System.err.println("candidate ID is existed!");
            candidateID = CandidateHandle.candidateID("Enter ID (CD 1): ");
        }
        candidate.setType(CandidateType.INTERN);
        candidate.setCandidateID(candidateID);
        Candidate c = createCandidate();
        Intern i = createIntern();

        candidateInternMap.put(c, i);
    }

    // -------------------------------- SEARCH CANDIDATE ------------------------------
    public void searchCandidates() {
        printResultExp();
        printResultFre();
        printResultInte();

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Candidate name (First name or Last name): ");
        String nameInput = sc.nextLine().trim().toLowerCase();

        System.out.print("Input type of candidate (0 = Experience, 1 = Fresher, 2 = Intern): ");
        int typeInput = Integer.parseInt(sc.nextLine());

        System.out.println("\nThe candidates found:");

        switch (typeInput) {
            case 0: // Experience
                for (Map.Entry<Candidate, Experience> entry : candidateExpMap.entrySet()) {
                    Candidate c = entry.getKey();
                    if (matchName(c, nameInput)) {
                        printCandidateInfo(c, 0);
                    }
                }
                break;
            case 1: // Fresher
                for (Map.Entry<Candidate, Fresher> entry : candidateFreMap.entrySet()) {
                    Candidate c = entry.getKey();
                    if (matchName(c, nameInput)) {
                        printCandidateInfo(c, 1);
                    }
                }
                break;
            case 2: // Intern
                for (Map.Entry<Candidate, Intern> entry : candidateInternMap.entrySet()) {
                    Candidate c = entry.getKey();
                    if (matchName(c, nameInput)) {
                        printCandidateInfo(c, 2);
                    }
                }
                break;
            default:
                System.out.println("Invalid candidate type!");
        }
    }

    // ------------------------------- SUPPORT FUNCTION -------------------------------
    private boolean matchName(Candidate c, String nameInput) {
        return c.getFirstName().toLowerCase().contains(nameInput)
                || c.getLastName().toLowerCase().contains(nameInput);
    }

    private boolean containsCandidateIDExp(String candidateID) {
        for (Candidate c : candidateExpMap.keySet()) {
            if (c.getCandidateID().equals(candidateID)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsCandidateIDFres(String candidateID) {
        for (Candidate c : candidateFreMap.keySet()) {
            if (c.getCandidateID().equals(candidateID)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsCandidateIDIntern(String candidateID) {
        for (Candidate c : candidateInternMap.keySet()) {
            if (c.getCandidateID().equals(candidateID)) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------- SUPPORT FUNCTION -------------------------------------
    private void printSelectionTypeRank(int type, String msg) {
        if (type == 0) {
            System.out.println(msg);
        }
        if (type == -1) {
            System.err.println(msg);
        }

        for (RankType rankType : RankType.values()) {
            System.out.println(rankType.getTypeRankChoice() + " - "
                    + rankType.getTypeRankString());
        }
    }

    private void printSelectionSemester(int type, String msg) {
        if (type == 0) {
            System.out.println(msg);
        }
        if (type == -1) {
            System.err.println(msg);
        }

        for (Semester semester : Semester.values()) {
            System.out.println(semester.getSemesterChoice() + " - " + semester.getSemesterString());
        }
    }

    // ------------------------------------- INPUT -------------------------------------
    private RankType getRankType() {
        printSelectionTypeRank(0, "Please input selection in list [Type of rank]:");
        int selectNumber = inputHandle.getLimitInput("Your choice [Rank Type]: ", 1, RankType.values().length);
        while (RankType.fromRank(selectNumber) == null) {
            printSelectionTypeRank(-1, "Please input selection in list [Type of rank]:");
            selectNumber = inputHandle.getLimitInput("Your choice [Rank Type]: ", 1, RankType.values().length);
        }

        return RankType.fromRank(selectNumber);
    }

    private Semester getSemester() {
        printSelectionSemester(0, "Please input selection in list [Semester]:");
        int selectNumber = inputHandle.getLimitInput("Your choice [Semester]: ", 1, Semester.values().length);
        while (Semester.fromSemester(selectNumber) == null) {
            printSelectionSemester(-1, "Please input selection in list [Semester]:");
            selectNumber = inputHandle.getLimitInput("Your choice [Semester]: ", 1, Semester.values().length);
        }

        return Semester.fromSemester(selectNumber);
    }

    public int getUserChoice(String msg, int min, int max) {
        return inputHandle.getLimitInput(msg, min, max);
    }

}
