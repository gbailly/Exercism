object Pangram {

    fun isPangram(input: String): Boolean {
        return input.groupBy { it }.keys.map { it.toLowerCase() }.sorted().containsAll("abcdefghijklmnopqrstuvwxyz".toList())
    }
}
