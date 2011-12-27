package org.jamieei.hangman

import scala.io.Source
import scala.util.Random

class Wordlist {
  val res = getClass.getResource("/wordsEn.txt")
  val source = Source.fromURL(res)
  val words = source.getLines.toList

  def getWord(): String = {
  	val random = new Random
  	val i = (random.nextInt % words.size)
  	words(i)
  }
}
