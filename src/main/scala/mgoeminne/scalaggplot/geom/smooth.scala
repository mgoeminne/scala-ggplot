package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, aes, position}
import org.saddle.Frame

/**
 * Adds a smoothed conditional mean.
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
 * @tparam T
 */
case class smooth[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = smoothUtil.defaultStat,
                      position: Position = smoothUtil.defaultPos) extends Geom

private object smoothUtil
{
   val defaultStat = stat.smooth()
   val defaultPos  = position.identity
}