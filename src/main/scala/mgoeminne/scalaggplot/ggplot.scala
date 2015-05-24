package mgoeminne.scalaggplot

import mgoeminne.scalaggplot.aes.Aesthetic
import mgoeminne.scalaggplot.geom.Geom
import org.saddle.Frame

/**
 * Contains the information required to draw data.
 */
case class ggplot[A,B,C] private (data: Option[Frame[A,B,C]], aes: Seq[Aesthetic], geoms: Seq[Geom])
{
   /**
    * Adds a geometry to the list of geometries defined for this plot.
    * @param geom the geometry to add
    * @return a new ggplot, having the same properties than <i>this</i>, with the extra geometry.
    */
   def +(geom: Geom) = ggplot(data, aes, geoms :+ geom)

   /**
    * Adds an aesthetic to the list of aesthetics defined for this plot.
    * @param aes the aesthetic to add
    * @return a new ggplot, having the same properties than <i>this</i>, with the extra aesthetic.
    */
   def +(aes: Aesthetic) = ggplot(data, this.aes :+ aes, geoms)
}

/**
 * Initializes a ggplot object. It can be used to declare the input data frame
 * for a graphic and to specify the set of plot aesthetics intended to be common
 * throughout all subsequent layers unless specifically overridden.
 *
 * This function is typically used to construct a plot incrementally,
 * using the + operator to add layers to the existing ggplot object.
 * This is advantageous in that the code is explicit about which layers are added
 * and the order in which they are added. For complex graphics with multiple layers,
 * initialization with ggplot is recommended.
 *
 * There are three common ways to invoke ggplot:
 *
 *  - ggplot(df, aes("x", "y"))
 *  - ggplot(df)
 *  - ggplot()
 *
 * The first method is recommended if all layers use the same data and the same set of aesthetics,
 * although this method can also be used to add a layer using data from another data frame.
 * See the first example below.
 *
 * The second method specifies the default data frame to use for the plot,
 * but no aesthetics are defined up front. This is useful when one data frame is used predominantly as
 * layers are added, but the aesthetics may vary from one layer to another.
 *
 * The third method initializes a skeleton ggplot object which is fleshed out as layers are added.
 * This method is useful when multiple data frames are used to produce different layers,
 * as is often the case in complex graphics.
 *
 */
object ggplot
{
   def apply[A,B,C](): ggplot[A,B,C] = ggplot(None, Seq(), Seq())
   def apply[A,B,C](data: Frame[A,B,C]): ggplot[A,B,C] = ggplot(Some(data), Seq(), Seq())
   def apply[A,B,C](data: Frame[A,B,C], aes: Aesthetic): ggplot[A,B,C] = ggplot(Some(data), Seq(aes), Seq())
}
