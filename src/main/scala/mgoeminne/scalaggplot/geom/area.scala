package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.{stack, Position}
import mgoeminne.scalaggplot.{position, aes, stat}
import mgoeminne.scalaggplot.stat.Statistic
import org.saddle.Frame


/**
 * Area plot.
 *
 * An area plot is the continuous analog of a stacked bar chart (see [[bar]]),
 * and can be used to show how composition of the whole varies over the range of x.
 * Choosing the order in which different components is stacked is very important,
 * as it becomes increasing hard to see the individual pattern as you move up the Position.stack.
 *
 * An area plot is a special case of [[ribbon]], where the minimum of the range is fixed to 0,
 * and the position adjustment defaults to position_stacked.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat     The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 */
case class area[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = areaUtil.defaultStat,
                    position: Position = areaUtil.defaultPosition,
                    removeNA: Boolean = false)  extends Geom

private object areaUtil
{
   val defaultPosition = position.stack()
   val defaultStat = stat.identity
}