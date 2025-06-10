/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Locale;
import java.util.ResourceBundle;
import view.LoginView;

/**
 *
 * @author NguyenDucAnh
 */
public class LoginController {

    private LoginView view = new LoginView();

    // --------------------------------- VIEW
    // PROGRESS
    private void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("Model/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.println(value);
    }

    private void login(Locale language) {
        getWordLanguage(language, "so_tai_khoan");
        String accountNumber = getAccountNumber();
        getWordLanguage(language, "mat_khau");
        String password = getPassword();
        getWordLanguage(language, "nhap_captcha");
        String captcha = getCaptcha();

    }
    // SUPPORT

    // INPUT
    private String getAccountNumber() {
        return "";
    }

    private String getPassword() {
        return "";
    }

    private String getCaptcha() {
        return "";
    }

    public int getChoiceInput(String msg, int min, int max) {
        return 0;
    }
}
