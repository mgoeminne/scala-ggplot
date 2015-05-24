package mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.geom.Geom
import mgoeminne.scalaggplot.{position, geom, aes}

import mgoeminne.scalaggplot.position.Position
import org.saddle.Frame

/**
 * Calculates components of box and whisker plot.
 *
 * == Aesthetics
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *
 *  == Examples ==
 *
 *  See [[boxplot]] for examples.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param geom      The geometric object to use display the data.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @param coef      Length of the whiskers as multiple of IQR. Defaults to 1.5.
 * @tparam T
 * @return A data frame with additional columns: widthwidth of boxplot yminlower whisker = smallest observation greater than or equal
 *         to lower hinge - 1.5 * IQR lowerlower hinge, 25% quantile notchlowerlower edge of notch = median - 1.58 * IQR / sqrt(n) middlemedian,
 *         50% quantile notchupperupper edge of notch = median + 1.58 * IQR / sqrt(n) upperupper hinge, 75% quantile ymaxupper whisker = largest observation less than or equal
 *         to upper hinge + 1.5 * IQR
 *
 */
case class boxplot[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                       data: Option[Frame[Any,Any,T]] = None,
                       geom: Geom = boxplotUtil.defaultGeom,
                       position: Position = boxplotUtil.defaultPos,
                       removeNA: Boolean = false,
                       coef: Double = 1.5) extends Statistic

private object boxplotUtil
{
   val defaultGeom = new geom.boxplot()
   val defaultPos  = new position.dodge()
}