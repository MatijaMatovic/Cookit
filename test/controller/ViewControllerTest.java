/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import model.Ingredient;
import model.KitchenAppliance;
import model.Recipe;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jovana
 */
public class ViewControllerTest {
    public ViewController vc;
    
    public ViewControllerTest() {
        vc = vc = new ViewController();
        vc.rb = new RecipeBook();
        vc.rb.loadAll();
    }

    /**
     * Test of initAllRecipePanels method, of class ViewController.
     */
    @Test
    public void testInitAllRecipePanels() {
    }

    /**
     * Test of createRecipePanel method, of class ViewController.
     */
    @Test
    public void testCreateRecipePanel() {
    }

    /**
     * Test of createMainWindow method, of class ViewController.
     */
    @Test
    public void testCreateMainWindow() {
    }

    /**
     * Test of createLoginWindow method, of class ViewController.
     */
    @Test
    public void testCreateLoginWindow() {
    }

    /**
     * Test of createReviewPanel method, of class ViewController.
     */
    @Test
    public void testCreateReviewPanel() {
    }

    /**
     * Test of createRecipeFrame method, of class ViewController.
     */
    @Test
    public void testCreateRecipeFrame() {
    }

    /**
     * Test of createRecipeCreator method, of class ViewController.
     */
    @Test
    public void testCreateRecipeCreator() {
    }

    /**
     * Test of createIngredientPickerDialog method, of class ViewController.
     */
    @Test
    public void testCreateIngredientPickerDialog() {
    }

    /**
     * Test of getRecipesByIngredients method, of class ViewController.
     */
    @Test
    public void testGetRecipesByIngredients() {
        Set<Ingredient> ingredients = new HashSet<>();
        Set<KitchenAppliance> kAppliances = new HashSet<>();
        
        ingredients.add(new Ingredient("jaja"));ingredients.add(new Ingredient("mlijeko"));
        ingredients.add(new Ingredient("brasno"));ingredients.add(new Ingredient("ulje"));
        Set<Recipe> recipes  = vc.getRecipesByIngredients(ingredients, kAppliances);
        Iterator value = recipes.iterator(); 
        assertEquals(value.next(), vc.rb.recipes.get(1));
        
        ingredients.add(new Ingredient("urme"));
        recipes  = vc.getRecipesByIngredients(ingredients, kAppliances);
        value = recipes.iterator(); 
        assertEquals(value.next(), vc.rb.recipes.get(1));
        
        ingredients.clear();
        ingredients.add(new Ingredient("jaja"));ingredients.add(new Ingredient("mlijeko"));
        ingredients.add(new Ingredient("urme"));
        recipes  = vc.getRecipesByIngredients(ingredients, kAppliances);
        assertEquals(recipes.size(), 0);
        
        ingredients.clear();
        ingredients.add(new Ingredient("banane"));ingredients.add(new Ingredient("neskvik"));
        ingredients.add(new Ingredient("urme"));
        kAppliances.add(new KitchenAppliance("blender"));
        recipes  = vc.getRecipesByIngredients(ingredients, kAppliances);
        assertEquals(recipes.size(), 0);

    }

    /**
     * Test of createNewAccountFrame method, of class ViewController.
     */
    @Test
    public void testCreateNewAccountFrame() {
    }

    /**
     * Test of adminCreateNewAccountFrame method, of class ViewController.
     */
    @Test
    public void testAdminCreateNewAccountFrame() {
    }

    /**
     * Test of generatePassword method, of class ViewController.
     */
    @Test
    public void testGeneratePassword() {
    }

    /**
     * Test of createIngredientFrameCreator method, of class ViewController.
     */
    @Test
    public void testCreateIngredientFrameCreator() {
    }

    /**
     * Test of addNewIngredientV method, of class ViewController.
     */
    @Test
    public void testAddNewIngredientV() {
    }
    
}
