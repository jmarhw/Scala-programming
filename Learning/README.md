# PrimeNumber - Task description


Create a class PrimeNumber with one constructor PrimeNumber(val n:int) and a function
calculatePrimeNumbers(val n:int) which calculates all prime numbers within the range between 2 and n. Then, implement the public function number(val m:int):int which re- turns the mth prime number. The function should work properly for the numbers from 0 to k, where k is the amount of prime numbers within the range between 2 and n.

Create object Test with the method main which for the fi􏰀rst argument creates an array of the prime numbers and then for the next arguments prints the values of the calculated prime numbers from that array.

Example of usage:
> scala Test 14 0 2 4 8

## PascalTriangleRow - Task description
Create a class PascalTriangleRow with one constructor PascalTriangleRow(val n:int) and a function calculate(val n:int). The function should calculate nth line of the Pas- cal triangle and write it into an array. Then implement the public function factor (val m:int):int returning the mth item of the line n. This function should work properly for numbers from 0 to n (constructor argument).

Create an object Test with a method main which for the 􏰀rst argument creates a Pascal's triangle line and then for the next arguments prints the appropriate values of this line.

Example of usage:
> scala Test 4 0 3 1 8

### Figure - Task description
Write program in Scala with the following requirements. The program should calculate the field and perimeter of the following geometrical 􏰀figures: circle, square, rectangle, rhombus, regular pentagon, regular hexagon. For this purpose, a class hierarchy should be created to support particular types of fi􏰀gures. The root of this hierarchy should be the abstract class Figure, with method declarations for calculating the perimeter and 􏰀field of a given 􏰀figure. We assume that the abstract class Quadrangle and classes: Circle, Pentagon, Hexagon inherit from the class Figure. Then, the classes: Square, Rectangle, Rhombus inherit from the class Quadrangle. Create appropriate methods in child classes that will calculate the perimeter and 􏰀eld in a manner speci􏰀c to a given geometrical 􏰀figure. In the command line you can specify the following types of geometric fi􏰀gures (c - circle, q-quadrangle, p-pentagon,
s-hexagon) and their parameters, where: 

the circle has one parameter: radius, 

quadrangle has fi􏰀ve parameters: side1, side2, side3, side4, angle, 

pentagon and hexagon one parameter: side. 

For example, the following instruction create a circle with the radius 6, a
rectangle with sides: 8 and 4 and a rhombus with the side 7.
>scala Figures cqq 6 8 8 8 8 90 7 7 7 7 30
