package tic_tac_toe

class Player2 : Player(false, '0'), ISetMark {
    override fun setMark(x: Int, y: Int, field: Field) {
        if (field.getMark(x, y) == ' ') field.setMark(x, y, symbol)
    }
}