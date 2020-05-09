package tic_tac_toe

class Field {
    private var field: Array<CharArray> = arrayOf(
            charArrayOf(' ', ' ', ' '),
            charArrayOf(' ', ' ', ' '),
            charArrayOf(' ', ' ', ' ')
    )

    override fun toString(): String {
        return this.field
                .joinToString("\n") {
                    String.format("| %-1s | %-1s | %-1s |", it[0], it[1], it[2])
                }
    }

    fun getMark(x: Int, y: Int): Char? {
        return field[y][x]
    }

    fun setMark(x: Int, y: Int, value: Char) {
        if (field[y][x] == ' ') field[y][x] = value
    }

    fun isEnd() = !field
            .flatMap { it.toList() }
            .contains(' ')

    fun checkCell(x: Int, y: Int): Boolean {
        return field[y][x] == 'X' || field[y][x] == '0'
    }
}