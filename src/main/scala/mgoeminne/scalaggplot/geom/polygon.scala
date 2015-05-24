package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, position, aes}
import org.saddle.Frame

/**
 * Polygon, a filled path.
 *
 * == Aesthetics
 *
 * This function understands the following aesthetics:
 *
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - colour
 *  - fill
 *  - linetype
 *  - size
 *
 * == Examples ==
 *
 * TODO
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @tparam T
 */
case class polygon[T](   mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                         data: Option[Frame[Any,Any,T]] = None,
                         stat: Statistic = polygonUtil.defaultStat,
                         position: Position = polygonUtil.defaultPos) extends Geom

private object polygonUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}
