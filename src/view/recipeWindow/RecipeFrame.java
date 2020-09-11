/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.recipeWindow;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author matija i isidora
 */
public class RecipeFrame extends javax.swing.JFrame {
    
    private LevelBar rating;
    private PostReviewListener listener;

    /**
     * Creates new form RecipeFrame
     */
    public RecipeFrame() {
        initComponents();
        
        // Set the layout to enable adding user reviews
        BoxLayout layout = new BoxLayout(commentPanel, BoxLayout.Y_AXIS);
        commentPanel.setLayout(layout);
        initRatingStars();
    }
    
    private void initRatingStars(){
        String separator = System.getProperty("file.separator");
        ImageIcon defaultIcon = new ImageIcon("." + separator + "src" + separator + "view" + separator + "recipeWindow" + separator + "star.png");
        ImageProducer ip = defaultIcon.getImage().getSource();
        ImageIcon star = makeStarImageIcon(ip, 1f, .5f, 0f);
        List<ImageIcon> list = Arrays.asList(star, star, star, star, star);
        ratingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rating = new LevelBar(defaultIcon, list, 2);
        ratingPanel.add(rating);
    }
    
    private static ImageIcon makeStarImageIcon(ImageProducer ip, float rf, float gf, float bf) {
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(ip, new SelectedImageFilter(rf, gf, bf))));
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
        ingredientsScrollPane = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList<>();
        instructionsScroll = new javax.swing.JScrollPane();
        instructionsPane = new javax.swing.JTextPane();
        ratingLabel = new javax.swing.JLabel();
        reviewsPanel = new javax.swing.JPanel();
        gradePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewText = new javax.swing.JTextArea();
        postReviwButton = new javax.swing.JButton();
        ratingPanel = new javax.swing.JPanel();
        reviewsScroller = new javax.swing.JScrollPane();
        commentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        nameLabel.setText("jLabel1");

        ingredientsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojci"));
        ingredientsScrollPane.setViewportView(ingredientsList);

        instructionsScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Postupak"));

        instructionsPane.setEditable(false);
        instructionsPane.setContentType("text/html"); // NOI18N
        instructionsScroll.setViewportView(instructionsPane);

        ratingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratingLabel.setText("1-5");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        reviewText.setColumns(20);
        reviewText.setLineWrap(true);
        reviewText.setRows(5);
        reviewText.setToolTipText("Napisite svoju recnziju");
        reviewText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(reviewText);

        postReviwButton.setText("Objavi");
        postReviwButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postReviwButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ratingPanelLayout = new javax.swing.GroupLayout(ratingPanel);
        ratingPanel.setLayout(ratingPanelLayout);
        ratingPanelLayout.setHorizontalGroup(
            ratingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        ratingPanelLayout.setVerticalGroup(
            ratingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout gradePanelLayout = new javax.swing.GroupLayout(gradePanel);
        gradePanel.setLayout(gradePanelLayout);
        gradePanelLayout.setHorizontalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(gradePanelLayout.createSequentialGroup()
                        .addComponent(ratingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postReviwButton)))
                .addContainerGap())
        );
        gradePanelLayout.setVerticalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(postReviwButton)
                    .addComponent(ratingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        commentPanel.setLayout(new javax.swing.BoxLayout(commentPanel, javax.swing.BoxLayout.Y_AXIS));
        reviewsScroller.setViewportView(commentPanel);

        javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
        reviewsPanel.setLayout(reviewsPanelLayout);
        reviewsPanelLayout.setHorizontalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addGroup(reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reviewsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gradePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(reviewsScroller))
                .addContainerGap())
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewsScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addComponent(ingredientsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(ingredientsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postReviwButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postReviwButtonActionPerformed
        // TODO add your handling code here:
        PostReviewEvent ev = new PostReviewEvent(reviewText.getText(), rating.getLevel() + 1, this);
        listener.postReviewEventEmitted(ev);
    }//GEN-LAST:event_postReviwButtonActionPerformed

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
    
    public void disableRating(){
        gradePanel.setVisible(false);
    }

    public void setListener(PostReviewListener listener) {
        this.listener = listener;
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

    public void setIngredientsListModel(DefaultListModel<String> ingredientsListModel) {
        this.ingredientsList.setModel(ingredientsListModel);
    }

    public JPanel getCommentPanel() {
        return commentPanel;
    }

    public JPanel getGradePanel() {
        return gradePanel;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel commentPanel;
    private javax.swing.JPanel gradePanel;
    private javax.swing.JList<String> ingredientsList;
    private javax.swing.JScrollPane ingredientsScrollPane;
    private javax.swing.JTextPane instructionsPane;
    private javax.swing.JScrollPane instructionsScroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton postReviwButton;
    private javax.swing.ButtonGroup ratingGroup;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JPanel ratingPanel;
    private javax.swing.JTextArea reviewText;
    private javax.swing.JPanel reviewsPanel;
    private javax.swing.JScrollPane reviewsScroller;
    // End of variables declaration//GEN-END:variables
}
