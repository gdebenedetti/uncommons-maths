package org.uncommons.maths.demo;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import org.uncommons.swing.SpringUtilities;

/**
 * @author Guido De Benedetti
 */
public class MultiplicationFactorPanel extends JPanel {

	private final SpinnerNumberModel factor = new SpinnerNumberModel(100, 1, 1000, 10);

	public MultiplicationFactorPanel() {
		super(new SpringLayout());

		add(new JLabel("Increase # times:"));
		add(new JSpinner(factor));
		setBorder(BorderFactory.createTitledBorder("Multiplication Factor"));
		SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
	}

	public int getMultiplicationFactor() {
		return factor.getNumber().intValue();
	}

}
