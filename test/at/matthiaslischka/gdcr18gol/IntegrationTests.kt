package at.matthiaslischka.gdcr18gol

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class IntegrationTests {
    @Test
    fun worldWithEmptyCellWithThreeNeighbours_Evolves_NewAliveCell() {
        var world = World(3, 3)
        world.bringCellAliveAt(0, 0)
        world.bringCellAliveAt(1, 0)
        world.bringCellAliveAt(2, 0)
        printMap(world)

        world.evolve()

        printMap(world)
        Assert.assertEquals(
                "Cell surrounded by 3 active neighbours should become active",
                true,
                world.map[4].isAlive
        )
    }

    @Ignore
    @Test
    fun animate_world_evolution() {
        var world = World(10, 10)
        world.bringCellAliveAt(0, 5)
        world.bringCellAliveAt(1, 5)
        world.bringCellAliveAt(2, 5)
        world.bringCellAliveAt(3, 5)
        world.bringCellAliveAt(4, 5)
        world.bringCellAliveAt(5, 5)
        world.bringCellAliveAt(6, 5)
        world.bringCellAliveAt(7, 5)
        world.bringCellAliveAt(8, 5)
        world.bringCellAliveAt(9, 5)

        for (i in 0..18) {
            printMap(world)
            world.evolve()
            Thread.sleep(500)
        }
    }

    private fun printMap(world: World) {
        print("------------------------------\n")
        for (y in 0 until world.sizeY) {
            for (x in 0 until world.sizeX)
                print(
                        when (world.getCellAt(x, y)!!.isAlive) {
                            true -> "X"
                            false -> " "
                        }
                )
            print("\n")
        }
        print("\n")
    }
}