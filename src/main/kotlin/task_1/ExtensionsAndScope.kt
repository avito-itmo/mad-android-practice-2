package task_1

// 1. Добавь функцию-расширение isPositive для Int
fun Int.isPositive(): Boolean = this > 0

// 2. Добавь extension-свойство isEven для Int
val Int.isEven: Boolean
    get() = this % 2 == 0

// 3. Создай extension-функцию для String, которая возвращает самую частую букву
fun String.mostFrequentChar(): Char? {
    if (this.isBlank()) return null

    return this.lowercase()
        .filter { it.isLetter() } // Игнорируем пробелы и знаки препинания
        .groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }
        ?.key
}

// 4. Используй let, чтобы преобразовать строку в число и вернуть 0 если null
fun safeParseInt(str: String): Int = str.toIntOrNull() ?: 0

// 5. Используй `apply` для настройки объекта Car
data class Car(var brand: String = "", var model: String = "", var year: Int = 0)

fun configureCar(): Car = Car().apply {
    brand = "Toyota"
    model = "Camry"
    year = 2022
}

// 6. Используй `also` для логирования создания объекта User
data class User(val id: Int, val name: String)

fun createUser(id: Int, name: String): User = User(id, name).also {
    println("Creating user: ${it.name}")
}

// 7. Используй `let` с именованным параметром для лучшей читаемости
fun validateEmail(email: String?): Boolean = email?.let { emailString ->
    emailString.lowercase().contains("@") &&
            emailString.contains(".") &&
            emailString.indexOf("@") < emailString.lastIndexOf(".") &&
            emailString.indexOf("@") > 0
} ?: false

// 8. Реализуй extension-функцию для List<T> с использованием withIndex и scope-функций
fun <T> List<T>.indexedFilter(predicate: (T) -> Boolean): List<Pair<Int, T>> =
    this.withIndex()
        .filter { (_, value) -> predicate(value) }
        .map { (index, value) -> index to value }
