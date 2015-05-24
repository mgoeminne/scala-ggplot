package mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.position
import mgoeminne.scalaggplot.geom.Geom
import mgoeminne.scalaggplot.{stat, aes, geom}

import mgoeminne.scalaggplot.position.Position
import org.saddle.Frame

/**
 * Bins data for dot plot.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param geom      The geometric object to use display the data.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param binWidth  When method is "dotdensity", this specifies maximum bin width.
 *                  When method is "histodot", this specifies bin width.
 *                  Defaults to 1/30 of the range of the data.
 * @param origin    When method is "histodot", origin of first bin.
 * @param width     When binaxis is "y", the spacing of the dot stacks for dodging.
 * @param binAxis   The axis to bin along, "x" (default) or "y"
 * @param method    "dotdensity" (default) for dot-density binning, or "histodot" for fixed bin widths (like [[stat.bin]])
 * @param binPositions  When method is "dotdensity", "bygroup" (default) determines positions of the bins for each group separately.
 *                      "all" determines positions of the bins with all the data taken together;
 *                      this is used for aligning dot stacks across multiple groups.
 * @param drop      If true, remove all bins with zero counts.
 * @param right     When method is "histodot", should intervals be closed on the right (a, b], or not [a, b).
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @tparam T
 * @return
 */
case class bindot[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                       data: Option[Frame[Any,Any,T]] = None,
                       geom: Geom = bindotUtil.defaultGeom,
                       position: Position = bindotUtil.defaultPos,
                       binWidth: Option[Double] = None,
                       origin: Option[Any] = None,
                       width: Double = 0.9,
                       binAxis: Char = 'x',
                       method: String = "dotdensity",
                       binPositions: String = "bygroup",
                       drop: Boolean = false,
                       right: Boolean = true,
                       removeNA: Boolean = false) extends Statistic

private object bindotUtil
{
   val defaultGeom = new geom.dotplot()
   val defaultPos  = position.identity
}
