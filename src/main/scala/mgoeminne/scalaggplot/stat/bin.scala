package mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.geom.{bar, Geom}
import mgoeminne.scalaggplot.{geom, aes, position}


import mgoeminne.scalaggplot.position.{stack, Position}
import org.saddle.Frame


/**
 * Bins data.
 *
 * Divides continuous range into bins, and count number of points in each.
 *
 * New data frame with additional columns: countnumber of points in bin densitydensity of points in bin,
 * scaled to integrate to 1 ncountcount,
 * scaled to maximum of 1 ndensitydensity,
 * scaled to maximum of 1
 *
 * Missing values are currently silently dropped.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
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
 * @param width     Width of bars when used with categorical data.
 * @param drop      If true, remove all bins with zero counts.
 * @param right     If true, right-closed, left-open.
 * @param binWidth  Bin width to use. Defaults to 1/30 of the range of the data.
 * @param origin    Origin of first bin.
 * @param breaks    Actual breaks to use. Overrides bin width and origin.
 * @tparam T
 * @return
 */

case class bin[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                    data: Option[Frame[Any,Any,T]] = None,
                    geom: Geom = binUtil.defaultGeom,
                    position: Position = binUtil.defaultPos,
                    width: Double = 0.9,
                    drop: Boolean = false,
                    right: Boolean = false,
                    binWidth: Option[Double] = None,
                    origin: Option[Any] = None,
                    breaks: Option[Any] = None) extends Statistic

private object binUtil
{
   val defaultGeom = new geom.bar()
   val defaultPos  = position.stack()
}