import java.io.File
import java.lang.NullPointerException
import java.lang.NumberFormatException

class RobotFactory(val board: Board) {
    private val robots = mutableListOf<Robot>()

    fun build(files: MutableList<File>): MutableList<Robot> {
        files.forEach {
            var (facingSet, positionSet) = listOf(false, false)
            var robotName = ""

            try {
                robotName = it.name.toString()
            } catch (e: NullPointerException) {
                println(e.message)
            }

            val inputs = mutableListOf<Inputs>()
            var facing = Facing.NORTH
            var position = Position(0, 0)

            File(it.toURI()).forEachLine { input ->
                try {
                    val words = input.split(" ").toList()
                    if (words.size > 1) {
                        if (Inputs.valueOf(words[0]) == Inputs.PLACE) {
                            inputs.add(Inputs.valueOf(words[0]))
                            val coordinatesAndFacing = words[1].split(",").toList()
                            try {
                                position = Position(coordinatesAndFacing[0].toInt(), coordinatesAndFacing[1].toInt())
                                positionSet = true
                            } catch (e: NumberFormatException) {
                                println(e.message)
                            }
                            try {
                                facing = Facing.valueOf(coordinatesAndFacing[2])
                                facingSet = true
                            } catch (e: IllegalArgumentException) {
                                println(e.message)
                            }
                        } else {
                            println("$robotName reported an invalid command $words: coordinates and facing must be prefixed with PLACE command")
                        }
                    } else {
                        inputs.add(Inputs.valueOf(input))
                    }
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }

            if (facingSet && positionSet)
                robots.add(Robot(robotName, inputs, position, facing, board))
            else
                println("$robotName could not be built due to incorrectly formatted PLACE command")
        }
        return robots
    }
}