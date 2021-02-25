object MatchingBrackets {
  private val mappings = Map(']' -> '[', '}' -> '{', ')' -> '(')

  def isPaired(s: String): Boolean = {
    def isPaired(s: List[Char], acc: List[Char]): Boolean = s match {
      case List() => acc.isEmpty
      case head :: tail => head match {
        case '[' | '{' | '(' => isPaired(tail, acc.+:(head))
        case ']' | '}' | ')' => if (acc.isEmpty || acc.head != mappings.get(head).get) false else isPaired(tail, acc.tail)
        case _ => isPaired(s.tail, acc)
      }
    }

    isPaired(s.toCharArray.toList, List())
  }
}
