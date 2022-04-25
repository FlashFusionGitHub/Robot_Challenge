fun main(args: Array<String>) {
    val robots = RobotFactory(Board(0,4, 0, 4)).build(FileReader().readFiles("src/main/resources/inputfiles"))
    robots.forEach {
        robot -> robot.update(robots)
    }
}