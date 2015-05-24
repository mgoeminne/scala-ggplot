package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.position
import org.saddle.Frame

/**
 * Histogram
 *
 * This function is an alias for bar plus stat_bin so you will need to look at the documentation
 * for those objects to get more information about the parameters.
 *
 * By default, [[stat.bin]] uses 30 bins -- this is not a good default,
 * but the idea is to get you experimenting with different binwidths.
 * You may need to look at a few to uncover the full story behind your data.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''[[aes.x]]'''
 *  - [[aes.alpha]]
 *  - [[aes.colour]]
 *  - [[aes.fill]]
 *  - [[aes.linetype]]
 *  - [[aes.size]]
 *  - [[aes.weight]]
 *
 * == Examples ==
 *
 * TODO
 *
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[mgoeminne.scalaggplot.aes.aes]] or [[mgoeminne.scalaggplot.aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @tparam T
 */
case class histogram[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                          data: Option[Frame[Any,Any,T]] = None,
                          stat: Statistic = histogramUtil.defaultStat,
                          position: Position = histogramUtil.defaultPos) extends Geom


private object histogramUtil
{
   val defaultStat = stat.bin()
   val defaultPos  = position.stack()
}