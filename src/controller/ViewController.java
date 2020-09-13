/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Account;
import model.AccountOwner;
import model.IngredientAmount;
import model.Ingredient;
import model.IngredientCategory;
import model.KitchenAppliance;
import model.Recipe;
import model.RegisteredUser;
import model.Review;
import model.UserType;
import view.CreateRecipeWindow.AutoCompletion;
import view.CreateRecipeWindow.CreateRecipeEvent;
import view.CreateRecipeWindow.CreateRecipeFrame;
import view.CreateRecipeWindow.CreateRecipeListener;
import view.CreateRecipeWindow.DeleteIngredientEvent;
import view.CreateRecipeWindow.DeleteIngredientListener;
import view.CreateRecipeWindow.IngredientPickerDialog;
import view.CreateRecipeWindow.IngredientPickerEvent;
import view.CreateRecipeWindow.IngredientPickerListener;
import view.CreateRecipeWindow.OkIngredientEvent;
import view.CreateRecipeWindow.OkIngredientListener;
import view.MainWindow;
import view.createIngredient.CreateIngredientEvent;
import view.createIngredient.CreateIngredientFrame;
import view.createIngredient.CreateIngredientListener;
import view.createUser.CreateAccountEvent;
import view.createUser.CreateAccountFrame;
import view.createUser.CreateAccountListener;
import view.createUser.GenerateUsernameEvent;
import view.createUser.GenerateUsernameListener;
import view.ingredientPanel.CategoryPanel;
import view.ingredientPanel.IngredientPanel;
import view.ingredientPanel.LeftPanel;
import view.ingredientPanel.SearchEvent;
import view.ingredientPanel.SearchListener;
import view.loginWindow.LoginEvent;
import view.loginWindow.LoginListener;
import view.loginWindow.LoginWindow;
import view.recipePanel.RecipePanel;
import view.recipePanel.RecipePanelEvent;
import view.recipePanel.RecipePanelListener;
import view.recipeWindow.PostReviewEvent;
import view.recipeWindow.PostReviewListener;
import view.recipeWindow.RecipeFrame;
import view.recipeWindow.ReviewPanel;

/**
 *
 * @author Jovana
 */
public class ViewController {

    public static RecipeBook rb;
    public static MainWindow mw;

    public static void main(String[] args) {

        rb = new RecipeBook();
        rb.loadAll();

        ViewController k = new ViewController();
        mw = k.createMainWindow();

        LeftPanel lp = k.createLeftPanel(rb.ingredientCategories, rb.appliances);
        mw.getJScrollPane1().setViewportView(lp);
        k.initAllRecipePanels(new HashSet<>(rb.recipes.values()));
        mw.setVisible(true);
    }

    public MainWindow initAllRecipePanels(Set<Recipe> recipes) {
        mw.emptyRecipePanelsPanel(); // uklanja sve recepte prethodno prikazane
        mw.validate(); //...
        Iterator<Recipe> it = recipes.iterator();
        while (it.hasNext()) {
            Recipe r = it.next();
            createRecipePanel(r);
            mw.addRecipePanel(createRecipePanel(r));
        }
        mw.validate();
        mw.repaint();
        return mw;
    }

