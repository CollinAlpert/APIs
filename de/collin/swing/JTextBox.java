package de.collin.swing;

import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Represents an input field for text that also allows for prompt text.
 *
 * @author Collin Alpert
 * @see javax.swing.JTextField
 */
public class JTextBox extends JTextField {

	private final Highlighter defaultHighlighter = this.getHighlighter();
	private String promptText = null;
	private boolean isPromptText;

	/**
	 * Constructor for setting the text inside the text box.
	 *
	 * @param text         The text to be displayed in the text box.
	 * @param isPromptText Determines if that text is supposed to be the prompt text or not.
	 */
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

	/**
	 * Constructor for adding normal text into the text box.
	 *
	 * @param text The normal text to be displayed in the text box.
	 */
	public JTextBox(String text) {
		this(text, false);
	}

	/**
	 * Default constructor.
	 */
	public JTextBox() {
		this("", false);
	}

	/**
	 * @return the normal text in the text box.
	 */
	@Override
	public String getText() {
		if (!isPromptText()) return super.getText();
		return "";
	}

	/**
	 * Sets the normal text in the text box.
	 *
	 * @param text The text to be displayed.
	 */
	@Override
	public void setText(String text) {
		super.setText(text);
	}

	public String getPromptText() {
		return promptText;
	}

	/**
	 * @param isPromptText Determines if the current text is supposed to be displayed as prompt text.
	 */
	public void setIsPromptText(boolean isPromptText) {
		this.isPromptText = isPromptText;
		this.setHighlighter(isPromptText ? null : defaultHighlighter);
		super.setForeground(isPromptText ? Color.gray : Color.black);
	}

	public boolean isPromptText() {
		return this.isPromptText;
	}

	public void setPromptText(String promptText) {
		this.promptText = promptText;
	}

	private boolean isModifierKey(KeyEvent event) {
		return event.isAltDown() || event.isControlDown() || event.isMetaDown() || event.isAltGraphDown();
	}

	private boolean isDeleteKey(KeyEvent e) {
		return e.getExtendedKeyCode() == KeyEvent.VK_DELETE || e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE;
	}
}