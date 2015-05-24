package mgoeminne.scalaggplot.aes

import mgoeminne.scalaggplot.geom

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
 * @param colour name of the column used for applying colours to the plot
 * @param shape  name of the column used for applying shapes to the plot
 */
case class aes(x: String,
               y: String,
               colour: Option[String] = None,
               shape: Option[String] = None) extends Aesthetic