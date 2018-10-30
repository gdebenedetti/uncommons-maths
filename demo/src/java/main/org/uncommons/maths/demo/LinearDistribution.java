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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.uncommons.maths.random.DiscreteUniformGenerator;

/**
 * @author gdebenedetti
 */
class LinearDistribution extends ProbabilityDistribution
{
    private final int minX;
    private final int maxX;
    private final double slope;
    private final double intercept;

    public LinearDistribution(int minX, int maxX, double slope, double intercept)
    {
        this.minX = minX;
        this.maxX = maxX;
        this.slope = slope;
        this.intercept = intercept;
    }

    public Map<Double, Double> getExpectedValues()
    {
        Map<Double, Double> values = new LinkedHashMap<Double, Double>();
        for (int i = minX; i <= maxX; i++)
        {
            //values.put((double) i, 1d / ((maxX - minX) + 1));
        	values.put((double) i, (slope * i + intercept));
        }
        return values;
    }

    protected DiscreteUniformGenerator createValueGenerator(Random rng)
    {
        return new DiscreteUniformGenerator(minX, maxX, rng);
    }

    public double getExpectedMean()
    {
        return (maxX - minX) / 2 + minX;
    }

    public double getExpectedStandardDeviation()
    {
        return (maxX - minX) / Math.sqrt(12);
    }

    public String getDescription()
    {
        return "Linear Distribution (F(x) = " + String.valueOf(slope) + "x + ("+ String.valueOf(intercept) + ") | Range X = " + minX + "..." + maxX + ")";
    }

    public boolean isDiscrete()
    {
        return true;
    }    
}
