package task_1

// 1. Создай неизменяемый список (List) чисел от 1 до 5
val immutableList: List<Int> = listOf(1, 2, 3, 4, 5)

// 2. Создай изменяемый набор (MutableSet) строк
val mutableSet: MutableSet<String> = mutableSetOf()

// 3. Создай map: ключ - имя, значение - возраст
val ageMap: Map<String, Int> = mapOf(
    "Alice" to 25,
    "Bob" to 30,
    "Charlie" to 35
)

// 4. Реализуй функцию, которая принимает List<Any?> и возвращает List<Any>
fun filterNotNull(list: List<Any?>): List<Any> = list.filterNotNull()

// 5. Отфильтруй список, оставив только чётные числа, и верни сумму
fun sumOfEvenNumbers(list: List<Int>): Int = list
    .filter { it % 2 == 0 }
    .sum()

// 6. Используй map, чтобы преобразовать список строк в список их длин
fun mapToLengths(strings: List<String>): List<Int> = strings.map { it.length }

// 7. Реализуй функцию, которая группирует слова по первой букве и считает их частоту
fun groupAndCount(words: List<String>): Map<Char, Int> = words
    .groupBy { it.first().lowercaseChar() } // Группируем по первой букве (нижний регистр)
    .mapValues { (_, value) -> value.size } // Преобразуем группы в их размер

// 8. Реализуй функцию deepCopy для вложенных изменяемых коллекций
fun <T> deepCopy(source: List<List<T>>): List<MutableList<T>> =
    source.map { innerList -> innerList.toMutableList() }