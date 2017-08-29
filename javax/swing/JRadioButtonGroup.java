package javax.swing;

import java.awt.*;
import java.util.Arrays;

public class JRadioButtonGroup extends JPanel {

    public JRadioButtonGroup(JRadioButton... rbs) {
        Arrays.stream(rbs).forEach(this::add);
    }

    public JRadioButtonGroup() {

    }

    @Override
    public Component add(Component comp) {
        if (!(comp instanceof JRadioButton)) throw new IllegalArgumentException("Component is not a JRadioButton");
        ((JRadioButton) comp).addActionListener(e -> action((JRadioButton) comp));
        super.add(comp);
        return comp;
    }

    private void action(JRadioButton rb) {
        JRadioButton[] rbs = Arrays.stream(this.getComponents()).map(e -> (JRadioButton)e).toArray(JRadioButton[]::new);
        for (JRadioButton ele: rbs) {
            if (ele == rb) continue;
            ele.setSelected(false);
        }
    }
}
