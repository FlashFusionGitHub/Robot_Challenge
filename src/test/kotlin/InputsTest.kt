import org.junit.Test
import kotlin.test.assertEquals

internal class InputsTest {

    @Test
    fun getValue() {
        val inputs = Inputs.MOVE
        assertEquals(inputs.value, Inputs.MOVE.value)
    }
}