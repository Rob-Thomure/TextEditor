package org.example;

import javax.swing.*;

public class TextEditorController {

    public void saveFile(JTextField fileName, JTextArea textArea) {
        Data data = new Data(fileName.getText());
        data.saveFile(textArea.getText());
    }

    public void loadFile(JTextField fileName, JTextArea textArea) {
        Data data = new Data(fileName.getText());
        textArea.setText(data.loadFile());
    }
}
