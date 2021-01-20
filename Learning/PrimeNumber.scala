//this is a class with a method which calculates all prime numbers within the range between 2 and n
class PrimeNumber(val n: Int) {
  var primeList = new Array[Int](n)
  var k = 0

  def calculatePrimeNumbers(n: Int) : Unit = {      // a number is prime, if it's not divisible by any number other than 1 and itself
    for (x <- 2 to n) {
        if (x == 2) {
          primeList(k) = x
          k+=1
        }
        else if(!(2 until x).exists(i => x % i == 0)) {
          primeList(k) = x
          k+=1
        }
    }
  }
    


//this is a public method which returns the m-th prime number
  def number(m: Int): Int = {
    var primes = new Array[Int](k)
    for (i<-0 until k) {            //k is the number of primes. this loop creates an array of length k (primeList is of length n)
      primes(i) = primeList(i)
    }
    return primes(m)
  }
}


//this is an object Test with the method main which for the first argument creates an array of the prime numbers and the for the next arguments prints the values of the calculated prime numbers from that array
object Test {
  def main(args: Array[String]): Unit = {
        try {
          val n = args(0).toInt
          val prime = new PrimeNumber(n)
          var c = prime.calculatePrimeNumbers(n)
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
        val prime = new PrimeNumber(args(0).toInt)
        var c = prime.calculatePrimeNumbers(args(0).toInt)
        val x = args(i).toInt
        println(args(i) + " - " + prime.number(args(i).toInt))
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





