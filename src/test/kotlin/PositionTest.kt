import org.junit.Test
import kotlin.test.assertEquals

internal class PositionTest {

    @Test
    fun getX() {
        val position = Position(1, 2)
        assertEquals(position.x, 1)
    }

    @Test
    fun setX() {
        val position = Position(0, 0)
        position.x = 2
        assertEquals(position.x, 2)
    }

    @Test
    fun getY() {
        val position = Position(1, 2)
        assertEquals(position.y, 2)
    }

    @Test
    fun setY() {
        val position = Position(0, 0)
        position.y = 2
        assertEquals(position.y, 2)
    }
}