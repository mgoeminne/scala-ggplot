package mgoeminne.scalaggplot.aes

import java.awt.Color

import mgoeminne.scalaggplot.Shape.Shape
import mgoeminne.scalaggplot.geom
import org.saddle.Series

/**
 * Generate aesthetic mappings that describe how variables
 * in the data are mapped to visual properties (aesthetics) of [[geom]]s.
 *
 * This function creates a list of unevaluated expressions. This function also performs partial name matching.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param x name of the column for the x dimension
 * @param y name of the column for the y dimension
 * @param group  An optional function associating rows to groups. By default all rows belong to the same group.
 * @param colour name of the column used for applying colours to the plot
 * @param shape  name of the column used for applying shapes to the plot
 */
case class aes[X,T,G]( x: String,
                     y: String,
                     group: Option[(Series[X,T] => G)] = None,
                     colour: Option[Color] = None,
                     shape: Option[Shape] = None) extends Aesthetic