package mgoeminne.scalaggplot.scale

import javafx.geometry.HorizontalDirection

import mgoeminne.scalaggplot.aes.Aesthetic

/**
 * Legend guide.
 *
 * @param title   A character string or expression indicating a title of guide.
 *                If None, the title is not shown. By default (waiver), the name of the scale object or tha name specified
 *                in labs is used for the title.
 * @param titlePosition A character string indicating the position of a title. One of "top" (default for a vertical guide),
 *                      "bottom", "left" (default for a horizontal guide), or "right."
 * @param titleTheme    A theme object for rendering the title text. Usually the object of element_text is expected.
 *                      By default, the theme is specified by legend.title in theme or theme.
 * @param titleHJust    A number specifying horizontal justification of the title text.
 * @param titleVJust    A number specifying vertical justification of the title text.
 * @param label         If true, then the labels are drawn. Otherwise the labels are invisible.
 * @param labelPosition A character string indicating the position of a label.
 *                      One of "top", "bottom" (default for horizontal guide), "left", or "right"
 *                      (default for vertical guide).
 * @param labelTheme    A theme object for rendering the label text. Usually the object of element_text is expected.
 *                      By default, the theme is specified by legend.text in theme or theme.
 * @param labelHJust    A numeric specifying horizontal justification of the label text.
 * @param labelVJust    A numeric specifying vertical justification of the label text.
 * @param keyWidth      A numeric or a unit object specifying the width of the legend key.
 *                      Default value is legend.key.width or legend.key.size in theme or theme.
 * @param keyHeight     A numeric or a unit object specifying the height of the legend key.
 *                      Default value is legend.key.height or legend.key.size in theme or theme.
 * @param horizontalDirection    Indicates the direction of the guide. If true, the direction will be horizontal.
 *                               Otherwise, the direction will be vertical.
 * @param defaultUnit   A character string indicating unit for keywidth and keyheight.
 * @param overrideAES   A list specifying aesthetic parameters of legend key. See details and examples.
 * @param nrow          The desired number of rows of legends.
 * @param ncol          The desired number of column of legends.
 * @param byRow         If false (the default) the legend-matrix is filled by columns,
 *                      otherwise the legend-matrix is filled by rows.
 * @param reverse       If true the order of legends is reversed.
 * @param order         Positive integer less that 99 that specify the order of this guide in the multiple guides.
 *                      If 0 (default), the order is determined by a secret algorithm.
 */
case class legend(   title: Option[String] = None,
                     titlePosition: Option[String] = None,
                     titleTheme: Option[String] = None,
                     titleHJust: Option[Double] = None,
                     titleVJust: Option[Double] = None,
                     label: Boolean = true,
                     labelPosition: Option[String] = None,
                     labelTheme: Option[String] = None,
                     labelHJust: Option[Double] = None,
                     labelVJust: Option[Double] = None,
                     keyWidth: Option[Double] = None,
                     keyHeight: Option[Double] = None,
                     horizontalDirection: Option[Boolean] = None,
                     defaultUnit: String = "line",
                     overrideAES: Seq[Aesthetic] = Seq(),
                     nrow: Option[Int] = None,
                     ncol: Option[Int] = None,
                     byRow: Boolean = false,
                     reverse: Boolean = false,
                     order: Int = 0
                    ) extends Scale
{

}
