package task_1

// 1. Добавь функцию-расширение isPositive для Int
// TODO

// 2. Добавь extension-свойство isEven для Int
// TODO

// 3. Создай extension-функцию для String, которая возвращает самую частую букву (игнорируя регистр)
fun String.mostFrequentChar(): Char? {
    TODO()
}

// 4. Используй let, чтобы преобразовать строку в число и вернуть 0 если null (метод toIntOrNull)
fun safeParseInt(str: String): Int = TODO()

// 5. Используй `apply` для настройки объекта Car
//    Установи марку "Toyota", модель "Camry" и год 2022
data class Car(var brand: String = "", var model: String = "", var year: Int = 0)

fun configureCar(): Car {
    val car = Car()
    TODO()
}

// 6. Используй `also` для логирования создания объекта User
//    Выведи в консоль "Creating user: [имя]" перед возвратом объекта
data class User(val id: Int, val name: String)

fun createUser(id: Int, name: String): User = TODO()


// 7. Используй `let` с именованным параметром для лучшей читаемости
//    Преобразуй email к нижнему регистру и проверь правильность email
fun validateEmail(email: String?): Boolean = TODO()

// 8. Реализуй extension-функцию для List<T> с использованием withIndex и scope-функций,
//    которая возвращает пары (index, элемент) для элементов, удовлетворяющих предикату
fun <T> List<T>.indexedFilter(predicate: (T) -> Boolean): List<Pair<Int, T>> = TODO()

// 9. Напиши цепочку scope-функций для безопасной навигации по вложенным nullable-объектам
data class Company(val name: String, val address: Address?)
data class Address(val street: String, val city: City?)
data class City(val name: String, val country: String)

fun getCompanyCountry(company: Company?): String? = TODO()
