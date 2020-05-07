import scala.util.Random
import scala.collection.mutable
import scala.math.round

trait Objects {
}

class Car(var carType: String) extends Objects {
  override def toString = carType
}

class Book(var bookName: String) extends Objects {
  override def toString = bookName
}

class Employee(var employeeType: String) extends Objects {
  override def toString = employeeType
}


object Test extends Objects {

  def mirsaGries(k: Int, s: Stream[Objects]): mutable.Map[Objects,Int] = {

    var A = mutable.Map[Objects, Int]()
    for (i <- s) {
      if (A contains i) {
        A(i) += 1
      }
      else if (A.keys.size < (k - 1)) {
        A(i) = 1
      }
      else {
        for (j <- A.keys) {
          A(j) -= 1
          if (A(j) == 0) {
            A -= j
          }
        }
      }
    }
    return A
  }

  def main(args: Array[String]): Unit = {
    val car1 = new Car("Fiat")
    val car2 = new Car("Opel")
    val car3 = new Car("BMW")
    val car4 = new Car("Mercedes")
    val book1 = new Book("Ulysses")
    val book2 = new Book("Lolita")
    val book3 = new Book("Don Quixote")
    val book4 = new Book("The Great Gatsby")
    val employee1 = new Employee("psychologist")
    val employee2 = new Employee("dentist")
    val employee3 = new Employee("neurologist")
    val employee4 = new Employee("pediatrician")
    val employee5 = new Employee("laryngologist")


    val variables = Seq(car1, car2, car3, car4, book1, book2, book3, book4,
      employee1, employee2, employee3, employee4, employee5)

    var sm: Stream[Objects] = Stream.empty

    // create stream with randomly distributed 100 objects
    for (i <- 0 until 100) {
      sm = (sm :+ variables(Random.nextInt(variables.length)))
    }

    // user interaction and results
    try {
      val object_input: String =
        scala.io.StdIn.readLine("Please write which type of object you want to find (car, book, employee): ")
      if (!(List("car", "book", "employee") contains object_input)){
        println("No such object.")
      }
      else {
        val m = scala.io.StdIn.readLine("Please write how frequent should this object be: ").toInt
        var k: Int = 0
        if (object_input == "car") {
          val sm_cars = sm.filter(_.isInstanceOf[Car])
          k = round(sm_cars.length/m).toInt
          val algorithm = mirsaGries(k, sm_cars)
          println(s"Objects of type car which appear more than $m times in the stream, are: ")
          algorithm.keySet.foreach(println)
        }
        else if (object_input == "book") {
          val sm_books = sm.filter(_.isInstanceOf[Book])
          k = round(sm_books.length/m).toInt
          val algorithm = mirsaGries(k, sm_books)
          println(s"Objects of type book which appear more than $m times in the stream, are: ")
          algorithm.keySet.foreach(println)
        }
        else if (object_input == "employee") {
          val sm_employees = sm.filter(_.isInstanceOf[Employee])
          k = round(sm_employees.length/m).toInt
          val algorithm = mirsaGries(k, sm_employees)
          println(s"Objects of type employee which appear more than $m times in the stream, are: ")
          algorithm.keySet.foreach(println)
        }
      }
    }
    catch {
      case ex: NumberFormatException => {
        println("Wrong format.")
      }
    }
  }
}