/**
 * File     : SeqLoggedOutput.scala
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

/**
 * Log the println method into a string sequence.
 */
trait SeqLoggedOutput extends Output {

  /**
   * The message print sequence.
   */
  var messages: Seq[String] = Seq()

  /**
   * Log the message into the sequence instead of `println`
   *
   * @param output the output to log.
   */
  override def print(output: String) = messages = messages :+ output
}
