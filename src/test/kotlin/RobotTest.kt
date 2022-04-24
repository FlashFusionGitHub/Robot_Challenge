import org.junit.Test
import kotlin.test.assertEquals

internal class RobotTest {
    private val robot = Robot(
        name = "TestRobot",
        inputs = mutableListOf(Inputs.PLACE, Inputs.MOVE, Inputs.RIGHT),
        position = Position(3, 3),
        facing = Facing.NORTH
    )

    @Test
    fun getCurrentPosition() {
        assertEquals(robot.currentPosition, Position(3, 3))
    }

    @Test
    fun setCurrentPosition() {
        robot.currentPosition = Position(2, 2)
        assertEquals(robot.currentPosition, Position(2, 2))
    }
}