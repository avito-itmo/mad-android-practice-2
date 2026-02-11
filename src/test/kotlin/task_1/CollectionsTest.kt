package task_1

import org.junit.jupiter.api.Test
import kotlin.test.*

class CollectionsTest {

    // 1
    @Test
    fun `test immutableList contains numbers 1 to 5`() {
        assertEquals(listOf(1, 2, 3, 4, 5), immutableList)
        // Проверяем, что это действительно неизменяемый список
        // listOf возвращает List, который не является MutableList
        assertTrue(immutableList is List<Int>)
    }

    // 2
    @Test
    fun `test mutableSet can be modified`() {
        assertTrue(mutableSet is MutableSet<String>)

        // Test adding elements
        mutableSet.add("test")
        assertTrue(mutableSet.contains("test"))

        // Clear for next test
        mutableSet.clear()
    }

    // 3
    @Test
    fun `test ageMap contains name-age pairs`() {
        // Assuming the map is initialized with some values
        assertTrue(ageMap is Map<String, Int>)

        // Test map operations
        assertEquals(ageMap.size, ageMap.keys.size)

        // All values should be Int
        assertTrue(ageMap.values.all { it is Int })
    }

    // 4
    @Test
    fun `test filterNotNull removes nulls`() {
        val input = listOf(1, null, "hello", null, 3.14)
        val result = filterNotNull(input)

        assertEquals(listOf(1, "hello", 3.14), result)
        assertTrue(result.none { it == null })
    }

    @Test
    fun `test filterNotNull with empty list`() {
        val input = emptyList<Any?>()
        val result = filterNotNull(input)

        assertTrue(result.isEmpty())
    }

    // 5
    @Test
    fun `test sumOfEvenNumbers calculates correctly`() {
        assertEquals(6, sumOfEvenNumbers(listOf(1, 2, 3, 4))) // 2 + 4 = 6
        assertEquals(0, sumOfEvenNumbers(listOf(1, 3, 5))) // no even numbers
        assertEquals(12, sumOfEvenNumbers(listOf(2, 4, 6))) // all even
        assertEquals(0, sumOfEvenNumbers(emptyList()))
    }

    // 6
    @Test
    fun `test mapToLengths transforms strings to lengths`() {
        assertEquals(listOf(3, 5), mapToLengths(listOf("hey", "hello")))
        assertEquals(listOf(0), mapToLengths(listOf("")))
        assertEquals(emptyList<Int>(), mapToLengths(emptyList()))
    }

    // 7
    @Test
    fun `test groupAndCount groups by first letter`() {
        val words = listOf("apple", "apricot", "banana", "blueberry", "cherry")
        val result = groupAndCount(words)

        assertEquals(mapOf('a' to 2, 'b' to 2, 'c' to 1), result)

        // Test case insensitivity
        val wordsMixed = listOf("Apple", "apricot", "Banana")
        val resultMixed = groupAndCount(wordsMixed)
        assertEquals(mapOf('a' to 2, 'b' to 1), resultMixed)
    }

    @Test
    fun `test groupAndCount with empty list`() {
        assertTrue(groupAndCount(emptyList()).isEmpty())
    }

    // 8
    @Test
    fun `test deepCopy creates independent copy`() {
        val original = listOf(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6)
        )

        val copy = deepCopy(original)

        // Modify the copy
        copy[0][0] = 999
        copy[1].add(7)

        // Original should remain unchanged
        assertEquals(1, original[0][0])
        assertEquals(3, original[0].size) // original list should still have 3 elements
        assertEquals(3, original[1].size) // original should not have the added element
    }
}
