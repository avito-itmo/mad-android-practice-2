package task_1

// 1. Создай класс Person с полями name и age, методами toString, equals, copy, hashCode
data class Person(val name: String, val age: Int)

// 2. Создай объект-синглтон Logger с методом log(message: String)
object Logger {
    fun log(message: String) {
        println(message)
    }
}

// 3. Создай sealed class Shape c полем area и тремя наследниками: Circle, Triangle
sealed class Shape {
    abstract val area: Double
}

class Circle(val radius: Double) : Shape() {
    override val area: Double = Math.PI * radius * radius
}

class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) : Shape() {
    override val area: Double = run {
        val s = (sideA + sideB + sideC) / 2
        Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }

    val perimeter: Double = sideA + sideB + sideC
}

// 4. Напиши функцию, которая печатает периметр фигуры, используя when для обработки Shape
fun calculatePerimeter(shape: Shape) {
    when (shape) {
        is Circle -> println("Circle perimeter: ${2 * Math.PI * shape.radius}")
        is Triangle -> println("Triangle perimeter: ${shape.perimeter}")
    }
}

// 5. Создай класс Utils со статической функцией greet()
class Utils {
    companion object {
        fun greet(): String = "Hello!"
    }
}