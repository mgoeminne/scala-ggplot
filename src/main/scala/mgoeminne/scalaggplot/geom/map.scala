package mgoeminne.scalaggplot.geom

import mgoeminne.scalaggplot.stat.Statistic
import mgoeminne.scalaggplot.stat

import org.saddle.Frame

/**
 * Polygons from a reference map.
 *
 * Does not affect position scales.
 *
 * == Aesthetics ==
 *
 * This function understands the following aesthetics:
 *
 *  - '''map_id'''
 *  - alpha
 *  - colour
 *  - fill
 *  - linetype
 *  - size
 *
 * == Examples ==
 *
 * TODO
 *
 * @param mapping
 * @param data
 * @param map
 * @param stat
 * @tparam T
 */
case class map[T]( mapping: Option[(Seq[Numeric[T]], Seq[Numeric[T]])] = None,
                   data: Option[Frame[Any,Any,T]] = None,
                   map: Frame[Any,Any,T],
                   stat: Statistic = mapUtil.defaultStat) extends Geom

private object mapUtil
{
   val defaultStat = stat.identity
}
