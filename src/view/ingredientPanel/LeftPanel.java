/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ingredientPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Jovana
 */
public class LeftPanel extends javax.swing.JPanel {
     private int i=1;
    private GridBagConstraints cbg;
    private LPanel lPanel;

    /**
     * Creates new form LeftPanel
     */
    public LeftPanel() {
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        cbg = new GridBagConstraints();
   
    }
    
    public void header(){
        cbg.anchor = GridBagConstraints.NORTHWEST;
        cbg.gridx = 0;
        cbg.gridy = 0;
        cbg.fill = GridBagConstraints.HORIZONTAL;
        lPanel = new LPanel();
        this.add(lPanel, cbg);
        
        cbg = new GridBagConstraints();
        cbg.anchor = GridBagConstraints.NORTHWEST;
    
    }
    
    public void initCategory(JPanel jp){
        cbg.gridy = i;
        this.add(jp, cbg);
        i++;
        lPanel.categories.add(jp);
    }
    
    public void initIngridient(JPanel jp){
        cbg.gridy = i;
        this.add(jp, cbg);
        i++;
        lPanel.ingredients.add(jp);
    }
    
    public void initPanelAppliance(JPanel jp, JPanel hJp){
        cbg.weighty=0;
        cbg.gridy = 1;
        hJp.setVisible(false);
        this.add(hJp, cbg);
        lPanel.hAppliances = hJp;
        
        cbg.gridy = 2;
        jp.setVisible(false);
        this.add(jp, cbg);
        lPanel.appliances = jp;
        
        cbg.gridy = 3;
    }

    public void alignment(){
        cbg.weighty=1;
        JPanel jp = new JPanel();
        //lPanel.categories.add(jp);
        jp.setBackground(Color.white);
        this.add(jp,cbg);
    }
    
    public LPanel getLPanel(){
        return lPanel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
