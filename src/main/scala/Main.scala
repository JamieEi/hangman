package org.jamieei.hangman

object Main {
  def main(args: Array[String]) {
    var game = new Game("test")
    while (!game.isOver) {
      println(game)
      print("Next guess (Q to quit): ")
      
      val ch = readChar
      println(ch)
      println

      if (ch == 'Q') return
      game = game.next(ch)
    }

    if (game.isWin) println("Sweet victory!!!")
    if (game.isLoss) println("Crhusing defeat!!!")
  }
}
