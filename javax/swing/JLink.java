package javax.swing;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

//add underline to text

public class JLink extends JLabel {

    private boolean forceHTTPS = false;
    private String link;
    private Color color = Color.blue;
    private Color clickColor = new Color(0, 0, 150);
    private Color hoverColor = Color.black;
    private Cursor hoverCursor = new Cursor(Cursor.HAND_CURSOR);


    @SuppressWarnings("unchecked")
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
        else return link;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setForeground(this.color);
    }

    public void setClickColor(Color color) {
        this.clickColor = color;
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    public void setHoverCursor(Cursor cursor) {
        this.hoverCursor = cursor;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void forceHTTPS(boolean force) {
        this.forceHTTPS = force;
    }


}
