package task_1

import org.junit.jupiter.api.Test
import kotlin.test.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ExtensionsAndScopeTest {

    // 1
    @Test
    fun `test isPositive extension function`() {
        assertTrue(5.isPositive())
        assertFalse((-1).isPositive())
        assertFalse(0.isPositive())
    }

    // 2
    @Test
    fun `test isEven extension property`() {
        assertTrue(2.isEven)
        assertFalse(3.isEven)
        assertTrue(0.isEven)
        assertTrue((-4).isEven)
    }

    // 3
    @Test
    fun `test mostFrequentChar finds correct char`() {
        assertEquals('l', "hello world".mostFrequentChar())
        assertEquals('a', "Abracadabra".mostFrequentChar())
        assertNull("".mostFrequentChar())

        // Test case insensitivity
        assertEquals('a', "AaaAbbb".mostFrequentChar())
    }

    // 4
    @Test
    fun `test safeParseInt converts valid string`() {
        assertEquals(42, safeParseInt("42"))
        assertEquals(100, safeParseInt("100"))
        assertEquals(0, safeParseInt("0"))
    }

    @Test
    fun `test safeParseInt returns 0 for invalid string`() {
        assertEquals(0, safeParseInt("not a number"))
        assertEquals(0, safeParseInt(""))
        assertEquals(0, safeParseInt("123abc"))
    }

    // 5
    @Test
    fun `test configureCar with apply`() {
        val car = configureCar()

        assertEquals("Toyota", car.brand)
        assertEquals("Camry", car.model)
        assertEquals(2022, car.year)
    }

    // 6
    @Test
    fun `test User creation with also logging`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val user = createUser(1, "Anna")

        assertEquals(1, user.id)
        assertEquals("Anna", user.name)
        assertTrue(outputStream.toString().contains("Creating user:"))

        System.setOut(System.out)
    }

    // 7
    @Test
    fun `test validateEmail with valid email`() {
        assertTrue(validateEmail("test@example.com"))
        assertTrue(validateEmail("USER@DOMAIN.COM")) // should be case-insensitive
        assertTrue(validateEmail("a@b.c"))
    }

    @Test
    fun `test validateEmail with invalid email`() {
        assertFalse(validateEmail("invalid-email"))
        assertFalse(validateEmail(""))
        assertFalse(validateEmail("@domain.com"))
        assertFalse(validateEmail("user@"))
        assertFalse(validateEmail(null))
    }

    // 8
    @Test
    fun `test indexedFilter returns correct pairs`() {
        val list = listOf("a", "b", "c", "d", "e")
        val result = list.indexedFilter { it in listOf("b", "d") }

        assertEquals(listOf(Pair(1, "b"), Pair(3, "d")), result)

        // Test with empty result
        val emptyResult = list.indexedFilter { it == "z" }
        assertTrue(emptyResult.isEmpty())

        // Test with numbers
        val numbers = listOf(1, 2, 3, 4, 5)
        val evenNumbers = numbers.indexedFilter { it % 2 == 0 }
        assertEquals(listOf(Pair(1, 2), Pair(3, 4)), evenNumbers)
    }


    // 9
    @Test
    fun `test getCompanyCountry with complete chain`() {
        val company = Company(
            "TechCorp",
            Address("Main St", City("NYC", "USA"))
        )

        assertEquals("USA", getCompanyCountry(company))
    }

    @Test
    fun `test getCompanyCountry with null address`() {
        val company = Company("Startup", null)
        assertNull(getCompanyCountry(company))
    }

    @Test
    fun `test getCompanyCountry with null city`() {
        val company = Company(
            "TechCorp",
            Address("Main St", null)
        )

        assertNull(getCompanyCountry(company))
    }

    @Test
    fun `test getCompanyCountry with null company`() {
        assertNull(getCompanyCountry(null))
    }
}
