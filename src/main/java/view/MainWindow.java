/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ExcelController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class MainWindow extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseReadProperties;
    private javax.swing.JComboBox<String> columnsBox;
    private javax.swing.JTextArea contentListFromColumn;
    private javax.swing.JScrollPane contentListPane;
    private javax.swing.JPanel highLeftPanel;
    private javax.swing.JPanel highRightPanel;
    private javax.swing.JButton invokeFileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTextArea letter;
    private javax.swing.JPanel letterPanel;
    private javax.swing.JLabel letterTextPanel;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel mailLoginLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel selectedFilename;
    private javax.swing.JButton sendButton;
    private javax.swing.JComboBox<String> sheetsBox;
    private javax.swing.JTextPane subject;
    private javax.swing.JLabel subjectLabel;
    // End of variables declaration//GEN-END:variables

    private ExcelController controller;
    private DefaultComboBoxModel sheetsBoxModel;
    private DefaultComboBoxModel columnsBoxModel;


    public MainWindow() {
        initComponents();


        controller = new ExcelController(this);
        sheetsBoxModel = new DefaultComboBoxModel();
        columnsBoxModel = new DefaultComboBoxModel();


        invokeFileChooser.addActionListener(e -> invokeFileChooserWindow());
        sheetsBox.addActionListener(e -> onSelectSheet());
        chooseReadProperties.addActionListener(e -> onSelectColumn());
        sendButton.addActionListener(e -> onSendButton());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        selectedFilename = new javax.swing.JLabel();
        invokeFileChooser = new javax.swing.JButton();
        contentListPane = new javax.swing.JScrollPane();
        contentListFromColumn = new javax.swing.JTextArea();
        highRightPanel = new javax.swing.JPanel();
        columnsBox = new javax.swing.JComboBox<>();
        sheetsBox = new javax.swing.JComboBox<>();
        chooseReadProperties = new javax.swing.JButton();
        highLeftPanel = new javax.swing.JPanel();
        mailLoginLabel = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        sendButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        letterPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subject = new javax.swing.JTextPane();
        letterTextPanel = new javax.swing.JLabel();
        subjectLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        letter = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectedFilename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedFilename.setText("Файл не выбран");

        invokeFileChooser.setText("Выбрать файл");

        contentListFromColumn.setColumns(20);
        contentListFromColumn.setRows(5);
        contentListPane.setViewportView(contentListFromColumn);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(contentListPane)
                                        .addGroup(leftPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(selectedFilename, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftPanelLayout.createSequentialGroup()
                                                                .addComponent(invokeFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 199, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(selectedFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invokeFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentListPane)
                                .addContainerGap())
        );

        chooseReadProperties.setText("Выбрать");

        javax.swing.GroupLayout highRightPanelLayout = new javax.swing.GroupLayout(highRightPanel);
        highRightPanel.setLayout(highRightPanelLayout);
        highRightPanelLayout.setHorizontalGroup(
                highRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(columnsBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sheetsBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, highRightPanelLayout.createSequentialGroup()
                                .addGap(0, 159, Short.MAX_VALUE)
                                .addComponent(chooseReadProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        highRightPanelLayout.setVerticalGroup(
                highRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(highRightPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(sheetsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(columnsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseReadProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(64, Short.MAX_VALUE))
        );

        mailLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mailLoginLabel.setText("Логин почты");

        loginField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Пароль");

        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        sendButton.setText("Отправить");

        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout highLeftPanelLayout = new javax.swing.GroupLayout(highLeftPanel);
        highLeftPanel.setLayout(highLeftPanelLayout);
        highLeftPanelLayout.setHorizontalGroup(
                highLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, highLeftPanelLayout.createSequentialGroup()
                                .addContainerGap(59, Short.MAX_VALUE)
                                .addComponent(mailLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addContainerGap(65, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, highLeftPanelLayout.createSequentialGroup()
                                .addGroup(highLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(highLeftPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, highLeftPanelLayout.createSequentialGroup()
                                                .addContainerGap(56, Short.MAX_VALUE)
                                                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, highLeftPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(highLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loginField)
                                                        .addComponent(passwordField)
                                                        .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        highLeftPanelLayout.setVerticalGroup(
                highLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(highLeftPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mailLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                .addContainerGap())
        );

        resultLabel.getAccessibleContext().setAccessibleName("jLabel");

        jScrollPane1.setViewportView(subject);

        letterTextPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letterTextPanel.setText("Текст письма");

        subjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectLabel.setText("Тема письма");

        letter.setColumns(20);
        letter.setRows(5);
        jScrollPane2.setViewportView(letter);

        javax.swing.GroupLayout letterPanelLayout = new javax.swing.GroupLayout(letterPanel);
        letterPanel.setLayout(letterPanelLayout);
        letterPanelLayout.setHorizontalGroup(
                letterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(letterPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(letterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(letterTextPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subjectLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane2)
        );
        letterPanelLayout.setVerticalGroup(
                letterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(letterPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letterTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(highLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(highRightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(letterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(highRightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(highLeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addComponent(letterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void start() {
        EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }

    public void setResultLabelTextColorRed(String text) {
        resultLabel.setText("<html><font color='red'>" + text + "</font></html>");
    }

    public void setResultLabelTextColorGreen(String text) {
        resultLabel.setText("<html><font color = 'green'>" + text + "</font></html>");
    }

    private void invokeFileChooserWindow() {
        columnsBox.removeAllItems();
        sheetsBox.removeAllItems();

        JFileChooser fileOpen = new JFileChooser();
        int ret = fileOpen.showDialog(null, "Выбрать файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileOpen.getSelectedFile();
            selectedFilename.setText(file.getName());
            controller.onSelectFile(file);
            fillSheetsBox();
            resultLabel.setText("");
        }
    }

    private void fillSheetsBox() {
        sheetsBoxModel.addAll(controller.getListOfSheets());
        sheetsBox.setModel(sheetsBoxModel);
    }

    private void onSelectSheet() {
        String sheetName = (String) sheetsBox.getSelectedItem();
        columnsBoxModel.addAll(controller.getListOfColumns(sheetName));
        columnsBox.setModel(columnsBoxModel);
    }

    private void onSelectColumn() {
        contentListFromColumn.selectAll();
        contentListFromColumn.replaceSelection(null);
        List<String> columnContent = controller.selectProperties(
                (String) sheetsBox.getSelectedItem(), (String) columnsBox.getSelectedItem());

        for (String value : columnContent) {
            contentListFromColumn.append(value + "\n");

        }
    }

    private void onSendButton() {
        String login = null;
        String password = null;
        String subjectText = null;
        String letterText = null;
        try {
            login = loginField.getText();
            password = new String(passwordField.getPassword());
            subjectText = subject.getText();
            letterText = letter.getText();
        } catch (NullPointerException | IllegalArgumentException e) {
            controller.throwError(e);
        }
        controller.sendLetters(login, password, subjectText, letterText);
        passwordField.setText(null);
    }


}
