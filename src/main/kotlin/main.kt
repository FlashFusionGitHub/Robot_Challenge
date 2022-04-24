fun main(args: Array<String>) {
    val robots = RobotFactory(Board(5, 5)).build(FileReader().readFiles("src/main/resources/inputfiles"))
    robots.forEach {
        robot -> robot.update(robots)
    }
}