package mgoeminne.scalaggplot.coord

/**
 * Transformed cartesian coordinate system.
 *
 * This system is different to scale transformations in that it occurs after statistical transformation
 * and will affect the visual appearance of geoms - there is no guarantee that straight lines will continue
 * to be straight.
 *
 * The difference between transforming the scales and
 * transforming the coordinate system is that scale
 * transformation occurs **before** statistics, and coordinate
 * transformation afterwards.  Coordinate transformation also
 * changes the shape of geoms.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param xtrans the transformation to apply to the x values
 * @param ytrans the transformation to apply to the y values
 * @param xlim   limits for the x axis.
 * @param ylim   limits for the y axis.
 */
case class trans(  xtrans: (Double => Double) = (x => x),
                   ytrans: (Double => Double) = (x => x),
                   xlim: Option[(Double, Double)] = None,
                   ylim: Option[(Double, Double)] = None) extends Coordinate

