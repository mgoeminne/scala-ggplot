package mgoeminne.scalaggplot

/**
 * Evaluates a sequence of commands to transform them to Gnuplot instructions
 */
object GnuPlotEvaluator
{
   def parse[A,B,C](g: ggplot[A,B,C]) =
   {
      println("Nb aes: " + g.aes.size)
      println("Nb geoms: " + g.geoms.size)
   }
}
