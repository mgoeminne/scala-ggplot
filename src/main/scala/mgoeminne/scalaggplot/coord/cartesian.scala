package mgoeminne.scalaggplot.coord

/**
 * The Cartesian coordinate system is the most familiar, and common, type of coordinate system.
 * Setting limits on the coordinate system will zoom the plot (like you're looking at it with a magnifying glass),
 * and will not change the underlying data like setting limits on a scale will.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param xlim limits for the x axis.
 * @param ylim limits for the y axis.
 *
 */
case class cartesian(   xlim: Option[(Double, Double)] = None,
                        ylim: Option[(Double, Double)] = None
                       ) extends Coordinate
