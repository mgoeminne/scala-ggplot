package mgoeminne.scalaggplot.aes

import org.saddle.Frame

/**
 * Automatic aesthetic mapping.
 *
 * == Examples ==
 *
 * TODO
 *
 * @param data data frame or names of variables
 * @tparam T
 * @return
 */
case class auto[T](data: Frame[Any,Any,T]) extends Aesthetic