package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}
import org.saddle.Frame

/**
 * Adds heatmap of 2d bin counts.
 *
 * == Aesthetics ==
 *
 * This method understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''xmin'''
 *  - '''xmax'''
 *  - '''ymin'''
 *  - '''ymax'''
 *  - alpha
 *  - colour
 *  - fill
 *  - linetype
 *  - size
 *  - weight
 *
 * == Examples ==
 *
 * TODO
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer
 * @tparam T
 */
case class bin2d[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                     data: Option[Frame[Any,Any,T]] = None,
                     stat: Statistic = bin2dUtil.defaultStat,
                     position: Position = bin2dUtil.defaultPos)  extends Geom

private object bin2dUtil
{
   val defaultStat = stat.bin2d()
   val defaultPos = position.identity
}