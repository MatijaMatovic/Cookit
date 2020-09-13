package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import model.Account;
import model.AccountOwner;
import model.IngredientCategory;
import model.KitchenAppliance;
import model.Recipe;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class RecipeBook {

    public Map<String, AccountOwner> accountOwners;
    public Map<Integer, Recipe> recipes;
    public Set<IngredientCategory> ingredientCategories;
    public Set<KitchenAppliance> appliances;

    public Account currentAccount;

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public enum FileType {
        ACCOUNTS,
        RECIPES,
        INGREDIENT_CATEGORIES,
        APPLIANCES
    }
    public static String separator = System.getProperty("file.separator");

    public RecipeBook() {
        this.accountOwners = new HashMap<>();
        this.recipes = new HashMap<>();
        this.ingredientCategories = new TreeSet<>();
        this.appliances = new TreeSet<>();
    }

    public Account logIn(String userName, String password) {
        AccountOwner aco = this.accountOwners.get(userName);
        if (aco == null){
            return null;
        }
        Account ac = aco.getAccount();
        if (ac == null){
            return null;
        }
        if (ac.getPassword().equals(password)) {
            return ac;
        } else {
            return null;
        }

    }

    /**
     * Gets the path to the file where objects of the given type are stored
     *
     * @param type Type of object that is to be stored
     * @return path to the file, if an unspecified type is provided, returns
     * null
     */
    public String getPath(FileType type) {
        String path = "." + separator + "Resources" + separator; // Data stored in ./Resources/Filetype.yaml
        switch (type) {
            case ACCOUNTS:
                path += "accounts.yaml";
                break;
            case RECIPES:
                path += "recipes.yaml";
                break;
            case INGREDIENT_CATEGORIES:
                path += "ingredientCats.yaml";
                break;
            case APPLIANCES:
                path += "appliances.yaml";
                break;
            default:
                path = null;
        }
        return path;
    }

    /**
     * Checks if the data storage for the specified type exists. If it doesn't
     * already, this function creates a new file
     *
     * @param type Type of object whose storage is needed
     * @throws Exception - if an unspecified type is provided
     */
    public void makeFile(FileType type) throws Exception {
        String path = getPath(type);

        if (path == null) {
            throw new Exception("No such data category");
        }

        File storage = new File(path);
        if (!storage.exists()) {
            try {
                storage.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This function saves accounts to their designated data storage files It
     * uses YAML to serialize the objects to the file
     */
    public void saveAccounts() {
        try {
            makeFile(FileType.ACCOUNTS);

            DumperOptions dop = new DumperOptions();
            dop.setPrettyFlow(true);

            // makeFile and PrintWriter constructor throw different Exceptions
            // so they need to be handled separately
            try (PrintWriter out = new PrintWriter(new FileWriter(getPath(FileType.ACCOUNTS), false))) {
                Yaml yaml = new Yaml(dop);
                yaml.dump(this.accountOwners, out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all the accounts from the file into accounts set
     */
    public void loadAccounts() {
        try {
            makeFile(FileType.ACCOUNTS);

            // makeFile and InputStream constructor throw different Exceptions
            // so they need to be handled separately
            try (InputStream in = new FileInputStream(new File(getPath(FileType.ACCOUNTS)))) {
                Yaml yaml = new Yaml();
                this.accountOwners = (Map<String, AccountOwner>) yaml.load(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkAccount(String username){
        return this.accountOwners.containsKey(username);
    }
    
    /**
     * This function saves all the recipes to their designated data storage
     */
    public void saveRecipes() {
        try {
            makeFile(FileType.RECIPES);
            
            DumperOptions dop = new DumperOptions();
            dop.setPrettyFlow(true);
            
            try (PrintWriter out = new PrintWriter(new FileWriter(getPath(FileType.RECIPES), false))) {
                Yaml yaml = new Yaml(dop);
                yaml.dump(this.recipes, out);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadRecipes() {
        try {
            makeFile(FileType.RECIPES);
            
            try (InputStream in = new FileInputStream(new File(getPath(FileType.RECIPES)))) {
                Yaml yaml = new Yaml();
                this.recipes = (Map<Integer, Recipe>) yaml.load(in);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveIngredients() {
        try {
            makeFile(FileType.INGREDIENT_CATEGORIES);
            
            DumperOptions dop = new DumperOptions();
            dop.setPrettyFlow(true);
            
            try (PrintWriter out = new PrintWriter(new FileWriter(getPath(FileType.INGREDIENT_CATEGORIES), false))) {
                Yaml yaml = new Yaml(dop);
                yaml.dump(this.ingredientCategories, out);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadIngredients() {
        try {
            makeFile(FileType.INGREDIENT_CATEGORIES);
            
            try (InputStream in = new FileInputStream(new File(getPath(FileType.INGREDIENT_CATEGORIES)))) {
                Yaml yaml = new Yaml();
                this.ingredientCategories = (Set<IngredientCategory>) yaml.load(in);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveAppliances() {
        try {
            makeFile(FileType.APPLIANCES);
            
            DumperOptions dop = new DumperOptions();
            dop.setPrettyFlow(true);
            
            try (PrintWriter out = new PrintWriter(new FileWriter(getPath(FileType.APPLIANCES), false))) {
                Yaml yaml = new Yaml(dop);
                yaml.dump(this.appliances, out);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadAppliances() {
        try {
            makeFile(FileType.APPLIANCES);
            
            try (InputStream in = new FileInputStream(new File(getPath(FileType.APPLIANCES)))) {
                Yaml yaml = new Yaml();
                this.appliances = (Set<KitchenAppliance>) yaml.load(in);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void dumpAll() {
        try {
            saveAccounts();
            saveAppliances();
            saveIngredients();
            saveRecipes();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadAll() {
        try {
            loadAccounts();
            loadAppliances();
            loadIngredients();
            loadRecipes();
            reinitialzeData();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public AccountOwner getCurrentAccountOwner() {
        return this.accountOwners.get(currentAccount.getUsername());
    }
    
    public void reinitialzeData() {
        if (this.accountOwners == null) this.accountOwners = new HashMap<>();
        if (this.recipes == null) this.recipes = new HashMap<>();
        if (this.ingredientCategories == null) this.ingredientCategories = new TreeSet<>();
        if (this.appliances == null) this.appliances = new TreeSet<>();
    }
}
