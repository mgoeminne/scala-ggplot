package mgoeminne.scalaggplot

/**
 * A style for a line.
 * The names refer to the Gnuplot's shapes.
 */
object LineStyle extends Enumeration
{
   type LineStyle = Value
   val blank, solid, dashed, dotted, dotdash, longdash, twodash = Value

   /**
    * @param style A style to convert into Gnuplot's line style number
    * @return the integer value associated to gnuplot's line style.
    */
   def gnuplotValue(style: LineStyle) = LineStyle.values zip (Stream from 1) find(_._1 == style) map(_._2) get
}