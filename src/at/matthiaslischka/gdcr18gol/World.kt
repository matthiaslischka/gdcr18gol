package at.matthiaslischka.gdcr18gol

class World(val sizeX: Int, val sizeY: Int) {

    val map = Array(sizeX * sizeY) { Cell(false) }

    fun bringCellAliveAt(x: Int, y: Int) {
        getCellAt(x, y)!!.isAlive = true
    }

    fun evolve() {
        updateNeighbourCountOfCells()
        map.forEach { it.evolve() }
    }

    fun getCountOfAliveNeighboursAt(x: Int, y: Int): Int {
        var neighbours = arrayListOf(
                getCellAt(x - 1, y - 1),
                getCellAt(x, y - 1),
                getCellAt(x + 1, y - 1),
                getCellAt(x - 1, y),
                getCellAt(x + 1, y),
                getCellAt(x - 1, y + 1),
                getCellAt(x, y + 1),
                getCellAt(x + 1, y + 1)
        )

        return neighbours.sumBy { cell -> cell?.isAlive?.toInt() ?: 0 }
    }

    fun getCellAt(x: Int, y: Int): Cell? {
        if (x < 0 || y < 0 || x >= sizeX || y >= sizeY)
            return null
        return map[x + y * sizeX]
    }

    private fun updateNeighbourCountOfCells() {
        for (x in 0 until sizeX)
            for (y in 0 until sizeY) {
                getCellAt(x, y)!!.countOfAliveNeighbours = getCountOfAliveNeighboursAt(x, y)
            }
    }

    private fun Boolean.toInt() = if (this) 1 else 0
}