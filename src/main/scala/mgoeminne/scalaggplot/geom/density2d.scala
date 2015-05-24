package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{aes, position, stat}

import org.saddle.Frame

/**
 * Contours from a 2d density estimate.
 *
 * Perform a 2D kernel density estimatation using kde2d and display the results with contours.
 * This can be useful for dealing with overplotting.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - colour
 *  - linetype
 *  - size
 *
 * == Examples ==
 *
 * See [[stat.density2d]] for examples.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param lineEnd   Line end style (round, butt, square)
 * @param lineJoin  Line join style (round, mitre, bevel)
 * @param lineMitre Line mitre limit (number greater than 1)
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @tparam T
 */
case class density2d[T] ( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                          data: Option[Frame[Any,Any,T]] = None,
                          stat: Statistic = density2dUtil.defaultStat,
                          position: Position = density2dUtil.defaultPos,
                          lineEnd: String = "butt",
                          lineJoin: String = "round",
                          lineMitre: Int = 1,
                          removeNA: Boolean = false) extends Geom

object density2dUtil
{
   val defaultStat = stat.density2d()
   val defaultPos  = position.identity
}