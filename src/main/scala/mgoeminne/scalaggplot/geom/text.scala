package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, position, aes}
import org.saddle.Frame

/**
 * Textual annotations.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics:
 *
 *  - '''label'''
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - angle
 *  - colour
 *  - family
 *  - fontface
 *  - hjust
 *  - lineheight
 *  - size
 *  - vjust
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
 * @param parse     If true, the labels will be parsed into expressions and displayed as described in ?plotmath
 * @tparam T
 */
case class text[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = textUtil.defaultStat,
                    position: Position = textUtil.defaultPos,
                    parse: Boolean = false) extends Geom

private object textUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}
