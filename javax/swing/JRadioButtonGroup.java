package javax.swing;

import java.awt.*;
import java.util.Arrays;

public class JRadioButtonGroup extends JPanel {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int layout = HORIZONTAL;

    public JRadioButtonGroup(int layout, JRadioButton... rbs) {
        if (layout != HORIZONTAL && layout != VERTICAL) {
            throw new IllegalArgumentException("Must be either: HORIZONTAL or VERTICAL");
        }
        this.layout = layout;
        if (this.layout == VERTICAL) this.setLayout(new BoxLayout(this, 2));
        Arrays.stream(rbs).forEach(this::add);
    }

    public JRadioButtonGroup(JRadioButton... rbs) {
        Arrays.stream(rbs).forEach(this::add);
    }

    public JRadioButtonGroup(int layout) {
        if (layout != HORIZONTAL && layout != VERTICAL) {
            throw new IllegalArgumentException("Must be either: HORIZONTAL or VERTICAL");
        }
        this.layout = layout;
        if (this.layout == VERTICAL) this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public JRadioButtonGroup() {

    }

    public void setLayout(int layout) {
        if (layout != HORIZONTAL && layout != VERTICAL) {
            throw new IllegalArgumentException("Must be either: HORIZONTAL or VERTICAL");
        }
        this.layout = layout;
        if (this.layout == VERTICAL) this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public Component add(Component comp) {
        if (!(comp instanceof JRadioButton)) throw new IllegalArgumentException("Component is not a JRadioButton");
        super.add(comp);
        return comp;
    }
}
