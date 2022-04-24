enum class Facing(val value: String) {
    NORTH("NORTH"),
    EAST("EAST"),
    SOUTH("SOUTH"),
    WEST("WEST");

    fun next(): Facing {
        return values[(ordinal + 1) % values.size]
    }

    fun previous(): Facing {
        return values[(ordinal - 1 + values.size) % values.size]
    }

    companion object {
        val values: List<Facing> = values().toList()
    }
}