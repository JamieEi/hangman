package org.jamieei.hangman

object Main {
  def main(args: Array[String]) {
  	val wordlist = new Wordlist
  	val word = wordlist.getWord

    var game = new Game(word)
    var isOver = false

    do {
      println
      println(game)
      isOver = game.isOver

      if (!isOver) {
        print("Next guess (Ctrl-D to quit): ")
        val ich = Console.in.read
        isOver = (ich == 4)
        println

        val ch = ich.toChar
        game = game.next(ch)
      }
    } while (!isOver)

    println(if (game.isWin) "Sweet victory!!!" else "Crhusing defeat!!!")
    println
  }
}
