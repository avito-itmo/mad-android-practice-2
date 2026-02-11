package task_1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class BasicsTest {

    // 1
    @Test
    fun `test nullableString is null`() {
        assertNull(nullableString)
    }

    // 2
    @Test
    fun `test safeStringLength with valid string`() {
        assertEquals(5, safeStringLength("hello"))
    }

    @Test
    fun `test safeStringLength with null`() {
        assertEquals(0, safeStringLength(null))
    }

    @Test
    fun `test safeStringLength with empty string`() {
        assertEquals(0, safeStringLength(""))
    }

    // 3
    @Test
    fun `test requireNonNull with valid value`() {
        assertDoesNotThrow { requireNonNull("valid") }
    }

    @Test
    fun `test requireNonNull with null throws exception`() {
        assertFailsWith<IllegalArgumentException> { requireNonNull(null) }
    }

    // 4
    @Test
    fun `test printIfNotNull prints when not null`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        printIfNotNull("test")

        assertTrue(outputStream.toString().contains("test"))
        System.setOut(System.out)
    }

    @Test
    fun `test printIfNotNull does nothing when null`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        printIfNotNull(null)

        assertEquals("", outputStream.toString().trim())
        System.setOut(System.out)
    }

    // 5
    @Test
    fun `test doNothing returns Unit`() {
        val result = doNothing()
        assertEquals(Unit, result)
    }

    // 6
    @Test
    fun `test neverEnding throws exception`() {
        assertFailsWith<RuntimeException> { neverEnding() }
    }


}