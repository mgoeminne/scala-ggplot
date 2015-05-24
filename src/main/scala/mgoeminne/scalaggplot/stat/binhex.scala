package mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.position
import mgoeminne.scalaggplot.geom.Geom
import mgoeminne.scalaggplot.{aes, geom}
import mgoeminne.scalaggplot.position.Position
import org.saddle.Frame

/**
 * Bins 2d plane into hexagons.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *
 *  == Examples ==
 *
 *  TODO
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param geom      The geometric object to use display the data.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param bins      Numeric vector specifying number of bins in both x and y directions. Set to 30 by default.
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @tparam T
 * @return
 */
case class binhex[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                       data: Option[Frame[Any,Any,T]] = None,
                       geom: Geom = binhexUtil.defaultGeom,
                       position: Position = binhexUtil.defaultPos,
                       bins: Int = 30,
                       removeNA: Boolean = false) extends Statistic

private object binhexUtil
{
   val defaultGeom = new geom.hex()
   val defaultPos  = position.identity
}
