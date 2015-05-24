package mgoeminne.scalaggplot.geom

import java.awt.Color

import mgoeminne.scalaggplot.LineStyle.LineStyle
import mgoeminne.scalaggplot.LineStyle.LineStyle
import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{LineStyle, aes, position, stat}
import org.saddle.Frame

/**
 * Connects observations, ordered by x value.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics:
 *
 *  - '''x'''
 *  - '''y'''
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
 * @param style      the line style.
 * @param colour     the colour of the line
 * @tparam T
 */
case class line[T](   mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = lineUtil.defaultStat,
                      position: Position = lineUtil.defaultPos,
                      style: LineStyle = LineStyle.solid,
                      colour: Color = Color.black) extends Geom

private object lineUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}