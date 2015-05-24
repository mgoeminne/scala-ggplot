package mgoeminne

import mgoeminne.scalaggplot.aes.Aesthetic
import org.saddle.Frame

package object scalaggplot
{
   implicit def frameToRichDataFrame[A,B,C](df: Frame[A,B,C]) = new RichDataFrame(df)

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
    *  - ggplot(df, aes(x, y, ))
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
    * @param data
    * @tparam A
    * @tparam B
    * @tparam C
    */
   def ggplot[A,B,C](data: Frame[A,B,C]): Seq[GGElement] = ???

   def ggplot[A,B,C](data: Frame[A,B,C], aes: Aesthetic): Seq[GGElement] = ???


   def ggplot(): Seq[GGElement] = Seq.empty

   abstract implicit class RichSeq[A](s: Seq[A]) extends Seq[A]
   {
      def +(element: A) = this :+ element
   }
}

