package org.example;

import javax.swing.*;
import java.awt.*;

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
        saveButton.addActionListener(e -> textEditorController.saveFile(filenameField, textArea));

        JButton loadButton = new JButton("Load");
        loadButton.setName("LoadButton");
        loadButton.setPreferredSize(new Dimension(65, 20));
        filePanel.add(loadButton);
        loadButton.addActionListener(e -> textEditorController.loadFile(filenameField, textArea));

        textArea = new JTextArea();
        textArea.setName("TextArea");
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setName("ScrollPane");
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollableTextArea);
        setVisible(true);
    }
}
