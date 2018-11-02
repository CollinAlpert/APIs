package de.collin.swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a group of {@link JCheckBox}es and allows extended administration over them and their values.
 *
 * @author Collin Alpert
 * @see javax.swing.JCheckBox
 * @see javax.swing.JPanel
 */
public class JCheckBoxGroup extends JPanel {

	private List<JCheckBox> list;

	/**
	 * Constructor for adding a variable amount of checkboxes to this group.
	 *
	 * @param checkBoxes The checkboxes in the group.
	 */
	public JCheckBoxGroup(JCheckBox... checkBoxes) {
		this();
		for (JCheckBox box : checkBoxes) this.add(box);
		list.addAll(Arrays.asList(checkBoxes));
	}

	/**
	 * Default constructor.
	 */
	public JCheckBoxGroup() {
		list = new ArrayList<>();
	}

	/**
	 * Removes a checkbox from the group.
	 *
	 * @param index The index of the checkbox to remove.
	 */
	@Override
	public void remove(int index) {
		super.remove(index);
		list.remove(index);
	}

	/**
	 * Adds a {@link Component} to this group. This {@link Component} <i>has</i> to be a {@link JCheckBox}.
	 *
	 * @param comp The component to add.
	 * @return the component which was added.
	 * @throws IllegalArgumentException if the component is not a {@link JCheckBox}
	 */
	@Override
	public Component add(Component comp) {
		if (!(comp instanceof JCheckBox)) throw new IllegalArgumentException("Component is not a JCheckBox.");
		super.add(comp);
		list.add((JCheckBox) comp);
		return comp;
	}

	/**
	 * Adds a variable amount of checkboxes to the group
	 *
	 * @param checkBoxes The checkboxes to be added.
	 */
	public void add(JCheckBox... checkBoxes) {
		list.addAll(Arrays.asList(checkBoxes));
		for (JCheckBox box : checkBoxes) super.add(box);
	}

	/**
	 * Adds a list of checkboxes to the group.
	 *
	 * @param checkBoxes The list of checkboxes to add.
	 */
	public void add(List<JCheckBox> checkBoxes) {
		list.addAll(checkBoxes);
		checkBoxes.forEach(super::add);
	}

	/**
	 * Gets all checkboxes which are currently selected.
	 *
	 * @return an array of all selected checkboxes.
	 */
	public JCheckBox[] getSelected() {
		return list.stream().filter(JCheckBox::isSelected).toArray(JCheckBox[]::new);
	}

	/**
	 * Gets the text of all checkboxes which are selected.
	 *
	 * @return an array of the text of all selected checkboxes.
	 */
	public String[] getSelectedValues() {
		return list.stream().filter(JCheckBox::isSelected).map(JCheckBox::getText).toArray(String[]::new);
	}
}
