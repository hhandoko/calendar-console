/**
 * File     : CalApp.scala
 * Author   : Herdy Handoko
 * Created  : 2015/08/18
 * License  :
 *   Copyright (c) 2015 Herdy Handoko
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
import org.joda.time.DateTime

/**
 * Pretty-print a calendar given a calendar month and year into the console.
 */
class CalApp extends Output {

  /**
   * Pretty-print a calendar to the console.
   *
   * @param yearInput the input year, defaults to the current year.
   * @param monthInput the selected month, defaults to the current month.
   */
  def cal(yearInput: Int = DateTime.now().year().get(), monthInput: Int = DateTime.now().monthOfYear().get()) = {

    // Get the selected year and month as a Joda Time DateTime property
    val selectedDate = new DateTime(yearInput, monthInput, 1, 0, 0)

    // Get the prefix range to push the first day of the month under the correct
    // weekday heading
    val prefixTotal = selectedDate.dayOfMonth().withMinimumValue().dayOfWeek().get()
    val prefixRange = List.fill(prefixTotal)(" ")

    // Get the last day of the month (e.g. 28, 29, 30, 31 days),
    // and build the list of days as a List range
    val lastDayOfTheMonth = selectedDate.dayOfMonth().withMaximumValue().getDayOfMonth
    val calendarDateRange = 1 to lastDayOfTheMonth

    // Merge prefix and date range to get a full calendar entries
    val calendarEntries = (prefixRange ++ calendarDateRange.map(_.toString)).grouped(7)

    // Get the calendar heading variables
    val calendarHeading = s"${selectedDate.monthOfYear().getAsText()} ${selectedDate.year().get()}"
    val weekdaysHeading = Array("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").mkString(" ")

    // Print the calendar and weekdays heading
    print(calendarHeading)
    print(weekdaysHeading)

    // Print the calendar entries
    calendarEntries.foreach { week => print(prettyPrint(week)) }
  }

  /**
   * Left pad a string to a certain length with a given character.
   *
   * @param input the input string.
   * @param length the padded string length.
   * @param padChar the padding character.
   * @return the left-padded string.
   */
  private def padLeft(input: String, length: Int, padChar: Char): String = {
    input.reverse.padTo(length, padChar).reverse
  }

  /**
   * Get pretty-printed week entry (i.e. padded and aligned).
   *
   * @param weekEntry the week entry.
   * @return the pretty-printed week-entry.
   */
  private def prettyPrint(weekEntry: Seq[String]): String = {
    weekEntry.map(padLeft(_, 3, ' ')).mkString(" ")
  }

}

/**
 * The calendar app console runner.
 */
object CalApp extends App {

  new CalApp().cal()

}