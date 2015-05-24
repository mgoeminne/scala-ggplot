package mgoeminne.scalaggplot

/**
 * Evaluates a sequence of commands to transform them to Gnuplot instructions.
 *
 * http://byrneslab.net/classes/biol607/readings/wickham_layered-grammar.pdf
 */
object GnuPlotEvaluator
{
   def parse[A,B,C](g: ggplot[A,B,C]) =
   {
      // 1 - Geometric objects
      // 2 - Scales and coordinate system
      // 3 - plot annotations (title, axis labels, etc).
   }
}
