package org.jamieei.hangman

import collection.immutable._

class Game(word: String, guesses: Set[Char]) {
  def this(word: String) = this(word, new TreeSet[Char]())

  private val figures = List("", "o", "o-", "oc", "oE", "oE\\", "oE<")
  private def spacify(str: String): String = str.foldLeft("")((acc, c) => acc + ' ' + c)

  def maskedWord(): String = word.map((ch: Char) => if (guesses.contains(ch)) ch else '_')
  override def toString = 
    spacify(maskedWord) + "    " +
    figures(nWrong) + "    " +
    spacify(wrongGuesses.mkString)
  def answer: String = spacify(word)

  def missingLetters: Set[Char] = word.toSet.diff(guesses)
  def wrongGuesses: Set[Char] = guesses.diff(word.toSet)
  def nWrong = wrongGuesses.size
  def nRight = guesses.size - nWrong

  def next(guess: Char): Game = new Game(word, guesses + guess)

  def isWin: Boolean = missingLetters.isEmpty
  def isLoss: Boolean = (nWrong >= (figures.size - 1))
  def isOver: Boolean = (isWin || isLoss)
}

