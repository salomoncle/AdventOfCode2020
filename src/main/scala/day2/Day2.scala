import scala.io.Source

object Day2 {


  // Test input
  val input = "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc"

  def validatePasswordPart1(password: List[String]): Boolean = {
    password(3).count(_ == password(2).charAt(0)) match {
      case x if x > password(1).toInt => false
      case x if x < password(0).toInt => false
      case _ => true
    }
  }

  def validatePasswordPart2(password: List[String]): Boolean = {
    password(3).charAt(password(0).toInt - 1) == password(2).charAt(0) ^ password(3).charAt(password(1).toInt - 1) == password(2).charAt(0)
  }

  def parseFile(file: List[String]): List[List[String]] = {
    val regex = "([0-9]+)-([0-9]+) (\\w): (\\w+)".r
    file.map(
      x => regex
        .findAllMatchIn(x)
        .map(matcher => List(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4)))
        .toList.flatten
    ).toList
  }

  def main(args: Array[String]): Unit = {

    //part 1
    println(parseFile(Source.fromFile("src/main/scala/day2/input").getLines().toList).map(x => validatePasswordPart1(x)).count(b => b))

    //part2
    println(parseFile(Source.fromFile("src/main/scala/day2/input").getLines().toList).map(x => validatePasswordPart2(x)).count(b => b))

  }
}