import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class FileReader {
    fun readFiles(filepath: String): MutableList<File> {
        val files: MutableList<File> = mutableListOf()
        Files.walk(Paths.get(filepath)).use { path ->
            path.filter {
                Files.isRegularFile(it)
            }.forEach {
                files.add(File(it.toUri()))
            }
        }
        return files
    }
}