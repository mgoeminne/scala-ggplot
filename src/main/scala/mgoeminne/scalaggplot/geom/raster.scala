package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{stat, position, aes}
import org.saddle.Frame

/**
 * High-performance rectangular tiling.
 *
 * This is a special case of [[tile]] where all tiles are the same size.
 * This function may provide improved performance.
 *
 * By default, this function adds a vertical and horizontal padding.
 * The size of padding depends on the resolution of data.
 * If you want to manually set the padding (e.g. want zero-padding), you can change the behavior by setting hpad and vpad.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics:
 *
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - fill
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
 * @param hjust     Horizontal justification of the grob. Should be a number between 0 and 1. Defaults to 0.5.
 * @param vjust     Vertical justification of the grob. Should be a number between 0 and 1. Defaults to 0.5.
 * @param interpolate   If true, interpolates linearly, otherwise doesn't interpolate.
 * @tparam T
 */
case class raster[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = rasterUtil.defaultStat,
                      position: Position = rasterUtil.defaultPos,
                      hjust: Double = 0.5,
                      vjust: Double = 0.5,
                      interpolate: Boolean = false) extends Geom

private object rasterUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}