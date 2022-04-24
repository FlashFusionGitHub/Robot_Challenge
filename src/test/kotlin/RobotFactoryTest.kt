import org.junit.Test
import kotlin.test.assertEquals

internal class RobotFactoryTest {

    private val fileReader = FileReader().readFiles("src/test/resources/inputfiles")

    @Test
    fun build() {
        val robotFactory = RobotFactory().build(fileReader)

        assertEquals(robotFactory[0].name, "CrashTestDummy")
        assertEquals(robotFactory[0].currentPosition, Position(0, 0))
        assertEquals(robotFactory[0].facing, Facing.NORTH)
        assertEquals(robotFactory[0].inputs,
            mutableListOf(Inputs.MOVE, Inputs.LEFT, Inputs.MOVE, Inputs.PLACE, Inputs.MOVE, Inputs.MOVE, Inputs.PLACE, Inputs.REPORT))
    }
}