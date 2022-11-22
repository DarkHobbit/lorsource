/*
 * Copyright 1998-2022 Linux.org.ru
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.org.linux.topic

import ru.org.linux.util.StringUtil

import scala.beans.BeanProperty

case class BriefTopicRef(
  @BeanProperty url:String,
  @BeanProperty title:String,
  @BeanProperty commentCount:Int,
  @BeanProperty group:Option[String]
)

object BriefTopicRef {
  def fromTopicNoGroup(input:Topic) =
    BriefTopicRef(input.getLink, StringUtil.processTitle(input.title), input.commentCount, None)

  def fromTopic(input:Topic, group:String) =
    BriefTopicRef(input.getLink, StringUtil.processTitle(input.title), input.commentCount, Some(group))

}
