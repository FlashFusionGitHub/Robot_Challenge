class Robot(private val name: String, private val inputs: MutableList<Inputs>, private val position: Position, private val facing: Facing) {
    var currentPosition = position
    private var currentFacing = facing
    private var placed: Boolean? = null

    fun update(robots: List<Robot>) {
        if (inputs.contains(Inputs.PLACE)) {
            if (placed == true || placed == null) {
                inputs.forEach {
                    if (it == Inputs.PLACE) {
                        if (!place(position.x, position.y, facing, robots))
                            return
                    }
                    if (it == Inputs.MOVE) {
                        move(robots)
                    }
                    if (it == Inputs.LEFT) {
                        turn(it)
                        move(robots)
                    }
                    if (it == Inputs.RIGHT) {
                        turn(it)
                        move(robots)
                    }
                    if (it == Inputs.REPORT) {
                        report()
                    }
                }
            }
        }
    }

    private fun place(xPos: Int, yPos: Int, facing: Facing, robots: List<Robot>): Boolean {
        val position = Position(xPos, yPos)

        if(!fall(position)) {
            if(!collision(position, robots)) {
                currentPosition = Position(xPos, yPos)
                currentFacing = facing
                placed = true
            }
            else {
                println("$name was placed on top of another robot and was ejected from the game")
                placed = false
                return false
            }
        }
        else {
            println("$name was placed outside of the board limits and fell off the board..")
            placed = false
            return false
        }
        return true
    }

    private fun move(robots: List<Robot>) {
        val futurePosition = Position(currentPosition.x, currentPosition.y)

        if(currentFacing == Facing.NORTH) {
            futurePosition.x += 1
        }
        if(currentFacing == Facing.EAST) {
            futurePosition.y += 1
        }
        if(currentFacing == Facing.SOUTH) {
            futurePosition.x -= 1
        }
        if (currentFacing == Facing.WEST) {
            futurePosition.y -= 1
        }

        if(!fall(futurePosition) && !collision(futurePosition, robots))
            currentPosition = futurePosition
    }

    private fun turn(input: Inputs) {
        if(input == Inputs.LEFT) {
            currentFacing = currentFacing.previous()
        }
        if(input == Inputs.RIGHT) {
            currentFacing = currentFacing.next()
        }
    }

    private fun collision(positionToCheck: Position, enemies: List<Robot>): Boolean {
        if (enemies.isNotEmpty()) {
            enemies.forEach {
                if (it != this && positionToCheck == it.currentPosition && it.placed == true) {
                    println("$name could not move to $positionToCheck as it is occupied by ${it.name}")
                    return true
                }
            }
        }
        return false
    }

    private fun fall(myNextPosition: Position): Boolean {
        if(myNextPosition.x < 0 || myNextPosition.x > 5 || myNextPosition.y < 0 || myNextPosition.y > 5)
            return true
        return false
    }

    private fun report() {
        println("$name is located at ($currentPosition) heading $currentFacing")
    }
}