package javax.swing;

import java.awt.*;
import java.awt.event.*;

public class JTextBox extends JTextField {

    private String text = null;
    private String promptText = null;
    private boolean isPromptText;

    public JTextBox(String text, boolean isPromptText) {
        super();

        super.setSelectionStart(0);
        super.setSelectionEnd(0);

        this.setIsPrompText(isPromptText);
        if (isPromptText) {
            this.setPromptText(text);
        }

        this.setText(isPromptText ? "" : text);
        super.setText(text);

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                boolean canResetPrompt = JTextBox.this.getCaretPosition() <= 0 &&
                        (e.getExtendedKeyCode() == KeyEvent.VK_DELETE || e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE);

                if (JTextBox.this.isPromptText() && !isArrowKey(e)) {
                    JTextBox.this.setText("");
                    JTextBox.this.setIsPrompText(false);
                }

                if (canResetPrompt) {
                    JTextBox.this.setIsPrompText(true);
                    JTextBox.this.setText(JTextBox.this.getPromptText());
                }

                if (JTextBox.this.isPromptText() && isArrowKey(e))
                    JTextBox.this.setCaretPosition(-1);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (JTextBox.this.isPromptText() && isArrowKey(e))
                    JTextBox.this.setCaretPosition(0);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JTextBox.this.isPromptText())
                    JTextBox.this.setCaretPosition(0);

                if (JTextBox.this.isPromptText() && e.getClickCount() > 1)
                    JTextBox.this.setCaretPosition(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (JTextBox.this.isPromptText())
                    JTextBox.this.setCaretPosition(0);

                if (JTextBox.this.isPromptText() && e.getClickCount() > 1)
                    JTextBox.this.setCaretPosition(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (JTextBox.this.isPromptText())
                    JTextBox.this.setCaretPosition(0);

                if (JTextBox.this.isPromptText() && e.getClickCount() > 1)
                    JTextBox.this.setCaretPosition(0);
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
        super.setText(text);
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public void setIsPrompText(boolean isPrompText) {
        this.isPromptText = isPrompText;
        super.setForeground(isPrompText ? Color.gray : Color.black);
    }

    public boolean isPromptText() {
        return this.isPromptText;
    }

    private boolean isArrowKey(KeyEvent e) {
        return e.getExtendedKeyCode() == KeyEvent.VK_UP ||
                e.getExtendedKeyCode() == KeyEvent.VK_DOWN ||
                e.getExtendedKeyCode() == KeyEvent.VK_LEFT ||
                e.getExtendedKeyCode() == KeyEvent.VK_RIGHT;
    }
}
