package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, aes, position}
import org.saddle.Frame

/**
 * Hollow bar with middle indicated by horizontal line.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *  - '''ymin'''
 *  - '''ymax'''
 *  - alpha
 *  - colour
 *  - fill
 *  - lineType
 *  - size
 *
 *  == Examples ==
 *
 *  See [[linerange]] for examples.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param fatten    A multiplicate factor to fatten middle bar by.
 * @tparam T
 */
case class crossbar[T] ( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                         data: Option[Frame[Any,Any,T]] = None,
                         stat: Statistic = crossbarUtil.defaultStat,
                         position: Position = crossbarUtil.defaultPos,
                         fatten: Double = 2) extends Geom

private object crossbarUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}