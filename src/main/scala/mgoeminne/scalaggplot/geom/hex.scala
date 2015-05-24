package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}
import org.saddle.Frame

/**
 * Hexagon bining.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - colour
 *  - fill
 *  - size
 *
 * == Examples ==
 *
 * See [[mgoeminne.scalaggplot.stat.binhex]] for examples.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @tparam T
 */
case class hex[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = hexUtil.defaultStat,
                    position: Position = hexUtil.defaultPos) extends Geom

private object hexUtil
{
   val defaultStat = stat.binhex()
   val defaultPos  = position.identity
}
