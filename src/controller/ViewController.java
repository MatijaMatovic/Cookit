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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import model.Account;
import model.Recipe;
import model.Review;
import view.MainWindow;
import view.RecipePanel;
import view.loginWindow.LoginEvent;
import view.loginWindow.LoginListener;
import view.loginWindow.LoginWindow;
import view.recipeWindow.RecipeFrame;
import view.recipeWindow.ReviewPanel;

/**
 *
 * @author Jovana
 */
public class ViewController {

    public static RecipeBook rb;
    
    public static void main(String[] args) {
        rb = new RecipeBook();
        ViewController k = new ViewController();
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
        
        mw.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                //sacuvajUFajl();
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
    
    public ReviewPanel createReviewPanel(Review r) {
        ReviewPanel rp = new ReviewPanel();
        rp.getTextLabel().setText(r.comment);
        rp.getUsernameLabel().setText(r.reviewer.getAccount().getUsername());
        rp.initRating(r.rating);
        return rp;
    }
    
    public RecipeFrame createRecipeFrame(Recipe r) {
        RecipeFrame rf = new RecipeFrame();
        rf.getNameLabel().setText(r.getName());
        rf.getRatingLabel().setText(Double.toString(r.calculateGradeAvg()));
        rf.getInstructionsPane().setText(r.getText());
        
        DefaultListModel ingredientsListModel = new DefaultListModel();
        ingredientsListModel.addAll(r.getIngredientAmounts()
                                     .stream()
                                     .map(i -> i.toString())
                                     .collect(Collectors.toList()));
        rf.setIngredientsList(new JList<>(ingredientsListModel));
        
        /* Add users' reviews to the scroll pane */
        Iterator<Review> it = r.getReviews().iterator();
        while (it.hasNext()) {
            Review review = it.next();
            ReviewPanel rp = createReviewPanel(review);
            rf.getCommentPanel().add(rp);
            rf.getCommentPanel().add(Box.createVerticalStrut(5));
        }
        
        return rf;
    }
}
