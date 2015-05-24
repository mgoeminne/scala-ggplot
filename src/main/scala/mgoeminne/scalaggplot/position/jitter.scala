package mgoeminne.scalaggplot.position

/**
 * Jitters points to avoid overplotting.
 * @param width       degree of jitter in x direction. Defaults to 40% of the resolution of the data.
 * @param height      degree of jitter in y direction. Defaults to 40% of the resolution of the data.
 */
case class jitter(width: Double = 0.4,
                  height: Double = 0.4) extends Position
