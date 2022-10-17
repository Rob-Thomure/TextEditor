package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class TextEditor extends JFrame {
    private JTextField searchField;
    private  JTextArea textArea;
    private TextEditorController textEditorController;
    JFileChooser jFileChooser;
    private final String resourceFolderPath = String.format("src%smain%<sresources%<s", File.separator);
    ImageIcon saveIcon = new ImageIcon(resourceFolderPath + "save_icon.png");
    ImageIcon loadIcon = new ImageIcon(resourceFolderPath + "load_icon.png");
    ImageIcon searchIcon = new ImageIcon(resourceFolderPath + "search_icon.png");
    ImageIcon previousIcon = new ImageIcon(resourceFolderPath + "previous_icon.png");
    ImageIcon nextIcon = new ImageIcon(resourceFolderPath + "next_icon.png");


    public TextEditor() {
        this.jFileChooser = new JFileChooser();
        jFileChooser.setName("FileChooser");
        add(jFileChooser);
        this.textEditorController = new TextEditorController();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
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
        loadFileMenuItem.setName("MenuOpen");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");
        saveFileMenuItem.setName("MenuSave");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");

        fileMenu.add(loadFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        JMenu searchMenu = new JMenu("Search");
        searchMenu.setName("MenuSearch");
        searchMenu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(searchMenu);

        JMenuItem startSearchMenuItem = new JMenuItem("Start search");
        startSearchMenuItem.setName("MenuStartSearch");

        JMenuItem previousMatchMenuItem = new JMenuItem("Previous match");
        previousMatchMenuItem.setName("MenuPreviousMatch");

        JMenuItem nextMatchMenuItem = new JMenuItem("Next match");
        nextMatchMenuItem.setName("MenuNextMatch");

        JMenuItem useRegexMenuItem = new JMenuItem("Use regular expressions");
        useRegexMenuItem.setName("MenuUseRegExp");

        searchMenu.add(startSearchMenuItem);
        searchMenu.add(previousMatchMenuItem);
        searchMenu.add(nextMatchMenuItem);
        searchMenu.add(useRegexMenuItem);

        // Border Layout North
        JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(filePanel, BorderLayout.NORTH);

        //*************************************************************************************
        JButton saveButton = new JButton(saveIcon);
        saveButton.setName("SaveButton");
        saveButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(saveButton);

        //****************************************************************************************
        JButton loadButton = new JButton(loadIcon);
        loadButton.setName("OpenButton");
        loadButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(loadButton);

        //*********************************************************************************************
        searchField = new JTextField();
        searchField.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        searchField.setName("SearchField");
        searchField.setPreferredSize(new Dimension(150, 25));
        filePanel.add(searchField);

        //**************************************************************************************************
        JButton searchButton = new JButton(searchIcon);
        searchButton.setName("StartSearchButton");
        searchButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(searchButton);

        //****************************************************************************************************
        JButton previousButton = new JButton(previousIcon);
        previousButton.setName("PreviousMatchButton");
        previousButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(previousButton);

        //****************************************************************************************************
        JButton nextButton = new JButton(nextIcon);
        nextButton.setName("NextMatchButton");
        nextButton.setPreferredSize(new Dimension(25, 25));
        filePanel.add(nextButton);

        //****************************************************************************************************
        JCheckBox regexCheckBox = new JCheckBox("Use regex");
        regexCheckBox.setName("UseRegExCheckbox");
        filePanel.add(regexCheckBox);











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

        searchButton.addActionListener(e -> textEditorController.searchText(searchField, textArea, regexCheckBox));

        nextButton.addActionListener(e -> textEditorController.next(textArea));
        previousButton.addActionListener(e -> textEditorController.previous(textArea));

        startSearchMenuItem.addActionListener(e -> {
            regexCheckBox.setSelected(false);
            textEditorController.searchText(searchField, textArea, regexCheckBox);
        });

        nextMatchMenuItem.addActionListener(e -> textEditorController.next(textArea));
        previousMatchMenuItem.addActionListener(e -> textEditorController.previous(textArea));

        useRegexMenuItem.addActionListener(e -> {
            regexCheckBox.setSelected(true);
            textEditorController.searchText(searchField, textArea, regexCheckBox);
        });


        setVisible(true);

    }
}
