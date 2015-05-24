package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.{bindot, Statistic}
import mgoeminne.scalaggplot.{position, aes, stat}

import org.saddle.Frame

/**
 * Dot plot.
 *
 * In a dot plot, the width of a dot corresponds to the bin width (or maximum width, depending on the binning algorithm),
 * and dots are stacked, with each dot representing one observation.
 *
 * With dot-density binning, the bin positions are determined by the data and `binWidth`, which is the maximum width of each bin.
 * See Wilkinson (1999) for details on the dot-density binning algorithm.
 *
 * With histodot binning, the bins have fixed positions and fixed widths, much like a histogram.
 *
 * When binning along the x axis and stacking along the y axis, the numbers on y axis are not meaningful, due to technical limitations of ggplot2.
 * You can hide the y axis, as in one of the examples, or manually scale it to match the number of dots.
 *
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics (required aesthetics are in bold):
 *
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - colour
 *  - fill
 *
 * == Examples ==
 *
 * TODO
 *
 * == References
 *
 * Wilkinson, L. (1999) Dot plots. The American Statistician, 53(3), 276-281.
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[aes.aes]] or [[aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @param binWidth      When method is `dotdensity`, this specifies maximum bin width.
 *                      When method is `histodot`, this specifies bin width.
 *                      Defaults to 1/30 of the range of the data.
 * @param binAxis       which axis to bin along `x` (default) or `y`
 * @param method        `dotdensity` (default) for dot-density binning, or `histodot` for fixed bin widths (like `stat_bin`)
 * @param binPositions  When method is `dotdensity`, `bygroup` (default) determines positions of the bins for each group separately.
 *                      `all` determines positions of the bins with all the data taken together; this is used for aligning dot stacks across multiple groups.
 * @param stackDir      Which direction to [[mgoeminne.scalaggplot.position.stack]] the dots. `up` (default), `down`, `center`, `centerwhole` (centered, but with dots aligned)
 * @param stackRatio    How close to [[mgoeminne.scalaggplot.position.stack]] the dots. Default is 1, where dots just just touch.
 *                      Use smaller values for closer, overlapping dots.
 * @param dotSize       The diameter of the dots relative to `binWidth`, default 1.
 * @param stackGroups   should dots be stacked across groups?
 *                      This has the effect that `position = [[Position.stack]]` should have, but can't (because this geom has some odd properties).
 * @tparam T
 */
case class dotplot[T] (   mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                          data: Option[Frame[Any,Any,T]] = None,
                          stat: Statistic = dotplotUtil.defaultStat,
                          position: Position = dotplotUtil.defaultPosition,
                          removeNA: Boolean = false,
                          binWidth: Option[Double] = None,
                          binAxis: String = "x",
                          method: String = "dotdensity",
                          binPositions: String = "bygroup",
                          stackDir: String = "up",
                          stackRatio: Double = 1,
                          dotSize: Double = 1,
                          stackGroups: Boolean = false) extends Geom

private object dotplotUtil
{
   val defaultStat: Statistic = new bindot()
   val defaultPosition: Position = position.identity
}