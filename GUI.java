//import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.awt.image.ImageObserver;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends javax.swing.JFrame {
    private BufferedImage original = null; /* original image loaded by user */
    private BufferedImage filtered = null; /* filtered image */
    private BufferedImage compare = null; /* image to compare (optional) */
    private Settings settings = new Settings("AppleAnalysis_Settings");
    private Photo photo_handler = new Photo();
    /* holds all loaded trial data in a 2D list for easy reference */
    //public ArrayList<ArrayList<String>> trial_data = new ArrayList<>();
    public GUI() {
        initComponents();
        settings.loadTrials("AppleAnalysis_Trials");
        updateTrialsComboBox();
        System.out.println();
        setTrialTextArea();
        variance_slider.setValue(0);
        variance_textfield.setText("0%");
        /* set all fields based on last-entered info */
        //import_photo.setText(settings.fileImport());
        import_photo.setText("");
        filter_r.setValue(settings.red());
        filter_g.setValue(settings.green());
        filter_b.setValue(settings.blue());
        /* initialize radio buttons */
        before_button.setSelected(true);
        savejpg.setSelected(true);
        //analysis_table.setVisible(false); /* hide for now */
    }
     
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        saveimage_group = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        compare_group = new javax.swing.ButtonGroup();
        save_trial = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        trial_filename = new javax.swing.JTextField();
        trial_name = new javax.swing.JTextField();
        save_dialogueButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        before_field = new javax.swing.JTextField();
        after_field = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        increment_variance = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        decrement_variance = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        saveimage_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        savejpg = new javax.swing.JRadioButton();
        savepng = new javax.swing.JRadioButton();
        savegif = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        savebmp = new javax.swing.JRadioButton();
        variance_slider = new javax.swing.JSlider();
        variance_textfield = new javax.swing.JTextField();
        filterRGB_button = new javax.swing.JButton();
        importphoto_button = new javax.swing.JButton();
        import_photo = new javax.swing.JTextField();
        import_photo.setEditable(false);
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        savefile_textfield = new javax.swing.JTextField();
        savefile_textfield.setEditable(false);
        analyze_button = new javax.swing.JButton();
        pixelsReplaced_label = new javax.swing.JLabel();
        saveData_button = new javax.swing.JButton();
        filter_r = new javax.swing.JSpinner();
        filter_g = new javax.swing.JSpinner();
        filter_b = new javax.swing.JSpinner();
        saveTrial_textfield = new javax.swing.JTextField();
        saveTrial_textfield.setEditable(false);
        compare_button = new javax.swing.JButton();
        comparison_textfield = new javax.swing.JTextField();
        comparison_textfield.setEditable(false);
        analyze_brightness = new javax.swing.JLabel();
        analyze_pixels = new javax.swing.JLabel();
        brighter_value = new javax.swing.JLabel();
        brighter_percent = new javax.swing.JLabel();
        before_button = new javax.swing.JRadioButton();
        after_button = new javax.swing.JRadioButton();
        crop_spinner = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        cropimage_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        importTrial_button = new javax.swing.JButton();
        importTrial_textfield = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trial_textarea = new javax.swing.JTextArea();
        removeTrial_button = new javax.swing.JButton();
        loadedTrials_comboBox = new javax.swing.JComboBox();

        save_trial.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        save_trial.setMinimumSize(new java.awt.Dimension(270, 250));
        save_trial.setResizable(false);

        jLabel9.setText("File Name:");

        jLabel10.setText("Trial Name:");

        save_dialogueButton.setText("Save");
        save_dialogueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_dialogueButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Save Trial");

        jLabel12.setText("Before:");

        jLabel13.setText("After: ");

        javax.swing.GroupLayout save_trialLayout = new javax.swing.GroupLayout(save_trial.getContentPane());
        save_trial.getContentPane().setLayout(save_trialLayout);
        save_trialLayout.setHorizontalGroup(
            save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(save_trialLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, save_trialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save_dialogueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(save_trialLayout.createSequentialGroup()
                        .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trial_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trial_name, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(before_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(after_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        save_trialLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel13});

        save_trialLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {after_field, before_field, trial_filename, trial_name});

        save_trialLayout.setVerticalGroup(
            save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, save_trialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trial_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(trial_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(before_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(after_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_dialogueButton)
                .addContainerGap())
        );

        save_trialLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel13});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("Imported photo will be displayed here");
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        photo.setMaximumSize(new java.awt.Dimension(800, 600));
        photo.setMinimumSize(new java.awt.Dimension(600, 600));

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        increment_variance.setText("+");
        increment_variance.setMargin(new java.awt.Insets(1, 5, 1, 5));
        increment_variance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increment_varianceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("R:");

        decrement_variance.setText("-");
        decrement_variance.setMargin(new java.awt.Insets(1, 5, 1, 5));
        decrement_variance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrement_varianceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("G:");

        saveimage_button.setText("Save Photo As...");
        saveimage_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveimage_buttonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("B:");

        saveimage_group.add(savejpg);
        savejpg.setText(".jpg");

        saveimage_group.add(savepng);
        savepng.setText(".png");

        saveimage_group.add(savegif);
        savegif.setText(".gif");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Set Acceptable Variance:");

        saveimage_group.add(savebmp);
        savebmp.setText(".bmp");

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

        importphoto_button.setText("Import");
        importphoto_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importphoto_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select Photo:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Set RGB Value to Filter:");

        analyze_button.setText("Analyze Image");
        analyze_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyze_buttonActionPerformed(evt);
            }
        });

        saveData_button.setText("Save Trial As...");
        saveData_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveData_buttonActionPerformed(evt);
            }
        });

        filter_r.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        filter_g.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        filter_b.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        compare_button.setText("Compare To...");
        compare_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compare_buttonActionPerformed(evt);
            }
        });

        compare_group.add(before_button);
        before_button.setText("Before");
        before_button.setToolTipText("");

        compare_group.add(after_button);
        after_button.setText("After");

        crop_spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 10));

        jLabel16.setText("pixels from each side");

        cropimage_button.setText("Crop Image by...");
        cropimage_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropimage_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(savejpg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(savepng)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(savegif)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(savebmp))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(saveimage_button)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(savefile_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(saveData_button)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saveTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(114, 114, 114))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(variance_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(increment_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel5))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(filter_g)
                                                            .addComponent(filter_r)
                                                            .addComponent(filter_b, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(filterRGB_button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decrement_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(variance_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pixelsReplaced_label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(compare_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comparison_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(before_button)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(after_button))
                                    .addComponent(analyze_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(brighter_value)
                                                .addComponent(brighter_percent))
                                            .addComponent(analyze_pixels, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                            .addComponent(analyze_brightness, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(import_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importphoto_button, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cropimage_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crop_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {import_photo, importphoto_button});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {crop_spinner, filterRGB_button});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {compare_button, saveData_button, saveimage_button});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comparison_textfield, savefile_textfield});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {analyze_pixels, brighter_percent, brighter_value});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {filter_b, filter_g, filter_r});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(import_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(importphoto_button))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(pixelsReplaced_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crop_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(cropimage_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(filter_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(filter_g, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(filterRGB_button)
                            .addComponent(filter_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(variance_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(increment_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decrement_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(variance_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(analyze_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyze_brightness, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyze_pixels, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compare_button)
                    .addComponent(comparison_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(before_button)
                    .addComponent(after_button))
                .addGap(3, 3, 3)
                .addComponent(brighter_value)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brighter_percent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveimage_button)
                    .addComponent(savefile_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savejpg)
                    .addComponent(savepng)
                    .addComponent(savegif)
                    .addComponent(savebmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveData_button))
                .addGap(29, 29, 29))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {import_photo, importphoto_button, jLabel2});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {increment_variance, variance_textfield});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {analyze_brightness, analyze_pixels, brighter_percent, brighter_value});

        jTabbedPane4.addTab("Individual Photo Analysis", jPanel2);

        importTrial_button.setText("Import Trial...");
        importTrial_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTrial_buttonActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Loaded Trials");

        trial_textarea.setEditable(false);
        trial_textarea.setColumns(20);
        trial_textarea.setRows(5);
        jScrollPane1.setViewportView(trial_textarea);

        removeTrial_button.setText("Remove Trial...");
        removeTrial_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTrial_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(importTrial_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(removeTrial_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadedTrials_comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 101, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {importTrial_button, removeTrial_button});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importTrial_button)
                    .addComponent(importTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeTrial_button)
                    .addComponent(loadedTrials_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Meta Analysis", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void importphoto_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        importphoto_button.setEnabled(false);
        final JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home")));
        chooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        int returnVal = chooser.showOpenDialog(importphoto_button);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File imported_file = chooser.getSelectedFile();
            Photo photo_analysis = new Photo();
            boolean[] success = new boolean[] { false };
            BufferedImage imported_image = photo_analysis.loadImage(imported_file.getPath(), success);
            if(success[0]) {
                original = imported_image;
                import_photo.setText(imported_file.getName());
                settings.setFileImport(imported_file.getPath());
                photo.setText("");
                filtered = photo_analysis.ScreenImage(original, settings.red(), settings.green(), settings.blue(), settings.variance());
                try {
                    photo.setIcon(new ImageIcon(photo_handler.getScaledImage(filtered))); /* set display photo */
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                //photo.setIcon(new ImageIcon(filtered));
            } else {
                import_photo.setText("Error reading file");
            }
        }
        importphoto_button.setEnabled(true);
    }                                                  

    private void filterRGB_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
            int r = (Integer)filter_r.getValue();
            int g = (Integer)(filter_g.getValue());
            int b = (Integer)(filter_b.getValue());
            settings.updateSettings("AppleAnalysis_Settings");
            settings.setRed(r);
            settings.setGreen(g);
            settings.setBlue(b);
            Photo photo_analysis = new Photo();
            filtered = photo_analysis.ScreenImage(filtered, settings.red(), settings.green(), settings.blue(), settings.variance());
        try {        
            photo.setIcon(new ImageIcon(photo_handler.getScaledImage(filtered)));
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void variance_sliderStateChanged(javax.swing.event.ChangeEvent evt) {                                             
        double variance = variance_slider.getValue() / 100.00;
        settings.setVariance(variance);
        variance_textfield.setText(variance_slider.getValue() + "%");
        if(original != null) {
            Photo photo_analysis = new Photo();
            filtered = photo_analysis.ScreenImage(original, settings.red(), settings.green(), settings.blue(), settings.variance());
            try {
                photo.setIcon(new ImageIcon(photo_handler.getScaledImage(filtered)));
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            int replaced = photo_analysis.GetPixelsReplaced();
            NumberFormat nf = NumberFormat.getNumberInstance(); /* format number properly */
            pixelsReplaced_label.setText(nf.format(replaced) + " pixels replaced");
        }
    }
    private void analyze_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Photo photo_analysis = new Photo();
            double pixel_average = photo_analysis.AnalyzeImage(filtered);
            analyze_brightness.setText("Average Brightness: " + pixel_average);
            int pixels_scanned = filtered.getWidth() * filtered.getHeight();
            NumberFormat nf = NumberFormat.getNumberInstance(); /* format number properly */
            analyze_pixels.setText(nf.format(pixels_scanned) + " pixels scanned");
        } catch(NullPointerException e) {
            analyze_brightness.setText("Nothing to analyze! Please import a photo first!");
        }
    }
    private void increment_varianceActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        variance_slider.setValue(variance_slider.getValue() + 1);
        settings.setVariance(variance_slider.getValue() / 100);
        variance_textfield.setText(variance_slider.getValue() + "%");
    }
    private void decrement_varianceActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        variance_slider.setValue(variance_slider.getValue() - 1);
        settings.setVariance(variance_slider.getValue() / 100);
        variance_textfield.setText(variance_slider.getValue() + "%");
    }
    private void saveimage_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            saveimage_button.setEnabled(false);
            final JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home")));
            chooser.setFileFilter(new FileNameExtensionFilter("Image", "jpg", "png", "bmp", "gif"));
            int returnVal = chooser.showSaveDialog(saveimage_button);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File to_save = chooser.getSelectedFile();
                try {
                    String file_type = "";
                    if(savepng.isSelected())
                        file_type = "png";
                    else if(savebmp.isSelected())
                        file_type = "bmp";
                    else if(savegif.isSelected())
                        file_type = "gif";
                    else
                        file_type = "jpg";
                    ImageIO.write(filtered, file_type, to_save);
                    savefile_textfield.setText("Image saved as \"" + to_save.getName() + ".jpg\"");
                } catch (IOException e) {}
            }
        } catch (NullPointerException e) {
        } finally {
            saveimage_button.setEnabled(true);
        }
    }                                                

    private void saveData_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String file_name = saveTrial_textfield.getText();
        /* load fields with current info */
        trial_filename.setText(file_name);
        if(before_button.isEnabled()) {
            before_field.setText(comparison_textfield.getText());
            after_field.setText(import_photo.getText());
        } else if(after_button.isEnabled()) {
            before_field.setText(import_photo.getText());
            after_field.setText(comparison_textfield.getText());
        } else { /* before or after wasn't specified. Clear boxes just in case */
            before_field.setText("");
            after_field.setText(""); 
        }
        save_trial.setVisible(true);
    }                                               

    private void compare_buttonActionPerformed(ActionEvent evt) {
        try {
            Photo photo_analysis = new Photo();
            compare_button.setEnabled(false);
            final JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home")));
            chooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            int returnVal = chooser.showOpenDialog(compare_button);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File imported_file = chooser.getSelectedFile();
                boolean load[] = new boolean[1];
                compare = photo_analysis.loadImage(imported_file.getPath(), load);
                if (!load[0])
                    comparison_textfield.setText("Error reading file"); /* file could not be loaded */
                else {
                    comparison_textfield.setText(imported_file.getName());
                    double filtered_brightness = photo_handler.AnalyzeImage(filtered);
                    double compared_brightness = photo_handler.AnalyzeImage(compare);
                    double difference = filtered_brightness - compared_brightness;
                    double percent_difference = (filtered_brightness - compared_brightness) / 255 * 100;
                    if (difference > 0) {
                        brighter_value.setText("Current image is brighter by " + difference + " (" +
                                Math.floor(percent_difference * 100) / 100 + " percent)");
                    } else if (difference < 0) {
                        brighter_value.setText("Current image is darker by " + (-1 * difference) + "(" +
                                Math.floor(-1 * percent_difference * 100) / 100 + " percent");
                    } else {
                        brighter_value.setText("Current image is as bright as compared image");
                    }
                }

            }
        } catch(NullPointerException e) {

        } finally {
            compare_button.setEnabled(true);
        }
    }                                              

    private void importTrial_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        boolean[] success = new boolean[1];
        String trial_name = importTrial_textfield.getText();
        Trial new_trial = new Trial();
        new_trial = new_trial.ReadDataFile(trial_name, success); /* read the chosen trial's data file */
        if(success[0]) { /* data from trial successfully read into 'new_trial' */
            settings.addTrial(new_trial); /* add to the current array of trials */
            setTrialTextArea();
            updateTrialsComboBox();
        } else System.out.println("Error getting trial data");
    }                                                  

    private void cropimage_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int pixels = (Integer) crop_spinner.getValue();
        /* make sure getCroppedImage value isn't larger than image itself */
            if (2 * pixels >= filtered.getWidth() || 2 * pixels >= filtered.getHeight())
                System.out.println("Error: crop image size larger than image itself");
            else {
                filtered = photo_handler.getCroppedImage(pixels, filtered); /* getCroppedImage filtered */
                original = filtered; /* also getCroppedImage original */
                try {
                    photo.setIcon(new ImageIcon(photo_handler.getScaledImage(filtered)));
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch(NullPointerException e) {

        }
    }
    private void save_dialogueButtonActionPerformed(ActionEvent evt) {
        boolean[] read_success = new boolean[1];
        BufferedImage before = photo_handler.loadImage(before_field.getText(), read_success);
        if(read_success[0]) {
            BufferedImage after = photo_handler.loadImage(after_field.getText(), read_success);
        if(read_success[0]) {
            /* get brightness change over course of this trial */
            double difference = photo_handler.AnalyzeImage(after) - photo_handler.AnalyzeImage(before);
            Trial this_trial = new Trial(trial_filename.getText(), trial_name.getText(), difference);
            boolean write_success = this_trial.writeToFile(this_trial);
            if(write_success) /* trial saved successfully - close dialogue window */
                save_trial.setVisible(false);
            else
                System.out.println("Error saving data");
        } else
            System.out.println("Error loading image \"" + after_field.getText() + "\"");
        } else
            System.out.println("Error loading image \"" + before_field.getText() + "\"");
    }                                                   

    private void removeTrial_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    /* get value selected in combo box. This will be the trial name of the trial to remove */
    String trial_to_remove = String.valueOf(loadedTrials_comboBox.getSelectedItem());
    settings.removeTrial(trial_to_remove);
    updateTrialsComboBox(); /* update combo box */
    setTrialTextArea();
    }                                                  
    public void setTrialTextArea() {
        ArrayList<Trial> trial_list = settings.trials();
        boolean[] success = new boolean[1];
        /* holds all loaded trial data in a 2D list for easy reference */
        String text_area = "";
        /* now we need to format the data (rank\) file_name | trial_name | brightness\n)*/
        int longest_filename = 0;
        int longest_trialname = 0;
        int longest_brightness = 0;
        /* get longest string values for each value */
        for(int i = 0; i < trial_list.size(); i++) {
            if(trial_list.get(i).file_name.length() > longest_filename)
                longest_filename = trial_list.get(i).file_name.length();
            if(trial_list.get(i).trial_name.length() > longest_trialname)
                longest_trialname = trial_list.get(i).trial_name.length();
            if(Double.toString(trial_list.get(i).brightness_change).length() > longest_brightness)
                longest_brightness = Double.toString(trial_list.get(i).brightness_change).length();
        }
        for(int i = 0; i < trial_list.size(); i++) {
            String line = (i + 1) + ". " + trial_list.get(i).file_name;
            for(int j = trial_list.get(i).file_name.length(); j < longest_filename + 1; j++)
                line += " ";
            line += "| " + trial_list.get(i).trial_name;
            for(int j = trial_list.get(i).trial_name.length(); j < longest_trialname + 1; j++)
                line += " ";
            line += "| " + Double.toString(trial_list.get(i).brightness_change);
        text_area += line + "\n";
        }
    trial_textarea.setText(text_area);
    }
    /* updates 'loadedTrials_comboBox' with loaded trials */
    public void updateTrialsComboBox() {
        loadedTrials_comboBox.removeAllItems(); /* clear combo box */
        /* get arraylist of trials and convert to array */
        ArrayList<Trial> trial_list = settings.trials();
        /* create an empty array list to hold what will be put in the combo box  */
        ArrayList<String> combo_box = new ArrayList<>(); 
        for(int i = 0; i < trial_list.size(); i++) {
            String trial_to_compare = trial_list.get(i).trialName();
            boolean trial_is_original = true;
            /* checks each element in combo_box to see if it is a duplicate */
            for(int j = 0; j < combo_box.size(); j++) {
                if(trial_to_compare.equals(combo_box.get(j))) {
                    trial_is_original = false; /* duplicate */
                    System.out.println("Trial is not original");
                    break;
                }
            }
            if(trial_is_original) { /* not a duplicate */
                combo_box.add(trial_to_compare); /* add to arraylist */
                loadedTrials_comboBox.addItem(trial_to_compare); /* add to combo box */
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton after_button;
    private javax.swing.JTextField after_field;
    private javax.swing.JLabel analyze_brightness;
    private javax.swing.JButton analyze_button;
    private javax.swing.JLabel analyze_pixels;
    private javax.swing.JRadioButton before_button;
    private javax.swing.JTextField before_field;
    private javax.swing.JLabel brighter_percent;
    private javax.swing.JLabel brighter_value;
    private javax.swing.JButton compare_button;
    private javax.swing.ButtonGroup compare_group;
    private javax.swing.JTextField comparison_textfield;
    private javax.swing.JSpinner crop_spinner;
    private javax.swing.JButton cropimage_button;
    private javax.swing.JButton decrement_variance;
    private javax.swing.JButton filterRGB_button;
    private javax.swing.JSpinner filter_b;
    private javax.swing.JSpinner filter_g;
    private javax.swing.JSpinner filter_r;
    private javax.swing.JButton importTrial_button;
    private javax.swing.JTextField importTrial_textfield;
    private javax.swing.JTextField import_photo;
    private javax.swing.JButton importphoto_button;
    private javax.swing.JButton increment_variance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JComboBox loadedTrials_comboBox;
    private javax.swing.JLabel photo;
    private javax.swing.JLabel pixelsReplaced_label;
    private javax.swing.JButton removeTrial_button;
    private javax.swing.JButton saveData_button;
    private javax.swing.JTextField saveTrial_textfield;
    private javax.swing.JButton save_dialogueButton;
    private javax.swing.JDialog save_trial;
    private javax.swing.JRadioButton savebmp;
    private javax.swing.JTextField savefile_textfield;
    private javax.swing.JRadioButton savegif;
    private javax.swing.JButton saveimage_button;
    private javax.swing.ButtonGroup saveimage_group;
    private javax.swing.JRadioButton savejpg;
    private javax.swing.JRadioButton savepng;
    private javax.swing.JTextField trial_filename;
    private javax.swing.JTextField trial_name;
    private javax.swing.JTextArea trial_textarea;
    private javax.swing.JSlider variance_slider;
    private javax.swing.JTextField variance_textfield;
    // End of variables declaration                   
}
