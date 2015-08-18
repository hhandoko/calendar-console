/**
 * File     : CalAppSpec.scala
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
import org.scalatest.FlatSpec

/**
 * CalApp test cases.
 */
class CalAppSpec extends FlatSpec
  with SeqLoggedOutput {

  "CalApp" should "print the current month (August 2015) in the expected output" in {
    // Arrange
    val augustOutput =
      """
        |August 2015
        |Sun Mon Tue Wed Thu Fri Sat
        |                          1
        |  2   3   4   5   6   7   8
        |  9  10  11  12  13  14  15
        | 16  17  18  19  20  21  22
        | 23  24  25  26  27  28  29
        | 30  31
      """.stripMargin.trim
    val app = new CalApp with SeqLoggedOutput

    // Act
    app.cal()
    val output = app.messages.mkString("\r\n")

    // Assert
    assert(output contains augustOutput)
  }

  it should "print the expected output given a calendar month using the default year (2015)" in {
    // Arrange
    val septemberOutput =
      """
        |September 2015
        |Sun Mon Tue Wed Thu Fri Sat
        |          1   2   3   4   5
        |  6   7   8   9  10  11  12
        | 13  14  15  16  17  18  19
        | 20  21  22  23  24  25  26
        | 27  28  29  30
      """.stripMargin.trim
    val app = new CalApp with SeqLoggedOutput

    // Act
    app.cal(monthInput = 9)
    val output = app.messages.mkString("\r\n")

    // Assert
    assert(output contains septemberOutput)
  }

  it should "print the expected output given a calendar month and year" in {
    // Arrange
    val february2016Output =
      """
        |February 2016
        |Sun Mon Tue Wed Thu Fri Sat
        |      1   2   3   4   5   6
        |  7   8   9  10  11  12  13
        | 14  15  16  17  18  19  20
        | 21  22  23  24  25  26  27
        | 28  29
      """.stripMargin.trim
    val app = new CalApp with SeqLoggedOutput

    // Act
    app.cal(yearInput = 2016, monthInput = 2)
    val output = app.messages.mkString("\r\n")

    // Assert
    assert(output contains february2016Output)
  }

}
