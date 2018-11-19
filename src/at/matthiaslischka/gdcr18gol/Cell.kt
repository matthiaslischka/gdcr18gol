package at.matthiaslischka.gdcr18gol

class Cell(var isAlive: Boolean) {
    var countOfAliveNeighbours: Int = 0

    fun evolve() {
        isAlive = when (countOfAliveNeighbours) {
            0, 1 -> false
            2 -> isAlive
            3 -> true
            else -> false
        }
    }
}