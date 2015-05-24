package mgoeminne.scalaggplot.coord

/**
 * Cartesian coordinates with fixed relationship between x and y scales.
 *
 * A fixed scale coordinate system forces a specified ratio between the physical representation of data units on the axes.
 * The ratio represents the number of units on the y-axis equivalent to one unit on the x-axis.
 * The default, ratio = 1, ensures that one unit on the x-axis is the same length as one unit on the y-axis.
 * Ratios higher than one make units on the y axis longer than units on the x-axis, and *vice versa*.
 * This is similar to eqscplot, but it works for all types of graphics.
 *
 * == Examples ==
 *
 * TODO
 */
case class fixed(ratio: Double = 1,
            xlim: Option[(Double, Double)] = None,
            ylim: Option[(Double, Double)] = None) extends Coordinate
