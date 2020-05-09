package tic_tac_toe

class Player1 : Player(true, 'X'), ISetMark {
    override fun setMark(x: Int, y: Int, field: Field) {
        if (field.getMark(x, y) == ' ')
            field.setMark(x, y, symbol)
    }
}