    public RecipePanel createRecipePanel(Recipe r) {
        RecipePanel rp = new RecipePanel();
        rp.setRecipeId(r.getId());
        rp.getDateLabel().setText(r.getCreationDateParsed()
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
        rp.getAuthorLabel().setText(r.getAuthorUsername());
        rp.setListener(new RecipePanelListener() {
            @Override
            public void recipePanelEventEmitted(RecipePanelEvent e) {
                RecipeFrame rf = createRecipeFrame(r);
                rf.setVisible(true);
            }
        });
        return rp;
    }

    public MainWindow createMainWindow() {
        MainWindow mw = new MainWindow();

        mw.showAccountLbl(false);

        mw.setLoginLblListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb.getCurrentAccount() == null) {
                    LoginWindow lw = createLoginWindow();

                    lw.addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentHidden(ComponentEvent e) {
                            if (rb.getCurrentAccount() != null) {
                                mw.showAccountLbl(true);
                                mw.changeLoginLbl(true);
                                lw.dispose();
                            }
                        }

                    });
                } else {
                    rb.setCurrentAccount(null);
                    mw.changeLoginLbl(false);
                    mw.showAccountLbl(false);
                }
            }
        });

        mw.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                rb.dumpAll();
                mw.dispose();
            }

        });

        mw.setFavLblListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mw.setMyPrListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserType currentUserType = rb.getCurrentAccountOwner().getUserType();

                switch (currentUserType) {
                    case user:
                        JOptionPane.showMessageDialog(mw, "Funkcija u izradi");
                        break;
                    case moderator:
                        CreateIngredientFrame cif = createIngredientFrameCreator();
                        break;
                    case administrator:
                        CreateAccountFrame caf = adminCreateNewAccountFrame();
                        break;
                
                }
                
            }
        });
        mw.setNewRecepieListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb.currentAccount == null) {
                    JOptionPane.showMessageDialog(mw, "Niste ulogovani");
                    return;
                }
                CreateRecipeFrame crf = createRecipeCreator();
                crf.setVisible(true);
                centerFrame(crf);
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
                    
                    UserType currentUserType = rb.getCurrentAccountOwner().getUserType();

                    switch (currentUserType) {
                        case user:
                            break;
                        case administrator:
                            mw.changeSpecialLbl("Dodavanje korisnika");
                            break;
                        case moderator:
                            mw.changeSpecialLbl("Dodavanje sastojaka");
                            break;
                        default:
                            break;
                    }
                    
                    lw.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(lw, "Neispravno uneti podaci. Ne postoji korisnik sa tim korisničkim imenom i tom lozinkom.", "Neispravni podaci", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        lw.setCreateAccountListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccountFrame caf = createNewAccountFrame();
                caf.setVisible(true);
                centerFrame(caf);
                lw.dispose();
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
        rp.getUsernameLabel().setText(r.reviewer);
        rp.initRating(r.rating);
        return rp;
    }

    public RecipeFrame createRecipeFrame(Recipe r) {
        RecipeFrame rf = new RecipeFrame();
        rf.getNameLabel().setText(r.getName());
        rf.getRatingLabel().setText(Double.toString(r.calculateGradeAvg()));
        rf.getInstructionsPane().setText(r.getText());

        DefaultListModel<String> ingredientsListModel = new DefaultListModel();
        Iterator<IngredientAmount> iait = r.getIngredientAmounts().iterator();
        while (iait.hasNext()) {
            IngredientAmount ia = iait.next();
            ingredientsListModel.addElement(ia.toString());
        }
        rf.setIngredientsListModel(ingredientsListModel);
      
        /* Add users' reviews to the scroll pane */
        Iterator<Review> it = r.getReviews().iterator();
        while (it.hasNext()) {
            Review review = it.next();
            
            if (rb.getCurrentAccount() != null){
                if (review.reviewer.equals(rb.getCurrentAccount().getUsername()))
                    rf.getGradePanel().setVisible(false);
            }
            
            ReviewPanel rp = createReviewPanel(review);
            rf.getCommentPanel().add(rp);
        }
        
        if (rb.currentAccount == null) {
            rf.getGradePanel().setVisible(false);
        }

        rf.setListener(new PostReviewListener() {
            @Override
            public void postReviewEventEmitted(PostReviewEvent e) {
                Integer rating = e.getRating();
                String comment = e.getComment();
                
                if (rating == 0){
                    return;
                }

                rf.disableRating();

                Review review = new Review();
                review.rating = rating;
                review.comment = comment;
                review.reviewer = rb.currentAccount.getUsername();

                Set<Review> reviews = r.getReviews();
                reviews.add(review);
                RegisteredUser us = (RegisteredUser) rb.getCurrentAccountOwner();
                us.getReviews().add(review);
                r.setReviews(reviews);
                rf.getRatingLabel().setText(Double.toString(r.calculateGradeAvg()));

                ReviewPanel rp = createReviewPanel(review);
                rf.getCommentPanel().add(rp);
                rf.getCommentPanel().add(Box.createVerticalStrut(5));
                
                rf.getRatingLabel().setText(Double.toString(r.calculateGradeAvg()));
                rf.validate();
                rf.repaint();
            }
        });

        return rf;
    }

    public CreateRecipeFrame createRecipeCreator() {
        CreateRecipeFrame crf = new CreateRecipeFrame();
        List<IngredientAmount> ingredientAmounts = new ArrayList<>();
        crf.setListener(new CreateRecipeListener() {
            @Override
            public void createRecipeEventEmitted(CreateRecipeEvent r) {
                int id = rb.recipes.isEmpty() ? 1 : Collections.max(rb.recipes.keySet())+1;
                String name = r.getName();
                String text = r.getText();

                Recipe recipe = new Recipe(id, name, text,
                        rb.getCurrentAccount().getUsername(), new HashSet<>(ingredientAmounts));
                rb.recipes.put(id, recipe);

                ((RegisteredUser) rb.getCurrentAccountOwner()).getRecipes().add(id);
                JOptionPane.showMessageDialog(crf, "Uspesno dodat recept!");

                initAllRecipePanels(new HashSet<>(rb.recipes.values()));
                crf.dispose();
            }
        });
        
        crf.setIngredientListener(new IngredientPickerListener() {
            @Override
            public void ingredientPickerEventEmitted(IngredientPickerEvent e) {
                Set<String> ingrs = new HashSet<>(); 
                Iterator<IngredientCategory> itCat = rb.ingredientCategories.iterator();
                while (itCat.hasNext()) {
                    Iterator<Ingredient> it = itCat.next().getIngredientsSet().iterator();
                    while (it.hasNext()) {
                        Ingredient in = it.next();
                        ingrs.add(in.getName());
                    }
                }
                IngredientPickerDialog i = createIngredientPickerDialog(ingrs, crf, e.isEdit(), ingredientAmounts);
                i.setVisible(true);
            }
        });
        
        crf.setDeleteListener(new DeleteIngredientListener() {
            @Override
            public void deleteIngredientEventEmitted(DeleteIngredientEvent e) {
               ingredientAmounts.remove(crf.getIngredientsList().getSelectedIndex());
               crf.deleteIngredient();
            }
        });
        
        return crf;
    }
    
    public IngredientPickerDialog createIngredientPickerDialog(Set<String> ingrs, CreateRecipeFrame crf, boolean edit, List<IngredientAmount> ingredients){
        IngredientPickerDialog i = new IngredientPickerDialog(mw, true, edit);
        DefaultComboBoxModel<String> ingrModel = new DefaultComboBoxModel();
        ingrModel.addAll(ingrs);
        i.setIngredientsComboModel(ingrModel);
        i.setLocationRelativeTo(crf);
        if (!edit)
            AutoCompletion.enable(i.getIngredientsComboBox());
        
        i.setOkListener(new OkIngredientListener() {
            @Override
            public void okIngredientEventEmitted(OkIngredientEvent e) {
                if (!edit){
                    IngredientAmount ingr = new IngredientAmount(e.getIngredient(), e.getAmount(), e.getUnit());
                    ingredients.add(ingr);
                    crf.addIngredient(ingr.toString());
                } else {
                    IngredientAmount ingrEdited = ingredients.get(crf.getIngredientsList().getSelectedIndex());
                    ingrEdited.setAmount(e.getAmount());
                    ingrEdited.setUnit(e.getUnit());
                    crf.editIngredient(ingrEdited.toString());
                }
                i.dispose();
            }
        });
        return i;
    }

    public Set<Recipe> getRecipesByIngredients(Set<Ingredient> ingredients, Set<KitchenAppliance> kAppliances) {
        Map<Integer, Recipe> R = rb.recipes;
        if(ingredients.isEmpty()){
            return new HashSet<>(rb.recipes.values());
        }
        Set<Recipe> foundRecipes = new HashSet<>();

        for (Iterator<Map.Entry<Integer, Recipe>> it = R.entrySet().iterator(); it.hasNext();) {
            Recipe r = it.next().getValue();
            if (ingredients.containsAll(r.getIngredientAmounts()) && kAppliances.containsAll(r.getRequiredAppliances())) {
                foundRecipes.add(r);
            }
        }
        return foundRecipes;
    }

    private LeftPanel createLeftPanel(Set<IngredientCategory> ingredientCategories, Set<KitchenAppliance> kAppliance) {
        
        Set<KitchenAppliance> appliances = new HashSet<>();

        mw.getLp().setBackground(Color.white);
        mw.getLp().header();
        Iterator<IngredientCategory> itC = ingredientCategories.iterator();

        while (itC.hasNext()) {
            IngredientCategory ci = itC.next();
            CategoryPanel cp = new CategoryPanel(ci.getName());
            mw.getLp().initCategory(cp);
            Iterator<Ingredient> itI = ci.getIngredientsSet().iterator();
            IngredientPanel ip = new IngredientPanel();

            while (itI.hasNext()) {
                ip.init(itI.next().getName());
            }
            mw.getLp().initIngridient(ip);
        }
        mw.getLp().alignment();

        Iterator<KitchenAppliance> itI = kAppliance.iterator();
        IngredientPanel ip = new IngredientPanel();

        while (itI.hasNext()) {
            ip.init(itI.next().getName());
        }

        CategoryPanel cp = new CategoryPanel("Kuhinjski aparati");
        mw.getLp().initPanelAppliance(ip, cp);

        mw.getLp().getLPanel().setListener(new SearchListener() {
            @Override
            public void searchEventEmitted(SearchEvent e) {
                Set<Ingredient> ingredients = new HashSet<>();
                for (String ingr : e.getIngredients()) {
                    ingredients.add(new Ingredient(ingr));
                }

                for (String aplc : e.getAppliances()) {
                    appliances.add(new KitchenAppliance(aplc));
                }
                Set<Recipe> foundRecipes = getRecipesByIngredients(ingredients, appliances);
                
                initAllRecipePanels(foundRecipes);
            }
        });

        return mw.getLp();
    }

    public CreateAccountFrame createNewAccountFrame() {
        CreateAccountFrame cap = new CreateAccountFrame();
        cap.enableAdminChkBox(false);

        cap.setGeneratePasswordListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = generatePassword();
                cap.setPasswordTextField(password);
            }
        });

        cap.setGenerateUserNameListener(new GenerateUsernameListener() {
            @Override
            public void generateUsernameEventOccured(GenerateUsernameEvent e) {
                String email = e.getEmail();
                String newUsername;

                String name = e.getName();
                String surname = e.getSurname();
                if (!(email.equals(""))) {
                    newUsername = email;

                } else {
                    if (name.equals("") && surname.equals("")) {
                        return;
                    } else {
                        newUsername = name.toLowerCase() + "." + surname.toLowerCase();
                    }
                }

                int counter = 0;
                while (true) {
                    if (rb.checkAccount(newUsername)) {
                        counter++;
                        newUsername += counter;
                    } else {
                        break;
                    }
                }

                cap.setUsernameTextField(newUsername);
            }
        });

        cap.setCreateAccountListener(new CreateAccountListener() {
            @Override
            public void createNewAccount(CreateAccountEvent e) {

                boolean allDataEntered = true;

                String name = e.getName();
                String surname = e.getSurname();
                String email = e.getEmail();
                String username = e.getUsername();
                String password = e.getPassword();

                LocalDate birthDate = e.getBirthDate();

                if (name.isBlank()) {
                    cap.colorTextField(email);
                    allDataEntered = false;
                }
                if (surname.isBlank()) {
                    cap.colorTextField("surname");
                    allDataEntered = false;
                }
                if (username.isBlank()) {
                    cap.colorTextField("username");
                    allDataEntered = false;
                }
                if (password.isBlank()) {
                    cap.colorTextField("password");
                    allDataEntered = false;
                }

                if (!(cap.checkEmailFields())) {
                    allDataEntered = false;
                }

                if (allDataEntered) {
                    if (rb.checkAccount(username)) {
                        cap.colorTextField("username");
                        return;
                    }

                    Account newAcc = new Account();
                    newAcc.setEmail(email);
                    newAcc.setUsername(username);
                    newAcc.setPassword(password);

                    RegisteredUser newAccOwner = new RegisteredUser();
                    newAccOwner.setUserType(UserType.user);
                    newAccOwner.setBirthDate(birthDate);
                    newAccOwner.setFollowing(new HashSet<>());
                    newAccOwner.setName(name);
                    newAccOwner.setSurname(surname);
                    newAccOwner.setReviews(new HashSet<>());
                    newAccOwner.setPrivileged(false);
                    newAccOwner.setAccount(newAcc);

                    rb.accountOwners.put(username, newAccOwner);
                    mw.showAccountLbl(true);
                    mw.changeLoginLbl(true);

                    rb.setCurrentAccount(newAcc);

                    cap.dispose();
                }

            }
        });

        cap.setVisible(true);
        centerFrame(cap);
        return cap;
    }

     public CreateAccountFrame adminCreateNewAccountFrame() {
        CreateAccountFrame caf = createNewAccountFrame();
        caf.enableAdminChkBox(true);
        caf.setCreateAccountListener(new CreateAccountListener() {
            @Override
            public void createNewAccount(CreateAccountEvent e) {

                boolean allDataEntered = true;

                String name = e.getName();
                String surname = e.getSurname();
                String email = e.getEmail();
                String username = e.getUsername();
                String password = e.getPassword();

                LocalDate birthDate = e.getBirthDate();

                if (name.isBlank()) {
                    caf.colorTextField(email);
                    allDataEntered = false;
                }
                if (surname.isBlank()) {
                    caf.colorTextField("surname");
                    allDataEntered = false;
                }
                if (username.isBlank()) {
                    caf.colorTextField("username");
                    allDataEntered = false;
                }
                if (password.isBlank()) {
                    caf.colorTextField("password");
                    allDataEntered = false;
                }

                if (!(caf.checkEmailFields())) {
                    allDataEntered = false;
                }

                if (allDataEntered) {
                    if (rb.checkAccount(username)) {
                        caf.colorTextField("username");
                        return;
                    }

                    Account newAcc = new Account();
                    newAcc.setEmail(email);
                    newAcc.setUsername(username);
                    newAcc.setPassword(password);

                    RegisteredUser newAccOwner = new RegisteredUser();
                    if (caf.isModeratorSelected()) {
                        newAccOwner.setUserType(UserType.moderator);
                    } else {
                        newAccOwner.setUserType(UserType.user);
                    }

                    newAccOwner.setBirthDate(birthDate);
                    newAccOwner.setFollowing(new TreeSet<>());
                    newAccOwner.setName(name);
                    newAccOwner.setSurname(surname);
                    newAccOwner.setReviews(new TreeSet<>());
                    newAccOwner.setPrivileged(false);
                    newAccOwner.setAccount(newAcc);

                    rb.accountOwners.put(username, newAccOwner);
                    mw.showAccountLbl(true);
                    mw.changeLoginLbl(true);

                    rb.setCurrentAccount(newAcc);

                    caf.dispose();
                }

            }
        });
        return caf;
    }


    public static String generatePassword() {
        String password = "";

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%&*+=[].?><";

        Random randomizer = new Random();
        int choice;
        int charLocation;
        for (int i = 0; i < 8; i++) {
            choice = randomizer.ints(1, 1, 5).min().getAsInt();
            switch (choice) {
                case 1:
                    charLocation = randomizer.ints(1, 0, lowercaseChars.length()).min().getAsInt();
                    password += lowercaseChars.charAt(charLocation);
                    break;
                case 2:
                    charLocation = randomizer.ints(1, 0, uppercaseChars.length()).min().getAsInt();
                    password += uppercaseChars.charAt(charLocation);
                    break;
                case 3:
                    charLocation = randomizer.ints(1, 0, digits.length()).min().getAsInt();
                    password += digits.charAt(charLocation);
                    break;
                default:
                    charLocation = randomizer.ints(1, 0, specialChars.length()).min().getAsInt();
                    password += specialChars.charAt(charLocation);
                    break;
            }
        }
        return password;
    }

    public CreateIngredientFrame createIngredientFrameCreator() {
        CreateIngredientFrame cif = new CreateIngredientFrame();

        cif.setComboBoxModel(new DefaultComboBoxModel(rb.ingredientCategories.toArray()));

        cif.setListener(new CreateIngredientListener() {
            @Override
            public void createIngredient(CreateIngredientEvent ev) {
                String ingredientString = ev.getIngredientString();
                Ingredient ingredient = new Ingredient(ingredientString);
                IngredientCategory ingredientCategory = ev.getIngredientCategory();

                if (ingredientCategory.getIngredientsSet().contains(ingredient)) {
                    JOptionPane.showMessageDialog(cif, "U odabranoj kategoriji već postoji sastojak sa istim nazivom", "Greška", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(cif, "Novi sastojak uspešno dodat", "Uspešno dodavanje", JOptionPane.PLAIN_MESSAGE);
                    ingredientCategory.addIngredient(ingredient);
                    addNewIngredientV();
                    cif.dispose();
                }
            }
        });

        cif.setVisible(true);
        centerFrame(cif);
        return cif;
    }
    
    public void addNewIngredientV() {
        mw.emptyLeftPanel();
        mw.validate();
        createLeftPanel(rb.ingredientCategories, rb.appliances);
        mw.validate();
        mw.repaint();
    }

}
