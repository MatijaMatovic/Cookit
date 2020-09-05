/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import model.Account;
import model.Recipe;
import model.RecipeBook;
import view.MainWindow;
import view.RecipePanel;
import view.loginWindow.LoginEvent;
import view.loginWindow.LoginListener;
import view.loginWindow.LoginWindow;

/**
 *
 * @author Jovana
 */
public class Kontroler {

    public static RecipeBook rb;
    
    public static void main(String[] args) {
        rb = new RecipeBook();
        Kontroler k = new Kontroler();
        MainWindow mw = k.createMainWindow();
        mw.setVisible(true);
    }

    public RecipePanel createRecipePanel(Recipe r) {
        RecipePanel rp = new RecipePanel();
        rp.setRecipeId(r.getId());
        rp.getDateLabel().setText(r.getCreationDate()
                .format(DateTimeFormatter
                        .ofPattern("dd.MM.yyyy. HH:mm")));
        rp.getNameLabel().setText(r.getName());
        /* If instructions are longer than 280 chars, it chopps it off */
 /* <html> tags enable the formatting of text in the label      */
        rp.getInstructionsLabel().setText("<html>" + r.getText().substring(0,
                Math.min(r.getText().length(), 280)) + "...</html>");
        rp.getReviewsLabel().setText(Double.toString(r.calculateGradeAvg()));
        rp.getIngredientsLabel().setText(r.getIngredientsString());
        rp.getAppliancesLabel().setText(r.getAppliancesString());
        rp.getAuthorLabel().setText(r.getAuthor().getAccount().getUsername());
        return rp;
    }

    public MainWindow createMainWindow() {
        MainWindow mw = new MainWindow();

        mw.setLoginLblListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb.getCurrentAccount() == null) {
                    createLoginWindow();
                    mw.changeLoginLbl(false);
                } else {
                    rb.setCurrentAccount(null);
                    mw.changeLoginLbl(true);
                }
            }
        });

        return mw;
    }

    public LoginWindow createLoginWindow() {
        LoginWindow lw = new LoginWindow();
        lw.setListener(new LoginListener() {
            @Override
            public void loginEventEmitted(LoginEvent e) {
                String username = e.getUserName();
                String password = e.getPassword();

                Account currentAccount = rb.logIn(username, password);

                if (currentAccount != null) {
                    rb.setCurrentAccount(currentAccount);
                    lw.dispose();
                }
            }
        });

        centerFrame(lw);
        lw.setVisible(true);
        return lw;
    }

    public void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getSize().width) / 2;
        int y = (screenSize.height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
    }
}
