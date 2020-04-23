import scala.math._

 abstract class Figure {
  def perimeter(): Double
  def field(): Double
}

abstract class Quadrangle() {
}

class Circle(val radius: Double) extends Figure {
  def perimeter(): Double = {
    return 2 * scala.math.Pi * radius
  }
  def field(): Double = {
    return scala.math.Pi * scala.math.pow(radius,2)
  }
}

class Pentagon(val side: Double) extends Figure {
  def perimeter(): Double = {
    return 5 * side
  }
  def field(): Double = {
    return scala.math.sqrt(25 + 10 * scala.math.sqrt(5))*scala.math.pow(side, 2)/4
  }
}

class Hexagon(val side: Double) extends Figure {
  def perimeter(): Double = {
    return 6 * side
  }
  def field() : Double = {
    return 3 * scala.math.sqrt(3) * pow(side, 2)/2
  }
}

class Square (val side: Double) extends Quadrangle {
  def perimeter(): Double = {
    return 4*side
  }
  def field(): Double = {
    return scala.math.pow(side, 2)
  }
}

class Rectangle (val side1: Double, val side2: Double) extends Quadrangle {
  def perimeter(): Double = {
    return 2*side1 + 2*side2
  }
  def field(): Double = {
    return side1*side2
  }
}

class Rhombus (val side: Double, val angle: Double) extends Quadrangle {
  def perimeter(): Double = {
    return 4*side
  }
  def field(): Double = {
    return scala.math.pow(side, 2) * scala.math.sin(angle)
  }
}


object Figures {
  def main(args: Array[String]): Unit= {
    var index: Int = 1
    for (figure <- args(0)) {
      try {
        if (figure == 'c') {
          val circle = new Circle(args(index).toDouble)
          println("Circle perimeter: " + circle.perimeter())
          println("Circle field: " + circle.field())
          index = index + 1
        }

        if (figure == 'p') {
          val pentagon = new Pentagon(args(index).toDouble)
          println("Pentagon perimeter: " + pentagon.perimeter())
          println("Pentagon field: " + pentagon.field())
          index = index + 1
        }

        if (figure == 's') {
          val hexagon = new Hexagon(args(index).toDouble)
          println("Hexagon perimeter: " + hexagon.perimeter())
          println("Hexagon field: " + hexagon.field())
          index = index + 1
        }

        if (figure == 'q') {
          val side1: Double = args(index).toDouble
          val side2: Double = args(index + 1).toDouble
          val side3: Double = args(index + 2).toDouble
          val side4: Double = args(index + 3).toDouble
          val angle: Double = args(index + 4).toDouble

          if (side1 == side2 && side2 == side3 && side3 == side4) {
            if (angle == 90) {
              val square = new Square(side1)
              println("Square perimeter: " + square.perimeter())
              println("Square field: " + square.field())
              index = index + 5
            }
            else if (angle > 0 && angle <= 180) {
              val rhombus = new Rhombus(side1, angle.toRadians)
              println("Rhombus perimeter: " + rhombus.perimeter())
              println("Rhombus field: " + rhombus.field())
              index = index + 5
            }
            else {
              println("Can't create a figure based on provided data")
            }
          }

          else if (angle == 90 && ((side1 == side2 && side3 == side4) ||
            (side1 == side3 && side2 == side4) ||
            (side1 == side4 && side2 == side3))) {
            val rectangle = new Rectangle(max(side1, side2), min(side3, side4))
            println("Rectangle perimeter: " + rectangle.perimeter())
            println("Rectangle field: " + rectangle.field())
            index = index + 5
          }
          else {
            println("Can't create a figure based on provided data")
          }
        }
      }
      catch {
        case ex: ArrayIndexOutOfBoundsException =>{
          println("Too few parameters")
        }
        case ex: NumberFormatException =>{
          println("Please provide only numbers")
        }
      }
    }
  }
}
