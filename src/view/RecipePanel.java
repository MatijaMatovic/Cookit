package view;

import java.time.format.DateTimeFormatter;
import model.Recipe;

/**
 * This class is used to present the preview of the recipe, in the main window
 * of the app. It is intended, that by clicking on the panel, the user is taken
 * to the main window of the recipe with full information about it
 * @author matija
 */
public class RecipePanel extends javax.swing.JPanel {
    
    private Recipe recipe;
    /**
     * Creates new form RecipePanel
     */
    public RecipePanel() {
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

        nameLabel = new javax.swing.JLabel();
        ingredientsLabel = new javax.swing.JLabel();
        instructionsLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        reviewsLabel = new javax.swing.JLabel();
        appliancesLabel = new javax.swing.JLabel();

        nameLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        nameLabel.setText("Naziv recepta ");

        ingredientsLabel.setText("Sastojci: sastojak1, sastojak2, sastojak3... ");
        ingredientsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        instructionsLabel.setText("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vulputate dapibus dictum. In malesuada orci ipsum, eget sodales felis consectetur eu. In auctor eros est, ut hendrerit velit efficitur ut. Sed molestie diam orci, eu interdum ex tincidunt nec. Nulla nisl lacus sit.</html>");
        instructionsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        dateLabel.setText("Datum izrade recepta");

        reviewsLabel.setText("Ocena: 1-5");

        appliancesLabel.setText("Kuhinjski aparati: aparat1, aparat2, aparat3...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reviewsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appliancesLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                            .addComponent(instructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(ingredientsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingredientsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appliancesLabel)
                .addGap(13, 13, 13)
                .addComponent(instructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewsLabel)
                    .addComponent(dateLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        initRecipeGUI();
    }
    
    private void initRecipeGUI() {
        this.dateLabel.setText(recipe.creationDate
                .format(DateTimeFormatter
                .ofPattern("dd.MM.yyyy. HH:mm")));
        this.nameLabel.setText(recipe.text);
        /* If instructions are longer than 280 chars, it chopps it off */
        /* <html> tags enable the formatting of text in the label      */
        this.instructionsLabel.setText("<html>" + recipe.text.substring(0, 
                Math.min(recipe.text.length(), 280)) + "...</html>");
        this.nameLabel.setText(Double.toString(recipe.calculateGradeAvg()));
        this.ingredientsLabel.setText(recipe.getIngredientsString());
        this.appliancesLabel.setText(recipe.getAppliancesString());
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appliancesLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel reviewsLabel;
    // End of variables declaration//GEN-END:variables

}