package mgoeminne.scalaggplot.position

/**
 * Stacks overlapping objects on top of one another.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param width      Manually specify width (does not affect all position adjustments)
 * @param height     Manually specify height (does not affect all position adjustments)
 */
case class stack(width: Option[Double] = None,
                 height: Option[Double] = None) extends Position
