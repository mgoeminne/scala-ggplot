package mgoeminne.scalaggplot.position

/**
 * Adjusts position by dodging overlaps to the side.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param width      Manually specify width (does not affect all position adjustments)
 * @param height     Manually specify height (does not affect all position adjustments)
 */
case class dodge(width: Option[Double] = None,
                 height: Option[Double] = None) extends Position