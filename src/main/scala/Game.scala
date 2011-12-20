package org.jamieei.hangman

import collection.immutable._

class Game(word: String, guesses: Set[Char]) {
	def this(word: String) = this(word, new HashSet[Char]())

  def maskedWord(): String = word.map((ch: Char) => if (guesses.contains(ch)) ch else '_')
  override def toString = maskedWord.foldLeft("")((acc, c) => acc + ' ' + c)

  def missingLetters: Set[Char] = word.toSet.diff(guesses)
  def wrongGuesses: Set[Char] = guesses.diff(word.toSet)
  def nWrong = wrongGuesses.size
  def nRight = guesses.size - nWrong

  def next(guess: Char): Game = new Game(word, guesses + guess)

  def isWin: Boolean = missingLetters.isEmpty
  def isLoss: Boolean = (nWrong > 6)
  def isOver: Boolean = (isWin || isLoss)
}

