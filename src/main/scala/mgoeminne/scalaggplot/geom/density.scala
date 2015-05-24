package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, stat, aes}
import org.saddle.Frame

/**
 * Displays a smooth density estimate calculated by [[stat.density]].
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - ''.x]]''
 *  - '''y]]'''
 *  - alpha
 *  - colour
 *  - fill
 *  - linetype
 *  - size
 *  - weight
 *
 * == Examples ==
 *
 * See [[stat.density]] for examples
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @tparam T
 */
case class density[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                       data: Option[Frame[Any,Any,T]] = None,
                       stat: Statistic = densityUtil.defaultStat,
                       position: Position = densityUtil.defaultPos,
                       removeNA: Boolean = false) extends Geom

private object densityUtil
{
   val defaultStat = stat.density()
   val defaultPos = position.identity
}