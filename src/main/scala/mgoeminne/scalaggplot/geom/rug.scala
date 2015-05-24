package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}
import org.saddle.Frame

/**
 * Marginal rug plots.
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
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param sides     A string that controls which sides of the plot the rugs appear on.
 *                  It can be set to a string containing any of "trbl", for top, right, bottom, and left.
 * @tparam T
 */
case class rug[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = rugUtil.defaultStat,
                    position: Position = rugUtil.defaultPos,
                    sides: String = "bl") extends Geom

private object rugUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}