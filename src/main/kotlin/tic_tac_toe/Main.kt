package tic_tac_toe

fun main() {
    val game = Game(Player1(), Player2(), Field())
    game.start()
}