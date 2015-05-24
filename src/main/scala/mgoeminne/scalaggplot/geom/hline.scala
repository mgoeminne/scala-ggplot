package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{geom, position, aes, stat}
import org.saddle.Frame

/**
 * Horizontal line
 *
 * This geom allows you to annotate the plot with horizontal lines
 * (see [[geom.vline]] and [[geom.abline]] for other types of lines).
 *
 * There are two ways to use it. You can either specify the intercept of the line in the call to the geom,
 * in which case the line will be in the same position in every panel.
 * Alternatively, you can supply a different intercept for each panel using a data.frame.
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
 * @param showGuide should a legend be drawn? (defaults to false)
 * @tparam T
 */
case class hline[T](   mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                data: Option[Frame[Any,Any,T]] = None,
                stat: Statistic = hlineUtil.defaultStat,
                position: Position = hlineUtil.defaultPos,
                showGuide: Boolean = false) extends Geom

private object hlineUtil
{
   val defaultStat = stat.hline()
   val defaultPos  = position.identity
}