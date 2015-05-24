package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.{dodge, Position}
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, aes, position}
import org.saddle.Frame

/**
 * Violin plot.
 *
 * == Aesthetics ==
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
 *  - weight
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
 * @param trim      If true (default), trim the tails of the violins to the range of the data. If false, don't trim the tails.
 * @param scale     if "area" (default), all violins have the same area (before trimming the tails).
 *                  If "count", areas are scaled proportionally to the number of observations.
 *                  If "width", all violins have the same maximum width.
 * @tparam T
 */
case class violin[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = violinUtil.defaultStat,
                      position: Position = violinUtil.defaultPos,
                      trim: Boolean = true,
                      scale: String = "area") extends Geom

private object violinUtil
{
   val defaultStat = stat.density()
   val defaultPos  = position.dodge()
}