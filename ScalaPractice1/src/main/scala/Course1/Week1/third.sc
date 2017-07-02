def balance(chars: List[Char]): Boolean = {

  def valueFor(char: Char) =
    if (char.equals('('))
      +1
    else if (char.equals(')'))
      -1
    else
      0

  def loop(chars: List[Char], counter: Int): Boolean =
    if (chars.isEmpty)
      counter == 0
    else if (counter >= 0)
      loop(chars.tail, counter + valueFor(chars.head))
    else
      false

  loop(chars, 0)
}

balance("(())(aaa))(()".toList)

