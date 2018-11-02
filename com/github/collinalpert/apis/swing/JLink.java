package com.github.collinalpert.apis.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * A custom Swing component representing a clickable internet link.
 *
 * @author Collin Alpert
 * @see javax.swing.JLabel
 */
public class JLink extends JLabel {

	/**
	 * Determines if the link will force the HTTPS protocol when clicked.
	 */
	private boolean forceHTTPS = false;
	private String link;
	private Color color = Color.blue;
	/**
	 * The color the link will be in the moment it is clicked.
	 */
	private Color clickColor = new Color(0, 0, 150);
	private Color hoverColor = Color.black;
	private Cursor hoverCursor = new Cursor(Cursor.HAND_CURSOR);

	/**
	 * Constructor for creating a link component.
	 *
	 * @param link      The URL that will be opened in the browser when this link is clicked.
	 * @param text      The text to be displayed.
	 * @param underline Determines if the link will be underlined or not.
	 */
	public JLink(String link, String text, boolean underline) {
		super(text);
		this.setForeground(this.color);
		this.setToolTipText(link);
		this.link = link;
		if (underline) {
			Font font = this.getFont();
			Map<TextAttribute, Integer> attributes = (Map<TextAttribute, Integer>) font.getAttributes();
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			this.setFont(font.deriveFont(attributes));
		}
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(format(JLink.this.link)));
				} catch (URISyntaxException | IOException e1) {
					e1.printStackTrace();
				}
			}

			public void mousePressed(MouseEvent e) {
				JLink.this.setForeground(JLink.this.clickColor);
			}

			public void mouseReleased(MouseEvent e) {
				JLink.this.setForeground(JLink.this.color);
			}

			public void mouseEntered(MouseEvent e) {
				JLink.this.setForeground(JLink.this.hoverColor);
				JLink.this.setCursor(JLink.this.hoverCursor);
			}

			public void mouseExited(MouseEvent e) {
				JLink.this.setForeground(JLink.this.color);
				JLink.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}

	private String format(String link) {
		if (forceHTTPS) {
			if (link.startsWith("http://"))
				return "https://" + link.substring(7);
			else if (!link.startsWith("http")) return "https://" + link;
			else return link;
		} else if (!link.startsWith("http")) return "http://" + link;
		return link;
	}

	public void forceHTTPS(boolean force) {
		this.forceHTTPS = force;
	}

	public boolean isForceHTTPS() {
		return forceHTTPS;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		this.setForeground(this.color);
	}

	public Color getClickColor() {
		return clickColor;
	}

	public void setClickColor(Color color) {
		this.clickColor = color;
	}

	public Color getHoverColor() {
		return hoverColor;
	}

	public void setHoverColor(Color color) {
		this.hoverColor = color;
	}

	public Cursor getHoverCursor() {
		return hoverCursor;
	}

	public void setHoverCursor(Cursor cursor) {
		this.hoverCursor = cursor;
	}
}
