// ============================================================================
//   Copyright 2018 Guido De Benedetti
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
// ============================================================================
package org.uncommons.maths.demo;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import org.uncommons.swing.SpringUtilities;

/**
 * @author Guido De Benedetti
 */
class LinearEquationParametersPanel extends ParametersPanel
{
    private final SpinnerNumberModel minXNumberModel = new SpinnerNumberModel(-10, -100, 100, 1);
    private final SpinnerNumberModel maxXNumberModel = new SpinnerNumberModel(10, -100, 100, 1);
    private final SpinnerNumberModel slopeNumberModel = new SpinnerNumberModel(2.0d, -100d, 100.0d, 0.1d);
    private final SpinnerNumberModel interceptNumberModel = new SpinnerNumberModel(-2.0d, -100d, 100.0d, 0.1d);

    public LinearEquationParametersPanel()
    {
        JPanel wrapper = new JPanel(new SpringLayout());
        wrapper.add(new JLabel("Minimum X: "));
        wrapper.add(new JSpinner(minXNumberModel));
        wrapper.add(new JLabel("Maximum X: "));
        wrapper.add(new JSpinner(maxXNumberModel));
        wrapper.add(new JLabel("Slope: "));
        wrapper.add(new JSpinner(slopeNumberModel));
        wrapper.add(new JLabel("Intercept: "));
        wrapper.add(new JSpinner(interceptNumberModel));
        SpringUtilities.makeCompactGrid(wrapper, 8, 1, 5, 5, 5, 5);
        add(wrapper, BorderLayout.NORTH);
    }


    public LinearEquationDistribution createProbabilityDistribution()
    {
		return new LinearEquationDistribution(minXNumberModel.getNumber().intValue(), maxXNumberModel.getNumber().intValue(),
				slopeNumberModel.getNumber().doubleValue(), interceptNumberModel.getNumber().doubleValue());
    }
}
