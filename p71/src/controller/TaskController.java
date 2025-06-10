/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import view.TaskProgramView;
import model.Task;
import model.TaskType;
import utils.InputHandle;

/**
 *
 * @author NguyenDucAnh
 */
public class TaskController {
    
    private TaskProgramView view = new TaskProgramView();
    private InputHandle inputHandle = new InputHandle();
    private ArrayList<Task> taskList = new ArrayList<>();

    // ------------------------- VIEW -------------------------
    public void getMenu() {
        view.printMenu();
    }

    // ------------------------- ADD TASK -------------------------
    public void addTask() {
        view.printTitle("Add Task");
        String name = getName();
        TaskType type = getType();
        Date date = getDate();
        double time = getTime();
        String assginee = getAssignee();
        String reviewer = getReviewer();
        addController(name, type, date, time, assginee, reviewer);
    }
    
    private void addController(String name, TaskType type, Date date, double time, String assignee, String reviewer) {
        int id = 1;
        if (!taskList.isEmpty()) {
            id = taskList.get(taskList.size() - 1).getId() + 1;
        }
        try {
            taskList.add(new Task(id++, name, type, date, time, assignee, reviewer));
            System.out.println("Add Successfull!");
        } catch (Exception e) {
            System.err.println("Add Fail!");
        }
    }

    // ------------------------- DELETE TASK -------------------------
    public void deleteTask() {
        view.printTitle("Delete Task");
        int id = getID();
        while (findTaskByID(id) == null) {
            System.err.println(String.format("No code [%d] found!", id));
            id = getID();
        }
        deleteController(id);
    }
    
    private void deleteController(int id) {
        Task task = findTaskByID(id);
        boolean getYN = inputHandle.checkYN("Do you want to continue? Yes[Y]/No[N]: ");
        if (getYN) {
            taskList.remove(task);
            System.out.println("Delete Successfull!");
        } else {
            System.out.println("Delete Cancel...");
        }
        
        for (int i = 0; i < taskList.size(); i++) {
            taskList.get(i).setId(i + 1);
        }
    }

    // ------------------------- DISPLAY TASK -------------------------
    public void displayTask() {
        view.printView();
        for (Task o : taskList) {
            System.out.println(o.toString());
        }
    }

    // ------------------------- SUPPORT FUNCTION -------------------------
    private Task findTaskByID(int id) {
        for (Task o : taskList) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
    
    private boolean checkFromAndTo(double from, double to) {
        boolean isTrue = false;
        if (from < to) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }
    
    private void printTypeSelection() {
        System.out.println("Please choose selection number in list:");
        for (TaskType o : TaskType.values()) {
            System.out.println(o.getNumber() + " - " + o.getValue());
        }
    }
    
    public boolean isDBEmpty() {
        return taskList.isEmpty();
    }

    // ------------------------- INPUT -------------------------
    private String getName() {
        return inputHandle.getString("Requirement Name: ");
    }
    
    private TaskType getType() {
        printTypeSelection();
        int type = getIntUserInput();
        while (TaskType.fromType(type) == null) {
            System.err.println("Please choose selection number in list:");
            printTypeSelection();
            type = getIntUserInput();
        }
        return TaskType.fromType(type);
    }
    
    private double getTime() {
        double from = getFrom();
        double to = getTo();
        while (!checkFromAndTo(from, to)) {
            System.err.println("from must less than to! please input again:");
            from = getFrom();
            to = getTo();
        }
        double time = to - from;
        return time;
    }
    
    private double getFrom() {
        return inputHandle.getDouble("From(8.0 -> 17.5): ", 8.0, 17.5);
    }
    
    private double getTo() {
        return inputHandle.getDouble("To(8.0 -> 17.5): ", 8.0, 17.5);
    }
    
    private String getAssignee() {
        return inputHandle.getString("Assignee: ");
    }
    
    private String getReviewer() {
        return inputHandle.getString("Reviewer: ");
    }
    
    public int getChoice(int min, int max) {
        return inputHandle.getUserLimitChoice("Your choice: ", min, max);
    }
    
    private int getIntUserInput() {
        return inputHandle.getInt("Task Type: ");
    }
    
    private int getID() {
        return inputHandle.getInt("ID: ");
    }
    
    private Date getDate() {
        return inputHandle.getDate("Date: ");
    }
}
