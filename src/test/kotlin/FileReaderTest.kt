import org.junit.Test
import kotlin.test.assertEquals

internal class FileReaderTest {

    @Test
    fun readFiles() {
        val fileReader = FileReader().readFiles("src/test/resources/inputfiles")
        assertEquals(fileReader[0].name, "CrashTestDummy")
    }
}