package org.jamieei.hangman

object Main {
  def main(args: Array[String]) {
  	val wordlist = new Wordlist
  	val word = wordlist.getWord

    var game = new Game(word)
    var isOver = false

    while (!isOver) {
      println
      println(game)

      print("Next guess (Ctrl-D to quit): ")
      val ich = Console.in.read
      isOver = (ich == 4)
      println

      if (!isOver) {
        val ch = ich.toChar
        game = game.next(ch)
        isOver = game.isOver
      }
    } 

    println
    println(game.answer)
    println

    println(if (game.isWin) "Sweet victory!!!" else "Crushing defeat!!!")
    println
  }
}
