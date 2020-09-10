/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ingredientPanel;

/**
 *
 * @author Jovana
 */
public class CheckBox extends javax.swing.JCheckBox{
    
    private final String label;
    
    public CheckBox(String l) {
        super();
        this.label = l;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getLabel(){
        return label;
    }
    
    
}
