/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import model.SalaryHistory;
import model.StatusEnum;
import model.Worker;
import utils.InputHandle;
import view.WorkerView;

/**
 *
 * @author NguyenDucAnh
 */
public class WorkerController {

    private WorkerView view = new WorkerView();
    private InputHandle inputHandle = new InputHandle();
    private ArrayList<Worker> workerList = new ArrayList<>();
    private ArrayList<SalaryHistory> salaryHistoryList = new ArrayList<>();

    // ------------------------------------------- VIEW -------------------------------------------
    public void getMenu() {
        view.printTitleMenu("Worker Management");
        view.printMenu();
    }

    // ------------------------------------------- ADD WORKER -------------------------------------------
    public void addWorkerTask() {
        view.printTitle("Add Worker");
        String code = getCode();
        while (isDuplicateCode(code)) {
            System.err.println("Your code is duplicated! re-input:");
            code = getCode();
        }
        String name = getName();
        int age = getAge();
        int salary = getSalary();
        Date date = getDate();
        addController(code, name, age, salary, date);
    }

    private void addController(String newCode, String newName, int newAge, int newSalary, Date newDate) {
        workerList.add(new Worker(newCode, newName, newAge, newSalary, newDate));
        System.out.println("Add Worker Successful!");
    }

    // ------------------------------------------- UP/DOWN SALARY -------------------------------------------
    public void editSalaryTask() {
        String code = getCode();
        Worker worker = findWorkerByCode(code);

        if (worker == null) {
            System.err.println(String.format("No code [%s] was found!", code));
            return;
        }

        // Nếu chưa có lịch sử lương cho worker này -> thêm INIT
        boolean hasHistory = false;
        for (SalaryHistory sh : salaryHistoryList) {
            if (sh.getWorkerCode().equals(code)) {
                hasHistory = true;
                break;
            }
        }

        if (!hasHistory) {
            salaryHistoryList.add(new SalaryHistory(worker.getCode(), worker.getSalary(),
                    "INIT", worker.getDate()));
        }

        // Gọi xử lý tăng/giảm lương
        editSalaryTaskController(worker);
    }

    private void editSalaryTaskController(Worker worker) {
        Date newDate = getDate();

        while (!checkDate(newDate, worker.getCode())) {
            System.err.println("new date must be > old date");
            newDate = getDate();
        }

        StatusEnum getChoiceStatus = getChoiceStatus("please choice up/down salary number: ");
        UP_DOWN_Choice(getChoiceStatus.getNumberStatus(), worker, newDate);
    }

    private void UP_DOWN_Choice(int type, Worker worker, Date newDate) {
        int totalSalary = 0;
        int currentSalary = worker.getSalary();
        String status = "";

        if (type == 1) {
            System.out.println("You choose UP:");
            int upNumber = getSalaryNumber("up: ");
            totalSalary = currentSalary + upNumber;
            status = "UP";
        } else if (type == 2) {
            System.out.println("You choose DOWN:");
            int downNumber = getSalaryNumber("down: ");
            while (currentSalary < downNumber) {
                System.err.println("down number must < current salary");
                System.err.println("Total Salary: " + (currentSalary - downNumber) + "! this cannot NEGATIVE result!");
                downNumber = getSalaryNumber("down: ");
            }
            totalSalary = currentSalary - downNumber;
            status = "DOWN";
        }

        worker.setSalary(totalSalary);
        worker.setDate(newDate);
        salaryHistoryList.add(new SalaryHistory(worker.getCode(), totalSalary, status, newDate));

        System.out.println("Edit Salary [" + status + "] Succeed!");
    }

    // ------------------------------------------- DISPLAY INFO -------------------------------------------
    public void displayWorkerList() {
        for (Worker o : workerList) {
            System.out.println(o.toString());
        }
    }

    public void displayInfoSalary() {
        String code = getCode();
        Worker worker = findWorkerByCode(code);

        while (findWorkerByCode(code) == null) {
            System.err.println(String.format("No code [%s] was found!",
                    code));
            code = getCode();
            worker = findWorkerByCode(code);
        }

        if (worker != null && !salaryHistoryList.isEmpty()) {
            System.out.println("ID: " + worker.getCode());
            System.out.println("Age: " + worker.getAge());
            System.out.println("Name: " + worker.getName());
            sortDescendingDate();
            view.displayInfoSalary();
            for (SalaryHistory o : salaryHistoryList) {
                if (o.getWorkerCode().equals(code)) {
                    System.out.println(o.toString());
                }
            }
        } else {
            System.err.println("Your Salary History list is EMPTY!");
        }

    }

    // ------------------------------------------- SUPPORT FUNCTION -------------------------------------------
    public boolean isWorkerListEmpty() {
        return workerList.isEmpty();
    }

    private void sortDescendingDate() {
        salaryHistoryList.sort(Comparator.comparing(SalaryHistory::getDate).reversed());
    }

    // checking new Date must > old Date
    private boolean checkDate(Date newDate, String code) {
        Date latestDate = null;
        boolean isDateTrue = false;

        for (Worker worker : workerList) {
            if (latestDate == null || worker.getDate().after(latestDate) && (worker.getCode().equals(code))) {
                latestDate = worker.getDate();
            }
        }

        if (newDate.after(latestDate)) {
            isDateTrue = true;
        }
        if (newDate.before(latestDate)) {
            isDateTrue = false;
        }
        return isDateTrue;
    }

    private Worker findWorkerByCode(String code) {
        for (Worker o : workerList) {
            if (o.getCode().equals(code)) {
                return o;
            }
        }
        return null;
    }

    private boolean isDuplicateCode(String code) {
        for (Worker o : workerList) {
            if (o.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    private void printSelectionEnum(String msg, int type) {
        if (type == 1) {
            System.out.println(msg);
        }
        if (type == 2) {
            System.err.println(msg);
        }
        for (StatusEnum out : StatusEnum.values()) {
            System.out.println(out.getNumberStatus() + " - " + out.getNumberString());
        }
    }

    // ------------------------------------------- INPUT SUPPORT -------------------------------------------
    private StatusEnum getChoiceStatus(String msg) {
        printSelectionEnum("please input choice number in list:", 1);
        int in = inputHandle.getLimitInput(msg, 1, Integer.MAX_VALUE);

        while (StatusEnum.fromStatus(in) == null) {
            printSelectionEnum("please input choice number in list:", 2);
            in = inputHandle.getLimitInput(msg, in, Integer.MAX_VALUE);
        }
        return StatusEnum.fromStatus(in);
    }

    public int getChoice(int min, int max) {
        return inputHandle.getLimitInput("Your choice: ", min, max);
    }

    public int getSalary() {
        return inputHandle.getLimitInput("Enter new Salary: ", 1, Integer.MAX_VALUE);
    }

    private int getSalaryNumber(String msg) {
        return inputHandle.getLimitInput(msg, 1, Integer.MAX_VALUE);
    }

    public int getAge() {
        return inputHandle.getLimitInput("Enter new Age(18 - 50): ", 18, 50);
    }

    public String getCode() {
        return inputHandle.validateWorkerCode("Enter Code (e.g. W 1): ");
    }

    public String getName() {
        return inputHandle.getName("Enter Name: ");
    }

    public Date getDate() {
        return inputHandle.validateDate("Enter Date(dd/MM/yyyy): ");
    }
}
