package javax.swing;

import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;

public class JTextBox extends JTextField {

    private String text = null;
    private String promptText = null;
    private boolean isPromptText;

    private final Highlighter defaultHighlighter = this.getHighlighter();

    public JTextBox(String text, boolean isPromptText) {
        super();

        super.setSelectionStart(0);
        super.setSelectionEnd(0);

        this.setIsPromptText(isPromptText);
        if (isPromptText) {
            this.setPromptText(text);
        }

        this.setText(isPromptText ? "" : text);
        super.setText(text);

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPromptText()) {
                    JTextBox.this.setCaretPosition(0);
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (isPromptText() && !e.isActionKey() && !isDeleteKey(e) && !isModifierKey(e)) {
                    JTextBox.this.setText("");
                    JTextBox.this.setIsPromptText(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (isPromptText() && e.isActionKey()) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                boolean canResetPrompt = getText().length() < 1 && isDeleteKey(e);

                if (canResetPrompt) {
                    JTextBox.this.setIsPromptText(true);
                    JTextBox.this.setText(JTextBox.this.getPromptText());
                    JTextBox.this.setCaretPosition(0);
                }
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPromptText() || (isPromptText() && e.getClickCount() > 1))
                    JTextBox.this.setCaretPosition(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (isPromptText() || (isPromptText() && e.getClickCount() > 1))
                    JTextBox.this.setCaretPosition(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isPromptText() || (isPromptText() && e.getClickCount() > 1))
                    JTextBox.this.setCaretPosition(0);
            }
        });
    }

    public JTextBox(String text) {
        this(text, false);
    }

    @Override
    public String getText() {
        if (!isPromptText()) return super.getText();
        return "";
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

    public void setIsPromptText(boolean isPromptText) {
        this.isPromptText = isPromptText;
        this.setHighlighter(isPromptText ? null : defaultHighlighter);
        super.setForeground(isPromptText ? Color.gray : Color.black);
    }

    public boolean isPromptText() {
        return this.isPromptText;
    }

    private boolean isModifierKey(KeyEvent event) {
        return event.isAltDown() || event.isControlDown() || event.isMetaDown() || event.isAltGraphDown();
    }

    private boolean isDeleteKey(KeyEvent e) {
        return e.getExtendedKeyCode() == KeyEvent.VK_DELETE || e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE;
    }
}