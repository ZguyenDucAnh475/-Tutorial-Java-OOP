/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;
import utils.MD5validate;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class ProgramController {

    private ProgramView view = new ProgramView();
    private ArrayList<User> userList = new ArrayList<>();
    private MD5validate hashValue = new MD5validate();

    public void generateDB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            userList.add(new User("edm", "21232f297a57a5a743894a0e4a801fc3",
                    "Duc Anh", "0866995304", "DucAnh@gmail.com",
                    "Ha Noi", sdf.parse("23/10/2002")));
            System.out.println("Create successful!");
        } catch (Exception e) {
            System.out.println("Cant generate!");
        }
    }

//    public void display() {
//        String out = hashValue.validateHashMD5("Enter value: ");
//        String mg = hashValue.changeValueToMD5("admin");
//        System.out.println(out);
//        System.out.println(mg);
//        if (check(out, mg)) {
//            System.out.println("Equal!");
//        } else {
//            System.out.println("Not equal!");
//        }
//    }
//
    // ------------------------------ VIEW ------------------------------
    public void getMenu() {
        view.menuDisplay();
    }

    // ------------------------------ ADD ACCOUNT ------------------------------
    // ------------------------------ LOGIN - CHANGE PASSWORD ------------------
    public void loginTask() {
        Scanner scanner = new Scanner(System.in);
        String account = scanner.nextLine().trim();
        String password = hashValue.validateHashMD5("Password: ");
        User userAccount = findUserByAccount(account);
        loginController(userAccount, password);
    }

    private void loginController(User userAccount, String inputPassword) {
        if (checkHashPass(inputPassword, userAccount.getPassword())) {
            System.out.println("Login successful!");
            userAccount.setPassword(hashValue.changeValueToMD5("meme"));
        } else {
            System.out.println("Cannot login!");
        }
        System.out.println("newPass(meme): ");
        System.out.println(userAccount.getPassword());
    }

    // ------------------------------ SUPPORT FUNCTION -------------------------
    private User findUserByAccount(String account) {
        for (User o : userList) {
            if (o.getAccount().toLowerCase().equalsIgnoreCase(account)) {
                return o;
            }
        }
        return null;
    }

    private boolean isDuplicatedAccount(String account) {
        for (User o : userList) {
            if (o.getAccount().toLowerCase().equalsIgnoreCase(account)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHashPass(String in1, String in2) {
        return in1.equalsIgnoreCase(in2);
    }
    // ------------------------------ INPUT FUNCTION ---------------------------

}
