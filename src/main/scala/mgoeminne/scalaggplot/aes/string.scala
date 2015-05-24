package mgoeminne.scalaggplot.aes

/**
 * Generates aesthetic mappings from a string.
 *
 * Aesthetic mappings describe how variables in the data are mapped to visual properties (aesthetics) of geoms.
 * Compared to [[aes]], this function operates on strings rather than expressions.
 *
 * This function is particularly useful when writing functions that create plots because you can use
 * strings to define the aesthetic mappings, rather than having to mess around with expressions.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param data     List of name value pairs
 */
case class string(data: List[(String,String)]) extends Aesthetic
