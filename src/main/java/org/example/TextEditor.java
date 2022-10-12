package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TextEditor extends JFrame {
    private final JTextField filenameField;
    private  JTextArea textArea;
    private final TextEditorController textEditorController;

    public TextEditor() {
        this.textEditorController = new TextEditorController();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
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
        JPanel filePanel = new JPanel();
        add(filePanel, BorderLayout.NORTH);

        filenameField = new JTextField();
        filenameField.setName("FilenameField");
        filenameField.setPreferredSize(new Dimension(120, 20));
        filePanel.add(filenameField);

        JButton saveButton = new JButton("Save");
        saveButton.setName("SaveButton");
        saveButton.setPreferredSize(new Dimension(65, 20));
        filePanel.add(saveButton);

        JButton loadButton = new JButton("Load");
        loadButton.setName("LoadButton");
        loadButton.setPreferredSize(new Dimension(65, 20));
        filePanel.add(loadButton);

        // Border Layout South
        textArea = new JTextArea();
        textArea.setName("TextArea");
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setName("ScrollPane");
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollableTextArea, BorderLayout.CENTER);

        // ActionListeners
        loadFileMenuItem.addActionListener(e -> textEditorController.loadFile(filenameField, textArea));
        saveFileMenuItem.addActionListener(e -> textEditorController.saveFile(filenameField, textArea));

        exitMenuItem.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        saveButton.addActionListener(e -> textEditorController.saveFile(filenameField, textArea));
        loadButton.addActionListener(e -> textEditorController.loadFile(filenameField, textArea));



        setVisible(true);
    }
}
