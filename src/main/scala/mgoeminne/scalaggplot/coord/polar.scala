package mgoeminne.scalaggplot.coord

/**
 * Polar coordinates.
 *
 * The polar coordinate system is most commonly used for pie charts, which are a stacked bar chart in polar coordinates.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param thetaFromX determines if the variable to map to angle must be x, or y. If true, x is used.
 * @param start      offset of starting point from 12 o'clock in radians
 * @param clockwiseDirection if true, corresponds to clockwise; corresponds to anti-clockwise otherwise.
 *
 */
case class polar(  thetaFromX: Boolean = true,
                   start:Double = 0,
                   clockwiseDirection: Boolean = true) extends Coordinate
