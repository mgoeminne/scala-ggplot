package mgoeminne.scalaggplot.coord

/**
 * Flipped cartesian coordinates.
 *
 * Flipped cartesian coordinates so that horizontal becomes vertical, and vertical, horizontal.
 * This is primarily useful for converting geoms and statistics which display y conditional on x, to x conditional on y.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param xlim limits for the x axis.
 * @param ylim limits for the y axis.
 */
case class flip(  xlim: Option[(Double, Double)],
                  ylim: Option[(Double, Double)] ) extends Coordinate

