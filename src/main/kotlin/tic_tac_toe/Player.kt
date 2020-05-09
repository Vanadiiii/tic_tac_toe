package tic_tac_toe

abstract class Player(
        var isMyTurn: Boolean,
        val symbol: Char,
        var isWin: Boolean = false
)