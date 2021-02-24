import Robot.{generateUniqueName, names}

import scala.collection.mutable

class Robot {
  var name = generateUniqueName()

  def reset() = {
    names.remove(name)
    name = generateUniqueName()
  }
}

object Robot {
  val rand = scala.util.Random
  val names = new mutable.HashSet[String]

  def generateUniqueName(): String = {
    def generateDigit() = rand.nextInt(10)

    def generateLetter() = ('A' + rand.nextInt(26)).toChar

    val name = s"${generateLetter()}${generateLetter()}${generateDigit()}${generateDigit()}${generateDigit()}"
    if (names.contains(name)) generateUniqueName()
    else {
      names.add(name)
      name
    }
  }
}
