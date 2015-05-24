package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}

import org.saddle.Frame

/**
 * Connects observations in original order.
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
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param lineEnd   Line end style (round, butt, square)
 * @param lineJoin      Line join style (round, mitre, bevel)
 * @param lineMitre     Line mitre limit (number greater than 1)
 * @param removeNA      If false (the default), removes missing values with a warning. If true silently removes missing values.
 * @param arrow     Arrow specification, as created by ?grid::arrow
 * @tparam T
 */
case class path[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    stat: Statistic = pathUtil.defaultStat,
                    position: Position = pathUtil.defaultPos,
                    lineEnd: String = "butt",
                    lineJoin: String = "round",
                    lineMitre: Int = 1,
                    removeNA: Boolean = false,
                    arrow: Boolean = false) extends Geom

private object pathUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}
