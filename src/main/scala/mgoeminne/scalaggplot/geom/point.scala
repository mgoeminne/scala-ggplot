package mgoeminne.scalaggplot.geom

import java.awt.Color

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.{aes, stat, position}
import org.saddle.Frame

/**
 * Points, as for a scatterplot.
 *
 * The point geom is used to create scatterplots.
 *
 * The scatterplot is useful for displaying the relationship between two continuous variables,
 * although it can also be used with one continuous and one categorical variable, or two categorical variables.
 * See [[jitter]] for possibilities.
 *
 * The bubblechart is a scatterplot with a third variable mapped to the size of points.
 * There are no special names for scatterplots where another variable is mapped to point shape or colour, however.
 *
 * The biggest potential problem with a scatterplot is overplotting: whenever you have more than a few points,
 * points may be plotted on top of one another. This can severely distort the visual appearance of the plot.
 * There is no one solution to this problem, but there are some techniques that can help.
 * You can add additional information with [[stat.smooth]], [[stat.quantile]] or [[stat.density2d]].
 * If you have few unique `x` values, [[boxplot]] may also be useful.
 * Alternatively, you can summarise the number of points at each location and display that in some way, using [[stat.sum]].
 * Another technique is to use transparent points, `point(alpha = 0.05)`.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics:
 *
 *  - '''x'''
 *  - '''y'''
 *  - alpha
 *  - colour
 *  - fill
 *  - shape
 *  - size
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
 * @param removeNA  If false (the default), removes missing values with a warning. If true silently removes missing values.
 * @param colour    The colour to associate to the points.
 * @param size       Size of the points
 * @tparam T
 */
case class point[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                      data: Option[Frame[Any,Any,T]] = None,
                      stat: Statistic = pointUtil.defaultStat,
                      position: Position = pointUtil.defaultPos,
                      removeNA: Boolean = false,
                      colour: Option[Color] = None,
                      size: Int = 3) extends Geom

private object pointUtil
{
   val defaultStat = stat.identity
   val defaultPos  = position.identity
}
