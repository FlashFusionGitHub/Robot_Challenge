import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

internal class FacingTest {
    @Test
    operator fun next() {
        val facing = Facing.NORTH
        assertEquals(facing.next(), Facing.EAST)
    }

    @Test
    fun previous() {
        val facing = Facing.NORTH
        assertEquals(facing.previous(), Facing.WEST)
    }

    @Test
    fun getValue() {
        val facing = Facing.NORTH
        assertEquals(facing.value, Facing.NORTH.value)
    }
}