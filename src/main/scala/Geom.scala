import java.awt.Color

import org.saddle.Frame

/**
 * Contains the geom functions.
 */



object Geom
{
  /**
   * Creates a list of unevaluated expressions.
   * This function also performs partial name matching.
   * @param x x value
   * @param y y value
   */
   def aes(x: String, y: String): (List[Any], List[Any]) = ???

  /**
   * Line specified by slope and intercept.
   * @param mapping The aesthetic mapping, usually constructed with [[Aesthetic.aes]] or [[Aesthetic.aes_string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
   * @param data A layer specific dataset - only needed if you want to override the plot defaults.
   * @param stat The statistical transformation to use on the data for this layer.
   * @param position The position adjustment to use for overlappling points on this layer
   * @return
   */
   def geom_abline[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])],
                    data: Option[Frame[Any,Any,Any]],
                    stat: String = "abline",
                    position: String = "identity") = ???


  /**
   * Area plot.
   *
   * An area plot is the continuous analog of a stacked bar chart (see [[geom_bar]]), and can be used to show how composition of the whole varies over the range of x.
   * Choosing the order in which different components is stacked is very important, as it becomes increasing hard to see the individual pattern as you move up the stack.
   *
   * An area plot is a special case of [[geom_ribbon]], where the minimum of the range is fixed to 0, and the position adjustment defaults to position_stacked.
   *
   * @param mapping   The aesthetic mapping, usually constructed with [[Aesthetic.aes]] or [[Aesthetic.aes_string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
   * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
   * @param stat     The statistical transformation to use on the data for this layer.
   * @param position  The position adjustment to use for overlappling points on this layer
   * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
   * @return
   */
   def geom_area[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])],
                  data: Option[Frame[Any,Any,Any]],
                  stat: String = "identity",
                  position: String = "stack",
                  removeNA: Boolean = false) = ???


  /**
   * Bars, rectangles with bases on x-axis.
   *
   * == Description
   *
   * The bar geom is used to produce 1d area plots: bar charts for categorical x, and histograms for continuous y.
   * [[stat_bin]] explains the details of these summaries in more detail. In particular, you can use the [[Aesthetic.weight]] aesthetic to create weighted histograms and barcharts where the height of the bar no longer represent a count of observations, but a sum over some other variable.
   * See the examples for a practical example.
   *
   * == Details
   *
   * The heights of the bars commonly represent one of two things: either a count of cases in each group, or the values in a column of the data frame.
   * By default, [[geom_bar]] uses `stat="bin"`. This makes the height of each bar equal to the number of cases in each group, and it is incompatible with mapping values to the `y` aesthetic.
   * If you want the heights of the bars to represent values in the data, use `stat="identity"` and map a value to the y aesthetic.
   *
   * By default, multiple x's occuring in the same place will be stacked a top one another by position_stack.
   * If you want them to be dodged from side-to-side, see [[position_dodge]]. Finally, [[position_fill]] shows relative proportions at each x by stacking the bars and then stretching or squashing to the same height.
   *
   * Sometimes, bar charts are used not as a distributional summary, but instead of a dotplot. Generally, it's preferable to use a dotplot (see [[geom_point]]) as it has a better data-ink ratio.
   * However, if you do want to create this type of plot, you can set y to the value you have calculated, and use `stat='identity'`
   *
   * @param mapping   The aesthetic mapping, usually constructed with [[Aesthetic.aes]] or [[Aesthetic.aes_string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
   * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
   * @param stat      The statistical transformation to use on the data for this layer.
   * @param position  The position adjustment to use for overlappling points on this layer
   * @return
   */
  def geom_bar[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])],
                data: Option[Frame[Any,Any,Any]],
                stat: String = "bin",
                position: String = "stack") = ???

  /**
   * Adds heatmap of 2d bin counts.
   *
   * == Aesthetics
   *
   * This method understands the following aesthetics (required aesthetics are in bold):
   *
   *  - '''[[Aesthetic.xmin]]'''
   *  - '''[[Aesthetic.xmax]]'''
   *  - '''[[Aesthetic.ymin]]'''
   *  - '''[[Aesthetic.ymax]]'''
   *  - [[Aesthetic.alpha]]
   *  - [[Aesthetic.colour]]
   *  - [[Aesthetic.fill]]
   *  - [[Aesthetic.linetype]]
   *  - [[Aesthetic.size]]
   *  - [[Aesthetic.weight]]
   *
   * == Examples
   *
   * TODO
   *
   * @param mapping   The aesthetic mapping, usually constructed with [[Aesthetic.aes]] or [[Aesthetic.aes_string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
   * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
   * @param stat      The statistical transformation to use on the data for this layer.
   * @param position  The position adjustment to use for overlappling points on this layer
   * @tparam T
   * @return
   */
  def geom_bin2d[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])],
                     data: Option[Frame[Any,Any,Any]],
                     stat: String = "bin2d",
                     position: String = "identity" ) = ???


  /**
   * Blank, draws nothing.
   *
   * The blank geom draws nothing, but can be a useful way of ensuring common scales between different plots.
   *
   * == Examples
   *
   * TODO
   *
   *
   * @param mapping   The aesthetic mapping, usually constructed with [[Aesthetic.aes]] or [[Aesthetic.aes_string]]. Only needs to be set at the layer level if you are overriding the plot defaults.
   * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
   * @param stat      The statistical transformation to use on the data for this layer.
   * @param position  The position adjustment to use for overlappling points on this layer
   * @tparam T
   * @return
   */
  def geom_blank[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])],
                      data: Option[Frame[Any,Any,Any]],
                      stat: String = "identity",
                      position: String = "identity" ) = ???

  /**
   * Box and whiskers plot.
   *
   * The upper and lower "hinges" correspond to the first and third quartiles (the 25th and 75th percentiles).
   *
   *
   * == Details
   *
   * The upper whisker extends from the hinge to the highest value that is within 1.5 * IQR of the hinge, where IQR is the inter-quartile range, or distance between the first and third quartiles.
   * The lower whisker extends from the hinge to the lowest value within 1.5 * IQR of the hinge.
   * Data beyond the end of the whiskers are outliers and plotted as points (as specified by Tukey).
   *
   * In a notched box plot, the notches extend 1.58 * IQR / sqrt(n).
   * This gives a roughly 95 interval for comparing medians. See McGill et al. (1978) for more details.
   *
   * == References
   *
   * McGill, R., Tukey, J. W. and Larsen, W. A. (1978) Variations of box plots. The American Statistician 32, 12-16.
   *
   * == Examples
   *
   * TODO
   *
   * @param mapping   The aesthetic mapping, usually constructed with [[Aesthetic.aes]] or [[Aesthetic.aes_string]].
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
   * @return
   */
  def geom_boxplot[T] (  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])],
                         data: Option[Frame[Any,Any,Any]],
                         stat: String = "boxplot",
                         position: String = "dodge",
                         outlierColor: Color = Color.BLACK,
                         outlierShape: Int = 16,
                         outlierSize: Int = 2,
                         notch: Boolean = false,
                         notchWidth: Float = 0.5f) = ???


}
