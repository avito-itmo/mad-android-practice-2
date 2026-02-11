package task_1

import org.junit.jupiter.api.Test
import kotlin.test.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ClassesAndObjectsTest {

    // 1
    @Test
    fun `test Person data class`() {
        // Check if Person is a data class with correct fields
        val person1 = Person("Alice", 25)
        val person2 = Person("Alice", 25)
        val person3 = Person("Bob", 30)

        assertEquals("Alice", person1.name)
        assertEquals(25, person1.age)

        // Test equals and hashCode
        assertEquals(person1, person2)
        assertNotEquals(person1, person3)

        // Test toString
        assertTrue(person1.toString().contains("Alice"))
        assertTrue(person1.toString().contains("25"))

        // Test copy
        val copied = person1.copy(age = 26)
        assertEquals("Alice", copied.name)
        assertEquals(26, copied.age)
    }

    // 2
    @Test
    fun `test Logger singleton`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        Logger.log("Test message")

        assertTrue(outputStream.toString().contains("Test message"))
        System.setOut(System.out)
    }

    // 3
    @Test
    fun `test Shape sealed class hierarchy`() {
        val circle = Circle(5.0)
        val triangle = Triangle(3.0, 4.0, 5.0)

        // Test area calculation
        assertEquals(Math.PI * 25, circle.area, 0.001)
        assertEquals(6.0, triangle.area, 0.001) // Heron's formula for 3-4-5 triangle

        // Test inheritance
        assertTrue(circle is Shape)
        assertTrue(triangle is Shape)
    }

    // 4
    @Test
    fun `test calculatePerimeter for Circle`() {
        val circle = Circle(5.0)
        calculatePerimeter(circle)
        // Assuming calculatePerimeter prints the result
    }

    @Test
    fun `test calculatePerimeter for Triangle`() {
        val triangle = Triangle(3.0, 4.0, 5.0)
        calculatePerimeter(triangle)
        // Assuming calculatePerimeter prints the result
    }

    // 5
    @Test
    fun `test Utils static method`() {
        assertEquals("Hello!", Utils.greet())
    }
}
