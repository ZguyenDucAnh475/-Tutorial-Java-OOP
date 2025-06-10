/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.Expense;
import utils.InputHandle;
import view.ExpenseView;

/**
 *
 * @author NguyenDucAnh
 */
public class ExpenseController {
    
    private ExpenseView view = new ExpenseView();
    private InputHandle inputHandle = new InputHandle();
    private ArrayList<Expense> expenses = new ArrayList<>();
    
    public void generateDB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            expenses.add(new Expense(1, sdf.parse("11-Apr-2009"), 100, "Tuition fee"));
            expenses.add(new Expense(2, sdf.parse("20-Apr-2009"), 250, "Rent house"));
            expenses.add(new Expense(3, sdf.parse("30-Apr-2009"), 200, "Food"));
        } catch (ParseException e) {
            System.err.println("Cannot generate db!");
        }
    }

    // ------------------------------- VIEW -------------------------------
    public void getMenu() {
        view.printMenu();
    }
    
    public void getResult() {
        view.printResult();
    }
    
    public void displayAllExpenses() {
        if (!isDBEmpty()) {
            int total = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            
            getResult();
            for (Expense e : expenses) {
                
                System.out.printf("%-5s%-20s%-15s%-15s\n",
                        String.valueOf(e.getId()),
                        sdf.format(e.getDate()),
                        String.valueOf(e.getMoney()),
                        e.getContent()
                );
                
                total += e.getMoney();
            }
            
            System.out.printf("%30s %d\n", "Total:", total);
        } else {
            System.err.println("List empty!");
        }
    }

    // ------------------------------- ADD AN EXPENSE -------------------------------
    public void addTask() {
        Date newDate = getDate("Enter Date: ");
        int newAmount = getAmount("Enter Amount: ");
        String newContent = getContent("Enter Content: ");
        addController(newDate, newAmount, newContent);
    }
    
    private void addController(Date date, int amount, String content) {
        int id = 1;
        if (!expenses.isEmpty()) {
            id = expenses.get(expenses.size() - 1).getId() + 1;
        }
        try {
            Expense e = new Expense(id, date, amount, content);
            expenses.add(e);
            System.out.println("Add Successfull!");
        } catch (Exception e) {
            System.err.println("Add Fail!");
        }
    }

    // ------------------------------- DELETE AN EXPENSE -------------------------------
    public void deleteExpense(String msg) {
        if (!isDBEmpty()) {
            System.out.print(msg);
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine().trim();
            int number = Integer.parseInt(id);
            while (findExpenseByID(number) == null) {
                id = scanner.nextLine().trim();
                number = Integer.parseInt(id);
            }
            deleteController(number);
        } else {
            System.err.println("List empty!");
        }
    }
    
    private void deleteController(int id) {
        Expense expense = findExpenseByID(id);
        if (expense == null) {
            System.out.println("Expense ID not exist!");
        } else {
            expenses.remove(expense);
            System.out.println("Delete Successfully!");
        }
        
        for (int i = 0; i < expenses.size(); i++) {
            expenses.get(i).setId(i + 1);
        }
    }

    // ------------------------------- SUPPORT -------------------------------
    private Expense findExpenseByID(int id) {
        for (Expense o : expenses) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
    
    public boolean isDBEmpty() {
        return expenses.isEmpty();
    }
    
    public int getChoice(String msg, int min, int max) {
        return inputHandle.getUserNumberLimit(msg, min, max);
    }
    
    public int getAmount(String msg) {
        return inputHandle.getAmountValue(msg);
    }
    
    public String getContent(String msg) {
        return inputHandle.getContentValue(msg);
    }
    
    public Date getDate(String msg) {
        return inputHandle.getDateValue(msg);
    }
    
}
