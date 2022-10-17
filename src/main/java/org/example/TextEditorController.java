package org.example;

import javax.swing.*;
import java.io.File;
import java.util.regex.MatchResult;

public class TextEditorController {
    private Text text;

    public void saveFile(JFileChooser jFileChooser, JTextArea textArea) {
        jFileChooser.showSaveDialog(null);
        File file = jFileChooser.getSelectedFile();
        if (file != null) {
            Data data = new Data(file);
            data.saveFile(textArea.getText());
        }
    }

    public void loadFile(JFileChooser jFileChooser, JTextArea textArea) {
        jFileChooser.showOpenDialog(null);
        File file = jFileChooser.getSelectedFile();
        Data data = new Data(file);
        textArea.setText(data.loadFile());
    }

//    public void searchText(JTextField searchField, JTextArea textArea, JCheckBox useRegexp) {
//        this.text = new Text(textArea.getText(), searchField.getText(), useRegexp.isSelected());
//        MatchResult matchResult = text.search();
//        if (matchResult != null) {
//            textArea.setCaretPosition(matchResult.start() + matchResult.group().length());
//            textArea.select(matchResult.start(), matchResult.start() + matchResult.group().length());
//            textArea.grabFocus();
//        }
//    }

    public void searchText(JTextField searchField, JTextArea textArea, JCheckBox useRegexp) {
        class search extends SwingWorker<MatchResult, Object> {
            @Override
            protected MatchResult doInBackground() {
                text = new Text(textArea.getText(), searchField.getText(), useRegexp.isSelected());
                MatchResult matchResult = text.search();
                if (matchResult != null) {
                    textArea.setCaretPosition(matchResult.start() + matchResult.group().length());
                    textArea.select(matchResult.start(), matchResult.start() + matchResult.group().length());
                    textArea.grabFocus();
                }
                return null;
            }
        }
        new search().doInBackground();
    }

    class test extends SwingWorker<MatchResult, MatchResult> {
        @Override
        protected MatchResult doInBackground() throws Exception {
            publish(text.search());
            return text.search();
        }

    }


    public void next(JTextArea textArea) {
        if (text != null) {
            MatchResult matchResult = text.next();
            if (matchResult != null) {
                textArea.setCaretPosition(matchResult.end());
                textArea.select(matchResult.start(), matchResult.end());
                textArea.grabFocus();
            }
        }
    }

    public void previous(JTextArea textArea) {
        if (text != null) {
            MatchResult matchResult = text.previous();
            if (matchResult != null) {
                textArea.setCaretPosition(matchResult.end());
                textArea.select(matchResult.start(), matchResult.end());
                textArea.grabFocus();
            }
        }
    }
}
