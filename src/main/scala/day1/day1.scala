import scala.io.Source

object ScalaApp {

  // Test input
  val input = List(1721, 979, 366, 299, 675, 1456)

  def parseFile(fileName: String) : List[Int] = {
    Source.fromFile(fileName).getLines().toList.map(_.toString().toInt)
  }

  def main(args: Array[String]): Unit = {

    // part 1
    println(parseFile("src/main/scala/day1/input").combinations(2).find(_.sum == 2020).get.product)

    //part 2
    println(parseFile("src/main/scala/day1/input").combinations(3).find(_.sum == 2020).get.product)

  }
}