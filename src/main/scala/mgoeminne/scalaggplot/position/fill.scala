package mgoeminne.scalaggplot.position

/**
 * Stacks overlapping objects on top of one another, and standardise to have equal height.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param width      Manually specify width (does not affect all position adjustments)
 * @param height     Manually specify height (does not affect all position adjustments)
 */
case class fill(width: Option[Double] = None,
                height: Option[Double] = None) extends Position
