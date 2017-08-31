package javax.swing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JCheckBoxGroup extends JPanel {

    private ArrayList<JCheckBox> list = new ArrayList<>();

    public JCheckBoxGroup(JCheckBox... checkBoxes) {
        Arrays.stream(checkBoxes).forEach(this::add);
        list.addAll(Arrays.asList(checkBoxes));
    }

    public JCheckBoxGroup() {

    }

    @Override
    public void remove(int index) {
        super.remove(index);
        list.remove(index);
    }

    @Override
    public Component add(Component comp) {
        if (!(comp instanceof JCheckBox)) throw new IllegalArgumentException("Component is not a JCheckBox.");
        super.add(comp);
        list.add((JCheckBox) comp);
        return comp;
    }

    public void add(JCheckBox... checkBoxes) {
        list.addAll(Arrays.asList(checkBoxes));
        Arrays.stream(checkBoxes).forEach(super::add);
    }

    public void add(ArrayList<JCheckBox> checkBoxes) {
        list.addAll(checkBoxes);
        checkBoxes.forEach(super::add);
    }

    public JCheckBox[] getSelected() {
        return list.stream().filter(JCheckBox::isSelected).toArray(JCheckBox[]::new);
    }

    public String[] getSelectedValues() {
        return list.stream().filter(JCheckBox::isSelected).map(JCheckBox::getText).toArray(String[]::new);
    }
}
