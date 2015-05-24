package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}
import org.saddle.Frame

/**
 * Line, vertical.
 *
 * This geom allows you to annotate the plot with vertical lines (see [[hline]] and [[abline]] for other types of lines.
 *
 * There are two ways to use it.
 * You can either specify the intercept of the line in the call to the geom,
 * in which case the line will be in the same position in every panel.
 * Alternatively, you can supply a different intercept for each panel using a data frame.
 * See the examples for the differences.
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
 * @param show_guide     should a legend be drawn? (defaults to false)
 * @tparam T
 */
case class vline[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = vlineUtil.defaultStat,
                      position: Position = vlineUtil.defaultPos,
                      show_guide: Boolean = false) extends Geom

private object vlineUtil
{
   val defaultStat = stat.vline()
   val defaultPos = position.identity
}