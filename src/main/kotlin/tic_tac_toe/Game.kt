package tic_tac_toe

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.system.exitProcess

class Game(var player1: Player1, var player2: Player2, var field: Field) {
    private fun setMark(x: Int, y: Int) {
        if (x !in 1..3 || y !in 1..3 || field.checkCell(x - 1, y - 1)) {
            throw IllegalArgumentException("invalid coordinate")
        }
        val x1 = x - 1
        val y1 = y - 1
        if (player1.isMyTurn) {
            player1.setMark(x1, y1, field)
        } else {
            player2.setMark(x1, y1, field)
        }
    }

    private fun setMark(pair: Pair<Int, Int>) {
        setMark(pair.first, pair.second)
        checkWin(field)
        println(field.toString() + "\n")
        if (isEnd()) exitProcess(0)
    }

    private fun isEnd(): Boolean = player1.isWin || player2.isWin || field.isEnd()

    private fun checkWin(field: Field) {
        for (x in 0..2) {
            if (field.getMark(0, x) == field.getMark(1, x) && field.getMark(1, x) == field.getMark(2, x)) {
                val winChar = field.getMark(0, x)
                getWinner(winChar)
            }
        }
        for (y in 0..2) {
            if (field.getMark(y, 0) == field.getMark(y, 1) && field.getMark(y, 1) == field.getMark(y, 2)) {
                val winChar = field.getMark(y, 0)
                getWinner(winChar)
            }
        }
        if (field.getMark(0, 0) == field.getMark(1, 1) && field.getMark(1, 1) == field.getMark(2, 2)) {
            val winChar = field.getMark(1, 1)
            getWinner(winChar)
        }
        if (field.getMark(2, 0) == field.getMark(1, 1) && field.getMark(1, 1) == field.getMark(0, 2)) {
            val winChar = field.getMark(1, 1)
            getWinner(winChar)
        }
    }

    private fun getWinner(winChar: Char?) {
        if (winChar == 'X') {
            player1.isWin = true
            println("Player1 is win")
        } else if (winChar == '0') {
            println("Player2 is win")
            player2.isWin = true
        }
    }

    private fun scanConsole(): Pair<Int, Int> {//Вводить в формате 'x.y'
        val scanner = Scanner(System.`in`)
        val coordinates: String = scanner.nextLine()
        val x: Int = coordinates.substring(0, 1).toInt()
        val y: Int = coordinates.substring(2).toInt()
        return Pair(x, y)
    }

    private fun greeting() {
        if (player1.isMyTurn) print("Player1 turn - ")
        else print("Player2 turn - ")
    }

    fun start() {
        while (true) {
            try {
                greeting()
                this.setMark(scanConsole())
                player2.isMyTurn = !player2.isMyTurn
                player1.isMyTurn = !player1.isMyTurn
            } catch (e: IllegalArgumentException) {
                System.err.println("invalid coordinate. Try again")
                greeting()
                this.setMark(scanConsole())
            }
        }
    }
}