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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.Account;
import model.IngredientAmount;
import model.Ingredient;
import model.IngredientCategory;
import model.Recipe;
import model.RegisteredUser;
import model.Review;
import view.CreateRecipeWindow.CreateRecipeEvent;
import view.CreateRecipeWindow.CreateRecipeFrame;
import view.CreateRecipeWindow.CreateRecipeListener;
import view.MainWindow;
import view.RecipePanel;
import view.ingredientPanel.CategoryPanel;
import view.ingredientPanel.IngredientPanel;
import view.ingredientPanel.LeftPanel;
import view.ingredientPanel.SearchEvent;
import view.ingredientPanel.SearchListener;
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
        IngredientCategory ic1 = new IngredientCategory("Mlijecni proizvodi");
        IngredientCategory ic2 = new IngredientCategory("Povrce");
        Set<IngredientCategory> ic = new HashSet<>();
        Set<Ingredient> i1 = new HashSet<>();
        Set<Ingredient> i2 = new HashSet<>();
        i1.add(new Ingredient("mlijeko")); i1.add(new Ingredient("Feta sir"));i1.add(new Ingredient("Mozzarella"));
        i1.add(new Ingredient("Gauda"));i1.add(new Ingredient("Feta sir"));i1.add(new Ingredient("Kackavalj"));
        i1.add(new Ingredient("jaja")); i1.add(new Ingredient("maslac")); i1.add(new Ingredient("slag"));
        i1.add(new Ingredient("mleko u prahu"));
        
        i2.add(new Ingredient("paprika")); i2.add(new Ingredient("mrkva"));i2.add(new Ingredient("repa"));
        i2.add(new Ingredient("rotkva"));i2.add(new Ingredient("kupus"));i2.add(new Ingredient("luk"));
        i2.add(new Ingredient("spanac")); i2.add(new Ingredient("blitva")); i2.add(new Ingredient("tikvice"));
        i2.add(new Ingredient("persun"));
        ic1.setIngredientsSet(i1);
        ic2.setIngredientsSet(i2);
        ic.add(ic1); ic.add(ic2);
        //---------------------------------------------------------------------------
                
        rb = new RecipeBook();
        ViewController k = new ViewController();
        MainWindow mw = k.createMainWindow();
        mw.getJScrollPane1().setViewportView(k.createLeftPanel(ic));
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
        
        mw.setFavLblListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: kreirati prozor za prikaz omiljenih recepata
                System.out.println("fav");
            }
        });
        mw.setMyPrListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: kreirati prozor za izmjenu licnih podataka
                System.out.println("my profile");
            }
        });
        mw.setNewRecepieListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:kreirati prozor za prikaz novih recepata
                System.out.println("new recepie");
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
        
    public CreateRecipeFrame createRecipeCreator() {
        CreateRecipeFrame crf = new CreateRecipeFrame();
        crf.setListener(new CreateRecipeListener() {
            @Override
            public void createRecipeEventEmitted(CreateRecipeEvent r) {
                long id = Collections.max(rb.recipes.keySet());
                String name = r.getName();
                String text = r.getText();
                Set<IngredientAmount> ingredients = new HashSet<>();
                Iterator<String> it = r.getIngredients().iterator();
                while (it.hasNext()) {
                    String ingredientData [] = it.next().split(" ");
                    IngredientAmount ing = new IngredientAmount(
                            ingredientData[0], 
                            Double.parseDouble(ingredientData[1]),
                            ingredientData[2]);
                    ingredients.add(ing);
                }
                Recipe recipe = new Recipe(id, name, text, 
                        (RegisteredUser) rb.getCurrentAccount().getAccountOwner(), ingredients);
                rb.recipes.put(id, recipe);
                JOptionPane.showMessageDialog(crf, "Uspesno dodat recept!");
            }
        });
        return crf;
    }
    
    private LeftPanel createLeftPanel(Set<IngredientCategory> ingredientCategories){
        Set<Ingredient> ingridients = new HashSet<>();
        LeftPanel lp = new LeftPanel();
        Iterator<IngredientCategory> itC = ingredientCategories.iterator();

        while(itC.hasNext())
        {
            IngredientCategory ci = itC.next();
            CategoryPanel cp = new CategoryPanel(ci.getName());
            lp.initCategory(cp);
            Iterator<Ingredient> itI = ci.getIngredientsSet().iterator();
            IngredientPanel ip = new IngredientPanel();
            
            while(itI.hasNext())
            {
                ip.init(itI.next().getName());
            }
            lp.initIngridient(ip);
        }
        lp.alignment();
        
        lp.getLPanel().setListener(new SearchListener() 
        {
             @Override
             public void searchEventEmitted(SearchEvent e) 
             {
                 for (String ingr : e.getIngredients())
                 {
                      ingridients.add(new Ingredient(ingr));
                }
                 
                //TODO: poziv funkcije za sortiranje, kojoj se posalje ingridients
             }
         });
        
        return lp;
    }
}
