import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Vector;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class GUI extends javax.swing.JFrame {
    public static BufferedImage original = null; /* original image loaded by user */
    public static BufferedImage filtered = null; /* filtered image */
    public GUI() {
        initComponents();
        Settings.LoadSettings();
        variance_slider.setValue(0);
        variance_textfield.setText("0%");
        photo_textfield.setText(Settings.GetFileImport());
        if(Settings.GetRed() != 0)
            filter_R.setText(Integer.toString(Settings.GetRed()));
        if(Settings.GetGreen() != 0)
            filter_G.setText(Integer.toString(Settings.GetGreen()));
        if(Settings.GetBlue() != 0)
            filter_B.setText(Integer.toString(Settings.GetBlue()));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        saveimage_group = new javax.swing.ButtonGroup();
        resize_dialogue = new javax.swing.JDialog();
        resize_message = new javax.swing.JLabel();
        resize_ok = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        importphoto_button = new javax.swing.JButton();
        photo_textfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        filter_R = new javax.swing.JTextField();
        filter_G = new javax.swing.JTextField();
        filter_B = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        variance_slider = new javax.swing.JSlider();
        variance_textfield = new javax.swing.JTextField();
        filterRGB_button = new javax.swing.JButton();
        analyze_button = new javax.swing.JButton();
        increment_variance = new javax.swing.JButton();
        decrement_variance = new javax.swing.JButton();
        saveimage_button = new javax.swing.JButton();
        savejpg = new javax.swing.JRadioButton();
        savepng = new javax.swing.JRadioButton();
        savegif = new javax.swing.JRadioButton();
        savebmp = new javax.swing.JRadioButton();
        savefile_textfield = new javax.swing.JTextField();

        resize_dialogue.setType(java.awt.Window.Type.POPUP);

        resize_ok.setText("Ok");
        resize_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resize_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resize_dialogueLayout = new javax.swing.GroupLayout(resize_dialogue.getContentPane());
        resize_dialogue.getContentPane().setLayout(resize_dialogueLayout);
        resize_dialogueLayout.setHorizontalGroup(
            resize_dialogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resize_dialogueLayout.createSequentialGroup()
                .addComponent(resize_message, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(resize_dialogueLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(resize_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        resize_dialogueLayout.setVerticalGroup(
            resize_dialogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resize_dialogueLayout.createSequentialGroup()
                .addComponent(resize_message, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resize_ok)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("Imported photo will be displayed here");
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        photo.setMaximumSize(new java.awt.Dimension(800, 600));
        photo.setMinimumSize(new java.awt.Dimension(600, 600));

        importphoto_button.setText("Import");
        importphoto_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importphoto_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Enter Name of Photo:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Set RGB Value to Filter:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("R:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("G:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("B:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Set Acceptable Variance:");

        variance_slider.setMajorTickSpacing(10);
        variance_slider.setMinorTickSpacing(5);
        variance_slider.setPaintLabels(true);
        variance_slider.setPaintTicks(true);
        variance_slider.setToolTipText("Slide to adjust variance");
        variance_slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                variance_sliderStateChanged(evt);
            }
        });

        variance_textfield.setEditable(false);

        filterRGB_button.setText("Go!");
        filterRGB_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterRGB_buttonActionPerformed(evt);
            }
        });

        analyze_button.setText("Analyze Image");
        analyze_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyze_buttonActionPerformed(evt);
            }
        });

        increment_variance.setText("+");
        increment_variance.setMargin(new java.awt.Insets(1, 5, 1, 5));
        increment_variance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increment_varianceActionPerformed(evt);
            }
        });

        decrement_variance.setText("-");
        decrement_variance.setMargin(new java.awt.Insets(1, 5, 1, 5));
        decrement_variance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrement_varianceActionPerformed(evt);
            }
        });

        saveimage_button.setText("Save File As...");
        saveimage_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveimage_buttonActionPerformed(evt);
            }
        });

        saveimage_group.add(savejpg);
        savejpg.setText(".jpg");
        savejpg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejpgActionPerformed(evt);
            }
        });

        saveimage_group.add(savepng);
        savepng.setText(".png");

        saveimage_group.add(savegif);
        savegif.setText(".gif");

        saveimage_group.add(savebmp);
        savebmp.setText(".bmp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importphoto_button, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filter_G, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(filter_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filterRGB_button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(filter_R, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(variance_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(increment_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(decrement_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(variance_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(saveimage_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(analyze_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(savefile_textfield))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(savejpg)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(savepng)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(savegif)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(savebmp))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {importphoto_button, photo_textfield});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {filterRGB_button, filter_B, filter_G, filter_R});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {decrement_variance, increment_variance});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(photo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(importphoto_button))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(filter_R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(filter_G, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(filter_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterRGB_button))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(variance_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(increment_variance)
                            .addComponent(decrement_variance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(variance_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(analyze_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveimage_button)
                            .addComponent(savefile_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savejpg)
                            .addComponent(savepng)
                            .addComponent(savegif)
                            .addComponent(savebmp))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {importphoto_button, jLabel2, photo_textfield});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {increment_variance, variance_textfield});

        pack();
    }// </editor-fold>                        

    private void importphoto_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        String file_name = photo_textfield.getText();
        boolean[] success = new boolean[1];
        original = PhotoAnalysis.LoadImage(file_name, success);
        Settings.SetFileImport(file_name);
        if(success[0]) {
            /* crop dialogue */
            if(original.getHeight() > 600 || original.getWidth() > 600) {
                resize_message.setText("The image \"" + file_name + "\" will be resized to 600x600.");
                filtered = original;
                resize_dialogue.setVisible(true);
            }
            //photo.setIcon(new javax.swing.ImageIcon(getClass().getResource(file_name)));
            photo.setText("");
            filtered = PhotoAnalysis.ScreenImage(original, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            photo.setIcon(new ImageIcon(original));
        } else {
            photo_textfield.setText("Error reading file");
        }
    }                                                  

    private void filterRGB_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        try {
            int r = Integer.parseInt(filter_R.getText());
            int g = Integer.parseInt(filter_G.getText());
            int b = Integer.parseInt(filter_B.getText());
            Settings.SetRed(r);
            Settings.SetGreen(g);
            Settings.SetBlue(b);
            filtered = PhotoAnalysis.ScreenImage(original, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            //ImageIcon display_photo = new ImageIcon(filtered);
            photo.setIcon(new ImageIcon(filtered));
        } catch(ArrayIndexOutOfBoundsException e) {
            if(filter_R.getText() == "")
                filter_R.setText("Argument required");
            if(filter_G.getText() == "")
                filter_G.setText("Argument required");
            if(filter_B.getText() == "")
                filter_B.setText("Argument required");
        } catch(NumberFormatException e) {
            filter_R.setText("Integer required"); /* want to figure out which box gave the error */
        }
    }                                                

    private void variance_sliderStateChanged(javax.swing.event.ChangeEvent evt) {                                             
        double variance = variance_slider.getValue() / 100.00;
        Settings.SetVariance(variance);
        variance_textfield.setText(variance_slider.getValue() + "%");
        if(original != null) {
            filtered = PhotoAnalysis.ScreenImage(original, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            photo.setIcon(new ImageIcon(filtered));
        }
    }                                            

    private void analyze_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        PhotoAnalysis.AnalyzeImage(filtered);
    }                                              

    private void increment_varianceActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        variance_slider.setValue(variance_slider.getValue() + 1);
        Settings.SetVariance(variance_slider.getValue() / 100);
        variance_textfield.setText(variance_slider.getValue() + "%");
        PhotoAnalysis.GetSupportedFileTypes();
    }                                                  

    private void decrement_varianceActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        variance_slider.setValue(variance_slider.getValue() - 1);
        Settings.SetVariance(variance_slider.getValue() / 100);
        variance_textfield.setText(variance_slider.getValue() + "%");
    }                                                  

    private void savejpgActionPerformed(java.awt.event.ActionEvent evt) {                                        
       
    }                                       

    private void saveimage_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String file_name = savefile_textfield.getText();
        if(file_name == "") {
            //dialogue.setVisible(true);
            //dialogue.setText("Error: Please specify file name to save as");
        } else {
        if(savejpg.isEnabled())
            PhotoAnalysis.SaveImage(file_name, "jpg", filtered);
        else if(savepng.isEnabled())
            PhotoAnalysis.SaveImage(file_name, "png", filtered);
        else if(savegif.isEnabled())
            PhotoAnalysis.SaveImage(file_name, "gif", filtered);
        else if(savebmp.isEnabled())
            PhotoAnalysis.SaveImage(file_name, "bmp", filtered);
        }
    }                                                

    private void resize_okActionPerformed(java.awt.event.ActionEvent evt) {                                          
        resize_dialogue.setVisible(false);
    }                                         

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton analyze_button;
    private javax.swing.JButton decrement_variance;
    private javax.swing.JButton filterRGB_button;
    private javax.swing.JTextField filter_B;
    private javax.swing.JTextField filter_G;
    private javax.swing.JTextField filter_R;
    private javax.swing.JButton importphoto_button;
    private javax.swing.JButton increment_variance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField photo_textfield;
    private javax.swing.JDialog resize_dialogue;
    private javax.swing.JLabel resize_message;
    private javax.swing.JButton resize_ok;
    private javax.swing.JRadioButton savebmp;
    private javax.swing.JTextField savefile_textfield;
    private javax.swing.JRadioButton savegif;
    private javax.swing.JButton saveimage_button;
    private javax.swing.ButtonGroup saveimage_group;
    private javax.swing.JRadioButton savejpg;
    private javax.swing.JRadioButton savepng;
    private javax.swing.JSlider variance_slider;
    private javax.swing.JTextField variance_textfield;
    // End of variables declaration                   
}
