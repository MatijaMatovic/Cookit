/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.recipeWindow;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;

/**
 *
 * @author matija
 */
public class RecipeFrame extends javax.swing.JFrame {

    /**
     * Creates new form RecipeFrame
     */
    public RecipeFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ratingGroup = new javax.swing.ButtonGroup();
        nameLabel = new javax.swing.JLabel();
        ingredientsScollPane = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList<>();
        instructionsScroll = new javax.swing.JScrollPane();
        instructionsPane = new javax.swing.JTextPane();
        ratingLabel = new javax.swing.JLabel();
        reviewsPanel = new javax.swing.JPanel();
        gradePanel = new javax.swing.JPanel();
        grade1 = new javax.swing.JRadioButton();
        grade2 = new javax.swing.JRadioButton();
        grade3 = new javax.swing.JRadioButton();
        grade4 = new javax.swing.JRadioButton();
        grade5 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewText = new javax.swing.JTextArea();
        postReviwButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        nameLabel.setText("jLabel1");

        ingredientsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojci"));
        ingredientsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ingredientsScollPane.setViewportView(ingredientsList);

        instructionsScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Postupak"));

        instructionsPane.setEditable(false);
        instructionsPane.setContentType("text/html"); // NOI18N
        instructionsScroll.setViewportView(instructionsPane);

        ratingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratingLabel.setText("1-5");

        ratingGroup.add(grade1);
        grade1.setText("1");

        ratingGroup.add(grade2);
        grade2.setText("2");

        ratingGroup.add(grade3);
        grade3.setText("3");

        ratingGroup.add(grade4);
        grade4.setText("4");

        ratingGroup.add(grade5);
        grade5.setText("5");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        reviewText.setColumns(20);
        reviewText.setLineWrap(true);
        reviewText.setRows(5);
        reviewText.setToolTipText("Napisite svoju recnziju");
        reviewText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(reviewText);

        postReviwButton.setText("Objavi");

        javax.swing.GroupLayout gradePanelLayout = new javax.swing.GroupLayout(gradePanel);
        gradePanel.setLayout(gradePanelLayout);
        gradePanelLayout.setHorizontalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(gradePanelLayout.createSequentialGroup()
                        .addComponent(grade1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postReviwButton)))
                .addContainerGap())
        );
        gradePanelLayout.setVerticalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postReviwButton)
                    .addComponent(grade5)
                    .addComponent(grade4)
                    .addComponent(grade3)
                    .addComponent(grade2)
                    .addComponent(grade1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
        reviewsPanel.setLayout(reviewsPanelLayout);
        reviewsPanelLayout.setHorizontalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ingredientsScollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(instructionsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reviewsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(instructionsScroll)
                    .addComponent(ingredientsScollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecipeFrame().setVisible(true);
            }
        });
    }

    public JList<String> getIngredientsList() {
        return ingredientsList;
    }

    public JTextPane getInstructionsPane() {
        return instructionsPane;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getRatingLabel() {
        return ratingLabel;
    }

    public void setIngredientsList(JList<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton grade1;
    private javax.swing.JRadioButton grade2;
    private javax.swing.JRadioButton grade3;
    private javax.swing.JRadioButton grade4;
    private javax.swing.JRadioButton grade5;
    private javax.swing.JPanel gradePanel;
    private javax.swing.JList<String> ingredientsList;
    private javax.swing.JScrollPane ingredientsScollPane;
    private javax.swing.JTextPane instructionsPane;
    private javax.swing.JScrollPane instructionsScroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton postReviwButton;
    private javax.swing.ButtonGroup ratingGroup;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JTextArea reviewText;
    private javax.swing.JPanel reviewsPanel;
    // End of variables declaration//GEN-END:variables
}
