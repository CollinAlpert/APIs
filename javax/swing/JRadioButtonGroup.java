package javax.swing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JRadioButtonGroup extends JPanel {

    private ArrayList<JRadioButton> list = new ArrayList<>();

    public JRadioButtonGroup(JRadioButton... rbs) {
        for (JRadioButton b : rbs) this.add(b);
        list.addAll(Arrays.asList(rbs));
    }

    public JRadioButtonGroup() {
    }

    @Override
    public Component add(Component comp) {
        if (!(comp instanceof JRadioButton)) throw new IllegalArgumentException("Component is not a JRadioButton");
        ((JRadioButton) comp).addActionListener(e -> action((JRadioButton) comp));
        super.add(comp);
        list.add((JRadioButton) comp);
        return comp;
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        list.remove(index);
    }

    public void add(JRadioButton... radioButtons) {
        list.addAll(Arrays.asList(radioButtons));
        Arrays.stream(radioButtons).forEach(super::add);
    }

    public void add(ArrayList<JRadioButton> radioButtons) {
        list.addAll(radioButtons);
        radioButtons.forEach(super::add);
    }

    public JRadioButton getSelected() {
        return list.stream().filter(JRadioButton::isSelected).toArray(JRadioButton[]::new)[0];
    }

    public String getSelectedText() {
        return list.stream().filter(JRadioButton::isSelected).map(JRadioButton::getText).toArray(String[]::new)[0];
    }

    private void action(JRadioButton rb) {
        JRadioButton[] rbs = Arrays.stream(this.getComponents()).map(e -> (JRadioButton)e).toArray(JRadioButton[]::new);
        for (JRadioButton ele: rbs) {
            if (ele == rb) continue;
            ele.setSelected(false);
        }
    }
}
