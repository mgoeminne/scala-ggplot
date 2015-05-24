package mgoeminne.scalaggplot

import org.saddle.{Vec, Frame}


/**
 * Created by mg on 21/05/15.
 */
object Test
{
   def main(args: Array[String])
   {
      val v = Vec(1, 2)                              // given the following
      val u = Vec(3, 4)

      val df = Frame("x" -> u, "y" -> v)
      val a = ggplot()
      val b = ggplot(df)
      val c = ggplot(df, aes.aes("x","y"))

      val d = b + aes.aes("x","y") + geom.point()

      GnuPlotEvaluator.parse(d)
      GnuPlotEvaluator.parse(c)
      GnuPlotEvaluator.parse(d)
   }
}
