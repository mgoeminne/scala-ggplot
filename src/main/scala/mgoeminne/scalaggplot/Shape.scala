package mgoeminne.scalaggplot

/**
 * A shape that can be displayed as point or line end.
 * The names refer to the Gnuplot's shapes.
 */
object Shape extends Enumeration {
   type Shape = Value
   val Plus,
   Cross,
   Star,
   Box,
   BoxF,
   Circle,
   CircleF,
   TriangleUp,
   TriangleF,
   TriangleUpF,
   TriangleDown,
   TriangleDownF,
   Diamond,
   DiamongF,
   Pentagone,
   PentagoneF,
   C0,
   C1,
   C2,
   C3,
   C4,
   C5,
   C6,
   C7,
   C8,
   C9,
   C10,
   C11,
   C12,
   C13,
   C14,
   C15,
   S0,
   S1,
   S2,
   S3,
   S4,
   S5,
   S6,
   S7,
   S8,
   S9,
   S10,
   S11,
   S12,
   S13,
   S14,
   S15,
   D0,
   D1,
   D2,
   D3,
   D4,
   D5,
   D6,
   D7,
   D8,
   D9,
   D10,
   D11,
   D12,
   D13,
   D14,
   D15 = Value

   /**
    * @param shape A shape to convert into Gnuplot's shape number
    * @return the integer value associated to gnuplot's shape.
    */
   def gnuplotValue(shape: Shape) = Shape.values zip (Stream from 1) find(_._1 == shape) map(_._2) get
}
