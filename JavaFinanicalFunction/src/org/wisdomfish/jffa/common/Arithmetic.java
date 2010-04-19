/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.wisdomfish.jffa.common;

import java.math.BigDecimal;
import static java.math.BigDecimal.*;

/**
 *
 * @author WisdomFish.ORG
 */
public class Arithmetic {

    public static double PERCENT = 0.01;

    private Arithmetic() {}

    public static double add(double a, double b) {
        return valueOf(a).add(valueOf(b)).doubleValue();
    }

    public static double subtract(double a, double b) {
        return valueOf(a).subtract(valueOf(b)).doubleValue();
    }

    public static double multply(double a, double b) {
        return valueOf(a).multiply(valueOf(b)).doubleValue();
    }

    public static double divide(double a, double b) {
        return valueOf(a).divide(valueOf(b)).doubleValue();
    }

}
