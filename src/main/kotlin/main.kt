fun main(args: Array<String>) {
    val robots = RobotFactory().build(FileReader().readFiles("src/main/resources/inputfiles"))
    robots.forEach {
        robot -> robot.update(robots)
    }
}