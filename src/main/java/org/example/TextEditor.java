package org.example;

import javax.swing.*;

public class TextEditor extends JFrame {
    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Text editor");
        setVisible(true);
        setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setName("TextArea");
        textArea.setBounds(10, 10, 265, 240);
        add(textArea);

    }
}
