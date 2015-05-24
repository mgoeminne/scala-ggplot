package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}
import org.saddle.Frame

/**
 * Single line segments.
 *
 * == Aesthetics
 *
 * This function understands the following aesthetics:
 *
 *  - '''x'''
 *  - '''xend'''
 *  - '''y'''
 *  - '''yend'''
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
 * @param arrow     Specification for arrow heads, as created by arrow().
 * @param lineEnd   Line end style (round, butt, square)
 * @param removeNA  If false (the default), removes missing values with a warning. If true silently removes missing values.
 * @tparam T
 */
case class segment[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                        data: Option[Frame[Any,Any,T]] = None,
                        stat: Statistic = segmentUtil.defaultStat,
                        position: Position = segmentUtil.defaultPos,
                        arrow: Option[Arrow] = None,
                        lineEnd: String = "butt",
                        removeNA: Boolean = false) extends Geom

private object segmentUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}