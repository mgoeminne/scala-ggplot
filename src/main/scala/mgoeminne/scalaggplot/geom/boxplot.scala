package mgoeminne.scalaggplot.geom

import java.awt.Color

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{position, aes, stat}
import org.saddle.Frame

/**
 * Box and whiskers plot.
 *
 * The upper and lower "hinges" correspond to the first and third quartiles (the 25th and 75th percentiles).
 *
 *
 * == Details ==
 *
 * The upper whisker extends from the hinge to the highest value that is within 1.5 * IQR of the hinge, where IQR is the inter-quartile range, or distance between the first and third quartiles.
 * The lower whisker extends from the hinge to the lowest value within 1.5 * IQR of the hinge.
 * Data beyond the end of the whiskers are outliers and plotted as points (as specified by Tukey).
 *
 * In a notched box plot, the notches extend 1.58 * IQR / sqrt(n).
 * This gives a roughly 95 interval for comparing medians. See McGill et al. (1978) for more details.
 *
 * == References ==
 *
 * McGill, R., Tukey, J. W. and Larsen, W. A. (1978) Variations of box plots. The American Statistician 32, 12-16.
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
 * @param outlierColor  Colour for outlying points.
 * @param outlierShape  Shape of outlying points.
 * @param outlierSize   Size of outlying points.
 * @param notch     if false (default) make a standard box plot. If true, make a notched box plot.
 *                  Notches are used to compare groups; if the notches of two boxes do not overlap, this is strong evidence that the medians differ.
 * @param notchWidth    For a notched box plot, width of the notch relative to the body (default is 0.5).
 * @tparam T
 */
case class boxplot[T] (  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                         data: Option[Frame[Any,Any,T]] = None,
                         stat: Statistic = boxplotUtil.defaultStat,
                         position: Position = boxplotUtil.defaultPos,
                         outlierColor: Color = Color.BLACK,
                         outlierShape: Int = 16,
                         outlierSize: Int = 2,
                         notch: Boolean = false,
                         notchWidth: Double = 0.5f) extends Geom

private object boxplotUtil
{
   val defaultStat = stat.boxplot()
   val defaultPos = position.dodge()
}