package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.{stack, Position}
import mgoeminne.scalaggplot.stat.{stat_abline, Statistic}
import mgoeminne.scalaggplot.{stat, aes, position}
import org.saddle.Frame

/**
 * Line specified by slope and intercept.
 *
 * The abline geom adds a line with specified slope and intercept to the plot.
 *
 * With its siblings [[hline]] and [[vline]], it's useful for annotating plots.
 * You can supply the parameters for this function, intercept and slope, in two ways:
 * either explicitly as fixed values, or in a data frame.
 * If you specify the fixed values (abline(intercept=0, slope=1)) then the line will be the same in all panels.
 * If the intercept and slope are stored in the data, then they can vary from panel to panel.
 * See the examples for more ideas.
 *
 * == Aesthetics ==
 *
 * This method understands the following aesthetics (required aesthetics are in bold):
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
 * @param stat     The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param show_guide Should a legend be drawn? (defaults to false)
 */
case class abline[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = null,
                      position: Position = ablineUtil.defaultPosition,
                      show_guide: Boolean = false) extends Geom
{
}


private object ablineUtil
{
   val defaultPosition = position.stack()
}