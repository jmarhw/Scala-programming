import Array._

//this class creates a Pascal triangle

class PascalTriangleRow(val n: Int) {
  var matrix = ofDim[Int](n, 2 * n + 1)     //creates 2D array filled with zeroes with twice as many columns as there are rows
  val lastRow = new Array[Int](2*n+1)

  def calculate(n: Int): Unit = {
    matrix(0)(n) = 1 //put 1 in the first row
    for (i <- 1 until n) {
      for (j <- 1 until 2 * n) {
        matrix(i)(j) = matrix(i - 1)(j - 1) + matrix(i - 1)(j + 1) //a number in each row can be calculated by taking a number above and to the left with the number above and to the right
      }
    }

    for (i<-1 until 2*n) {
      lastRow(i) = matrix(n-1)(i)
    }
  }


  def factor(m: Int): Int = {
    val noZeroes = lastRow.filter(_ != 0)     //Pascal's triangle was created on an array filled with zeroes, so they have to be filtered out
    return noZeroes(m)
  }
}

//this object is made for testing the PascalTriangleRow class - for the first argument it creates a Pascal's triangle line and then for the next arguments prints the appropriate values of this line

object Test {
  def main(args: Array[String]): Unit = {
    try {
      val n = args(0).toInt+1
      val line = new PascalTriangleRow(n)
      var c = line.calculate(n)
    }
    catch {
      case ex: ArrayIndexOutOfBoundsException => {
        println(args(0) + " - out of range number")
        System.exit(1)
      }
      case ex: NumberFormatException => {
        println(args(0) + " - invalid argument")
        System.exit(1)
      }
      case ex: NegativeArraySizeException => {
        println(args(0) + " - out of range number")
        System.exit(1)
      }

    }

    for (i<-1 until args.length) {
      try {
        val line = new PascalTriangleRow(args(0).toInt+1)
        var c = line.calculate(args(0).toInt+1)
        val x = args(i).toInt
        println(args(i) + " - " + line.factor(x))
      }
      catch {
        case ex: ArrayIndexOutOfBoundsException => {
          println(args(i) + " - out of range number")
        }
        case ex: NumberFormatException => {
          println(args(i) + " - invalid argument")
        }
      }
    }
  }
}