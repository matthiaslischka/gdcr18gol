package at.matthiaslischka.gdcr18gol

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CellEvolveTests(
        private val setupIsCellAlive: Boolean,
        private val countOfAliveNeighbours: Int,
        private val expectedIsCellAlive: Boolean
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
                //aliveCell, with X neighbours, should be <isAlive>
                arrayOf(true, 0, false),
                arrayOf(true, 1, false),
                arrayOf(true, 2, true),
                arrayOf(true, 3, true),
                arrayOf(true, 4, false),
                arrayOf(true, 5, false),
                arrayOf(true, 6, false),
                arrayOf(true, 7, false),
                arrayOf(true, 8, false),

                //deadCell, with X neighbours, should be <isAlive>
                arrayOf(false, 0, false),
                arrayOf(false, 1, false),
                arrayOf(false, 2, false),
                arrayOf(false, 3, true),
                arrayOf(false, 4, false),
                arrayOf(false, 5, false),
                arrayOf(false, 6, false),
                arrayOf(false, 7, false),
                arrayOf(false, 8, false)
        )
    }

    @Test
    fun evolvesAccordingToNeighbourCount() {
        var cell = Cell(setupIsCellAlive)

        cell.countOfAliveNeighbours = countOfAliveNeighbours
        cell.evolve()

        Assert.assertEquals(expectedMessage, expectedIsCellAlive, cell.isAlive)
    }

    private var expectedMessage = setupIsCellAlive.toAliveDeadString() +
            " cell with $countOfAliveNeighbours neighbour(s) expected to be " +
            expectedIsCellAlive.toAliveDeadString()

    private fun Boolean.toAliveDeadString() = if (this) "alive" else "dead"
}