package javax.swing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JTextBox extends JTextField {

    private String text = null;
    private String promptText = null;
    private boolean isPromptText;

    public JTextBox(String text, boolean isPromptText) {
        if (isPromptText) {
            this.promptText = text;
            super.setText(this.promptText);
            super.setForeground(Color.gray);
        }

        else {
            this.text = text;
            super.setText(this.text);
        }
        this.isPromptText = isPromptText;

        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                JTextBox.this.setText("");
            }
        });
    }

    public JTextBox(String text) {
        this(text, false);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
        this.isPromptText = false;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
        this.isPromptText = true;
    }

}
