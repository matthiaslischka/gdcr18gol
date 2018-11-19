package at.matthiaslischka.gdcr18gol

import org.junit.Assert
import org.junit.Test

class GetAliveNeighboursTests {

    @Test
    fun cellInEmptyOneCellWorld_HasNoNeighbours() {
        var world = World(1, 1)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(0, 0)

        Assert.assertEquals(0, countOfAliveNeighbours)
    }

    @Test
    fun cellInFullOneCellWorld_HasNoNeighbours() {
        var world = World(1, 1)
        world.bringCellAliveAt(0, 0)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(0, 0)

        Assert.assertEquals(0, countOfAliveNeighbours)
    }


    @Test
    fun cellInEmptyWorld_BigAsCellReach_HasNoNeighbours() {
        var world = World(3, 3)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(1, 1)

        Assert.assertEquals(0, countOfAliveNeighbours)
    }

    @Test
    fun aliveCellInEmptyWorld_BigAsCellReach_HasNoNeighbours() {
        var world = World(3, 3)
        world.bringCellAliveAt(1, 1)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(1, 1)

        Assert.assertEquals(0, countOfAliveNeighbours)
    }

    @Test
    fun cellInFullWorld_BigAsCellReach_Has8Neighbours() {
        var world = World(3, 3)
        fillWorldWithLive(world)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(1, 1)

        Assert.assertEquals(8, countOfAliveNeighbours)
    }

    @Test
    fun cellInFullWorld_BiggerThanCellReach_Has8Neighbours() {
        var world = World(5, 5)
        fillWorldWithLive(world)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(1, 1)

        Assert.assertEquals(8, countOfAliveNeighbours)
    }

    @Test
    fun aliveCellInEmptyWorld_NotSquare_HasNoNeighbours() {
        var world = World(5, 3)
        world.bringCellAliveAt(1, 1)

        var countOfAliveNeighbours = world.getCountOfAliveNeighboursAt(1, 1)

        Assert.assertEquals(0, countOfAliveNeighbours)
    }

    private fun fillWorldWithLive(world: World) {
        world.map.forEach { cell -> cell.isAlive = true }
    }
}