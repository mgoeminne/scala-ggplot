package mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.position
import mgoeminne.scalaggplot.geom.{area, Geom}
import mgoeminne.scalaggplot.{aes, geom}
import mgoeminne.scalaggplot.position.{stack, Position}
import org.saddle.Frame

/**
 * 1d kernel density estimate.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - fill
 *  - y
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
 * @param adjust    See density for details.
 * @param kernel    Kernel used for density estimation, see density for details
 * @param trim      If true, the default, densities are trimmed to the actual range of the data.
 *                  If false, they are extended by the default 3 bandwidths (as specified by the cut parameter to density).
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @tparam T
 * @return  data.frame with additional columns: densitydensity estimate countdensity * number of points - useful for
 *          stacked density plots scaleddensity estimate, scaled to maximum of 1.
 */
case class density[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                       data: Option[Frame[Any,Any,T]] = None,
                       geom: Geom = densityUtil.defaultGeom,
                       position: Position = densityUtil.defaultPos,
                       adjust: Double = 1,
                       kernel: String = "gaussian",
                       trim: Boolean = false,
                       removeNA: Boolean = false) extends Statistic

private object densityUtil
{
   val defaultGeom = new geom.area()
   val defaultPos  = new position.stack()
}