package org.example;

import javax.swing.*;
import java.io.File;

public class TextEditorController {

    public void saveFile(JFileChooser jFileChooser, JTextArea textArea) {
        jFileChooser.showSaveDialog(null);
        File file = jFileChooser.getSelectedFile();
        Data data = new Data(file);
        data.saveFile(textArea.getText());
    }

    public void loadFile(JFileChooser jFileChooser, JTextArea textArea) {
        jFileChooser.showOpenDialog(null);
        File file = jFileChooser.getSelectedFile();
        Data data = new Data(file);
        textArea.setText(data.loadFile());
    }
}
