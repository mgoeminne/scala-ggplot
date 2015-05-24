package mgoeminne.scalaggplot.coord

/**
 * Map projections.
 *
 * This coordinate system provides the full range of map projections available XXX.
 *
 * TODO: replace projection type by a more adapted one.
 *
 * @param projection the projection to use
 * @param orientation projection orientation, which defaults to c(90, 0, mean(range(x))).
 *                    This is not optimal for many projections, so you will have to supply your own.
 * @param xlim manually specific x limits (in degrees of longitude)
 * @param ylim manually specific y limits (in degrees of latitude)
 */
case class map(   projection: String = "mercator",
                  orientation: Option[(Double, Double, Double)] = None,
                  xlim: Option[(Double, Double)] = None,
                  ylim: Option[(Double, Double)] = None
                 ) extends Coordinate
