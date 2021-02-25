object MatchingBrackets {
  private val mappings = Map(']' -> '[', '}' -> '{', ')' -> '(')

  def isPaired(s: String): Boolean = {
    def isPaired(s: List[Char], acc: List[Char]): Boolean = s match {
      case List() => acc.isEmpty
      case head :: tail =>
        if (mappings.values.exists(_ == head)) isPaired(tail, head :: acc)
        else if (mappings.contains(head))
          if (acc.isEmpty || acc.head != mappings(head)) false
          else isPaired(tail, acc.tail)
        else isPaired(s.tail, acc)
    }

    isPaired(s.toList, List())
  }
}
