package task_1

// 1. Объяви переменную типа String? (nullable) и присвой ей null
val nullableString: String? = null

// 2. Напиши безопасный вызов для получения длины строки или верни 0 если строка null
fun safeStringLength(str: String?): Int = str?.length ?: 0

// 3. Используй elvis-оператор с throw для обязательного параметра
fun requireNonNull(value: String?): String = value ?: throw IllegalArgumentException("Value cannot be null")

// 4. Используй let, чтобы вывести строку в консоль только если она не null
fun printIfNotNull(str: String?) {
    str?.let { println(it) }
}

// 5. Напиши функцию, возвращающую Unit, которая ничего не делает
fun doNothing(): Unit {
    // Функция ничего не делает, возвращает Unit по умолчанию
}

// 6. Создай функцию, которая никогда не завершается (возвращает Nothing)
fun neverEnding(): Nothing {
    throw RuntimeException("This function never ends")
}

// 7. Реализуй функцию task_1.smartCast, которая использует when и умные приведения типов
fun smartCast(value: Any): String = when (value) {
    is String -> "String: $value"
    is Int -> "Int: $value"
    is Double -> "Double: $value"
    is Boolean -> "Boolean: $value"
    else -> "Unknown type"
}