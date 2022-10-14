package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TextEditor extends JFrame {
    private final JTextField filenameField;
    private  JTextArea textArea;
    private final TextEditorController textEditorController;
    JFileChooser jFileChooser;


    public TextEditor() {
        this.jFileChooser = new JFileChooser();
        jFileChooser.setName("FileChooser");
        this.textEditorController = new TextEditorController();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Text editor");
        setLocationRelativeTo(null);



        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setName("MenuFile");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem loadFileMenuItem = new JMenuItem("Load");
        loadFileMenuItem.setName("MenuLoad");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");
        saveFileMenuItem.setName("MenuSave");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");

        fileMenu.add(loadFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Border Layout North
        JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(filePanel, BorderLayout.NORTH);

        //*************************************************************************************
        ImageIcon saveIcon = new ImageIcon("C:\\Users\\rob_t\\JetBrainsAcademy\\JavaCore\\Hard\\TextEditor" +
                "\\src\\main\\resources\\save_icon.png");

        JButton saveButton = new JButton(saveIcon);
        saveButton.setName("SaveButton");
        saveButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(saveButton);

        //****************************************************************************************
        ImageIcon loadIcon = new ImageIcon("C:\\Users\\rob_t\\JetBrainsAcademy\\JavaCore\\Hard\\TextEditor\\src" +
                "\\main\\resources\\load_icon.png");

        JButton loadButton = new JButton(loadIcon);
        loadButton.setName("LoadButton");
        loadButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(loadButton);

        //*********************************************************************************************
        filenameField = new JTextField();
        filenameField.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        filenameField.setName("FilenameField");
        filenameField.setPreferredSize(new Dimension(150, 25));
        filePanel.add(filenameField);

        //**************************************************************************************************
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\rob_t\\JetBrainsAcademy\\JavaCore\\Hard\\TextEditor" +
                "\\src\\main\\resources\\search_icon.png");
        JButton searchButton = new JButton(searchIcon);
        searchButton.setName("StartSearchButton");
        searchButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(searchButton);

        //****************************************************************************************************
        ImageIcon previousIcon = new ImageIcon("C:\\Users\\rob_t\\JetBrainsAcademy\\JavaCore\\Hard\\TextEditor" +
                "\\src\\main\\resources\\previous_icon.png");
        JButton previousButton = new JButton(previousIcon);
        previousButton.setName("PreviousMatchButton");
        previousButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(previousButton);

        //****************************************************************************************************
        ImageIcon nextIcon = new ImageIcon("C:\\Users\\rob_t\\JetBrainsAcademy\\JavaCore\\Hard\\TextEditor" +
                "\\src\\main\\resources\\next_icon.png");
        JButton nextButton = new JButton(nextIcon);
        nextButton.setName("NextMatchButton");
        nextButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(nextButton);











        // Border Layout Center
        textArea = new JTextArea();
        textArea.setName("TextArea");
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setName("ScrollPane");
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollableTextArea, BorderLayout.CENTER);

        // ActionListeners
        loadFileMenuItem.addActionListener(e -> textEditorController.loadFile(jFileChooser, textArea));
        saveFileMenuItem.addActionListener(e -> textEditorController.saveFile(jFileChooser, textArea));

        exitMenuItem.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        saveButton.addActionListener(e -> textEditorController.saveFile(jFileChooser, textArea));
        loadButton.addActionListener(e -> textEditorController.loadFile(jFileChooser, textArea));



        setVisible(true);
    }
}
