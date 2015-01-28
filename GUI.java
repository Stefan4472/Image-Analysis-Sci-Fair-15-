//import java.awt.*;
import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class GUI extends javax.swing.JFrame {
    public static BufferedImage original = null; /* original image loaded by user */
    public static BufferedImage filtered = null; /* filtered image */
    public static BufferedImage compare = null; /* image to compare (optional) */
    public GUI() {
        initComponents();
        Settings.LoadSettings(); /* load last-used filenames and variance settings */
        variance_slider.setValue(0);
        variance_textfield.setText("0%");
        /* set all fields based on last-entered info */
        photo_textfield.setText(Settings.GetFileImport());
        filter_r.setValue(Settings.GetRed());
        filter_g.setValue(Settings.GetGreen());
        filter_b.setValue(Settings.GetBlue());  
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
        photo_textfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        savefile_textfield = new javax.swing.JTextField();
        analyze_button = new javax.swing.JButton();
        pixelsReplaced_label = new javax.swing.JLabel();
        saveData_button = new javax.swing.JButton();
        filter_r = new javax.swing.JSpinner();
        filter_g = new javax.swing.JSpinner();
        filter_b = new javax.swing.JSpinner();
        saveTrial_textfield = new javax.swing.JTextField();
        compare_button = new javax.swing.JButton();
        comparison_textfield = new javax.swing.JTextField();
        analyze_brightness = new javax.swing.JLabel();
        analyze_pixels = new javax.swing.JLabel();
        brighter_value = new javax.swing.JLabel();
        brighter_percent = new javax.swing.JLabel();
        before_button = new javax.swing.JRadioButton();
        after_button = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        analysis_table = new javax.swing.JTable();
        importTrial_button = new javax.swing.JButton();
        importTrial_textfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        save_trial.setBounds(new java.awt.Rectangle(0, 0, 0, 0));

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

        after_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                after_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout save_trialLayout = new javax.swing.GroupLayout(save_trial.getContentPane());
        save_trial.getContentPane().setLayout(save_trialLayout);
        save_trialLayout.setHorizontalGroup(
            save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(save_trialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(save_trialLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trial_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(save_trialLayout.createSequentialGroup()
                        .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trial_name, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(before_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(after_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(save_trialLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(save_trialLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(save_dialogueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        save_trialLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel13});

        save_trialLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {after_field, before_field, trial_filename, trial_name});

        save_trialLayout.setVerticalGroup(
            save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, save_trialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(save_trialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trial_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
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
        savejpg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejpgActionPerformed(evt);
            }
        });

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
        jLabel2.setText("Enter Name of Photo:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(saveTrial_textfield)))
                                .addGap(164, 164, 164))
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
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(filter_g)
                                                    .addComponent(filter_r, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                    .addComponent(filter_b))
                                                .addGap(7, 7, 7)
                                                .addComponent(filterRGB_button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(decrement_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(variance_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pixelsReplaced_label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(analyze_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(compare_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparison_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(before_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(after_button)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(photo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importphoto_button, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brighter_value)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(analyze_pixels, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                .addComponent(analyze_brightness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(brighter_percent))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {importphoto_button, photo_textfield});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {filterRGB_button, filter_r});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {compare_button, saveData_button, saveimage_button});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comparison_textfield, savefile_textfield});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {analyze_pixels, brighter_percent, brighter_value});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(photo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(importphoto_button))
                .addGap(18, 18, 18)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(variance_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pixelsReplaced_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analyze_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyze_brightness, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyze_pixels, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveData_button)
                    .addComponent(saveTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {importphoto_button, jLabel2, photo_textfield});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {increment_variance, variance_textfield});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {analyze_brightness, analyze_pixels, brighter_percent, brighter_value});

        jTabbedPane4.addTab("Individual Photo Analysis", jPanel2);

        analysis_table.setModel(new MyTableModel());
        jScrollPane1.setViewportView(analysis_table);

        importTrial_button.setText("Import Trial...");
        importTrial_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTrial_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(importTrial_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importTrial_button)
                    .addComponent(importTrial_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(207, 207, 207))
        );

        jTabbedPane4.addTab("Meta Analysis", jPanel3);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Inhibiting Apple Browning");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setText("Written by Stefan Kussmaul");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(586, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane4)
                    .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void importphoto_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        String file_name = photo_textfield.getText();
        boolean[] success = new boolean[1];
        original = PhotoAnalysis.LoadImage(file_name, success);
        if(success[0]) { 
            Settings.SetFileImport(file_name);
            //photo.setIcon(new javax.swing.ImageIcon(getClass().getResource(file_name)));
            photo.setText("");
            filtered = PhotoAnalysis.ScreenImage(original, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            photo.setIcon(new ImageIcon(filtered));
        } else {
            photo_textfield.setText("Error reading file");
        }
    }                                                  

    private void filterRGB_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
            int r = (Integer)filter_r.getValue();
            int g = (Integer)(filter_g.getValue());
            int b = (Integer)(filter_b.getValue());
            Settings.SetRed(r);
            Settings.SetGreen(g);
            Settings.SetBlue(b);
            filtered = PhotoAnalysis.ScreenImage(original, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            photo.setIcon(new ImageIcon(filtered));        
    }                                                

    private void variance_sliderStateChanged(javax.swing.event.ChangeEvent evt) {                                             
        double variance = variance_slider.getValue() / 100.00;
        Settings.SetVariance(variance);
        variance_textfield.setText(variance_slider.getValue() + "%");
        if(original != null) {
            filtered = PhotoAnalysis.ScreenImage(original, Settings.GetRed(), Settings.GetGreen(), Settings.GetBlue(), Settings.GetVariance());
            photo.setIcon(new ImageIcon(filtered));
            int replaced = PhotoAnalysis.GetPixelsReplaced();
            NumberFormat nf = NumberFormat.getNumberInstance(); /* format number properly */
            pixelsReplaced_label.setText(nf.format(replaced) + " pixels replaced");
        }
    }                                            

    private void analyze_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        double pixel_average[] = PhotoAnalysis.AnalyzeImage(filtered);
        analyze_brightness.setText("Average Brightness: " + pixel_average[0]);
        int pixels_scanned = filtered.getWidth() * filtered.getHeight();
        NumberFormat nf = NumberFormat.getNumberInstance(); /* format number properly */
        analyze_pixels.setText(nf.format(pixels_scanned) + " pixels scanned");
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

    private void saveData_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String file_name = saveTrial_textfield.getText();
        /* load fields with current info */
        trial_filename.setText(file_name);
        if(before_button.isEnabled()) {
            before_field.setText(comparison_textfield.getText());
            after_field.setText(photo_textfield.getText());
        } else if(after_button.isEnabled()) {
            before_field.setText(photo_textfield.getText());
            after_field.setText(comparison_textfield.getText());
        } else { /* before or after wasn't specified. Clear boxes just in case */
            before_field.setText("");
            after_field.setText(""); 
        }
        save_trial.setVisible(true);
        
    }                                               

    private void compare_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String file_name = comparison_textfield.getText();
        if(file_name == "") 
            System.out.println("Missing argument"); /* no file name specified */
        else {
            boolean load[] = new boolean[1]; 
            compare = PhotoAnalysis.LoadImage(file_name, load); /* load[0] will be true if file loaded correctly */
            if(!load[0])
                System.out.print("Error reading file"); /* file could not be loaded */
            else {
                double[] filtered_brightness = PhotoAnalysis.AnalyzeImage(filtered);
                double[] compared_brightness = PhotoAnalysis.AnalyzeImage(compare);
                double difference = filtered_brightness[0] - compared_brightness[0];
                double percent_difference = (filtered_brightness[0] - compared_brightness[0]) / 255 * 100;
                NumberFormat pf = NumberFormat.getPercentInstance(); /* for formatting percents */
                /* difference is positive: current image is brighter than compared image */
                if(difference > 0) {
                    brighter_value.setText("Current image is brighter by " + difference + " (" + 
                            Math.floor(percent_difference * 100) / 100 + " percent)");
                } else {
                    brighter_value.setText("Current image is darker by " + (-1 * difference) + "(" +
                            Math.floor(-1 * percent_difference * 100) / 100 + " percent");
                }
            }
        }
    }                                              

    private void save_dialogueButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        double[] filtered_brightness = PhotoAnalysis.AnalyzeImage(filtered);
        double[] compared_brightness = PhotoAnalysis.AnalyzeImage(compare);
        double difference; /* brightness change over course of trial */
        if(before_button.isSelected()) /* photo to compare is the "before" */
            difference = filtered_brightness[0] - compared_brightness[0];
        else 
            difference = compared_brightness[0] - filtered_brightness[0];
        Trial this_trial = new Trial();
        this_trial.SetTrial(trial_filename.getText(), trial_name.getText(), difference);
        boolean success = Trial.WriteTrial(this_trial);
        if(success) /* trial saved successfully - close dialogue window */
            save_trial.setVisible(false);
        else
            System.out.println("Error saving data");
    }                                                   

    private void after_fieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void importTrial_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        boolean[] success = new boolean[1];
        String trial_name = importTrial_textfield.getText();
        Trial new_trial = Trial.ReadDataFile(trial_name, success);
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
    private javax.swing.JRadioButton after_button;
    private javax.swing.JTextField after_field;
    private javax.swing.JTable analysis_table;
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
    private javax.swing.JButton decrement_variance;
    private javax.swing.JButton filterRGB_button;
    private javax.swing.JSpinner filter_b;
    private javax.swing.JSpinner filter_g;
    private javax.swing.JSpinner filter_r;
    private javax.swing.JButton importTrial_button;
    private javax.swing.JTextField importTrial_textfield;
    private javax.swing.JButton importphoto_button;
    private javax.swing.JButton increment_variance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField photo_textfield;
    private javax.swing.JLabel pixelsReplaced_label;
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
    private javax.swing.JSlider variance_slider;
    private javax.swing.JTextField variance_textfield;
    // End of variables declaration                   
}
