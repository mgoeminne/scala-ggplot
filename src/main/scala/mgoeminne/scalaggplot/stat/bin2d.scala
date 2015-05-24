package mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.geom.Geom
import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.{position, aes}

import org.saddle.Frame

/**
 * Counts number of observation in rectangular bins.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *  - fill
 *
 * == Examples ==
 *
 * TODO
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param geom      The geometric object to use display the data.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param bins      Numeric vector giving number of bins in both vertical and horizontal directions.
 *                  Set to 30 by default.
 * @param drop      If true, removes all cells with 0 counts.
 * @tparam T
 * @return
 */
case class bin2d[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                     data: Option[Frame[Any,Any,T]] = None,
                     geom: Option[Geom] = None,
                     position: Position = bin2dUtil.defaultPos,
                     bins: (Int,Int) = (30,30),
                     drop: Boolean = true) extends Statistic

private object bin2dUtil
{
   val defaultPos = position.identity
}
