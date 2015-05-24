package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, aes, position}
import org.saddle.Frame

/**
 * Connects observations by stairs.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics:
 *
 *  - alpha
 *  - colour
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
 * @param direction Direction of stairs: 'vh' for vertical then horizontal, or 'hv' for horizontal then vertical
 * @tparam T
 */
case class step[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = stepUtil.defaultStat,
                    position: Position = stepUtil.defaultPos,
                    direction: String = "hv") extends Geom

private object stepUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}
