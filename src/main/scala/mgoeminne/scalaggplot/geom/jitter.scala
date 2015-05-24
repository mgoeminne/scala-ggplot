package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.position.Position
import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.stat

import mgoeminne.scalaggplot.position
import org.saddle.Frame

/**
 * Points, jittered to reduce overplotting.
 *
 * The Position.jitter geom is a convenient default for point with position = 'Position.jitter'.
 * See [[pos.jitter]] to see how to adjust amount of jittering.
 *
 * == Aesthetics
 *
 * This function understands the following aesthetics:
 *
 *  - '''[[aes.x]]'''
 *  - '''[[aes.y]]'''
 *  - [[aes.alpha]]
 *  - [[aes.colour]]
 *  - [[aes.fill]]
 *  - [[aes.shape]]
 *  - [[aes.size]]
 *
 * == Examples ==
 *
 * TODO
 *
 * @param mapping   The aesthetic mapping, usually constructed with [[mgoeminne.scalaggplot.aes.aes]] or [[mgoeminne.scalaggplot.aes.string]].
 *                  Only needs to be set at the layer level if you are overriding the plot defaults.
 * @param data      A layer specific dataset - only needed if you want to override the plot defaults.
 * @param stat      The statistical transformation to use on the data for this layer.
 * @param position  The position adjustment to use for overlappling points on this layer.
 * @param removeNA  If false (the default), removes missing values with a warning. If true, silently removes missing values.
 * @tparam T
 */
case class jitter[T](  mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                       data: Option[Frame[Any,Any,T]] = None,
                       stat: Statistic = jitterUtil.defaultStat,
                       position: Position = jitterUtil.defaultPos,
                       removeNA: Boolean = false) extends Geom

object jitterUtil
{
   val defaultStat = stat.identity
   val defaultPos = position.jitter()
}