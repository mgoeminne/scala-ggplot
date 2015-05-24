package mgoeminne.scalaggplot.geom

import java.awt.Color

import mgoeminne.scalaggplot.position.{stack, Position}
import mgoeminne.scalaggplot.{position, aes, stat}
import mgoeminne.scalaggplot.stat.{bin, Statistic}

import org.saddle.Frame

/**
 * Bars, rectangles with bases on x-axis.
 *
 * == Description ==
 *
 * The bar geom is used to produce 1d area plots: bar charts for categorical x, and histograms for continuous y.
 * [[stat.bin]] explains the details of these summaries in more detail. In particular, you can use the
 * [[aes.weight]] aesthetic to create weighted histograms and barcharts where the height of the bar
 * no longer represent a count of observations, but a sum over some other variable.
 *
 * See the examples for a practical example.
 *
 * == Details ==
 *
 * The heights of the bars commonly represent one of two things: either a count of cases in each group, or the values in a column of the data frame.
 * By default, [[bar]] uses `stat="bin"`. This makes the height of each bar equal to the number of cases in each group, and it is incompatible with mapping values to the `y` aesthetic.
 * If you want the heights of the bars to represent values in the data, use `stat=identity` and map a value to the y aesthetic.
 *
 * By default, multiple x's occuring in the same place will be stacked a top one another by [[position.stack]].
 * If you want them to be dodged from side-to-side, see [[position.dodge]]. Finally, [[position.fill]] shows relative proportions at each x by stacking the bars and then stretching or squashing to the same height.
 *
 * Sometimes, bar charts are used not as a distributional summary, but instead of a dotplot. Generally, it's preferable to use a dotplot (see [[point]]) as it has a better data-ink ratio.
 * However, if you do want to create this type of plot, you can set y to the value you have calculated, and use `stat='identity'`
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer
 * @param colour    The colour associated to the bar
 */
case class bar[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = barUtil.defaultStat,
                    position: Position = barUtil.defaultPos,
                    colour: Option[Color] = None)  extends Geom

private object barUtil
{
   val defaultStat = stat.bin()
   val defaultPos = position.stack()
}