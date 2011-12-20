package org.jamieei.hangman

import collection.immutable._

class Game(word: String, guesses: Set[Char]) {
	def this(word: String) = this(word, new HashSet[Char]())

  def maskedWord(): String = word.map((ch: Char) => if (guesses.contains(ch)) ch else '_')
  override def toString = maskedWord //.reduceLeft(_ + " " ++ _)
}

