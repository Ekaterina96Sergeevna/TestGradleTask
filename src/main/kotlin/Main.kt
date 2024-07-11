fun main(args: Array<String>) {
    println("args")
    println(args[0])

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11) // должен быть отсортирован для бинарного поиска
    val value = 7
    println(binarySearch(list, value))
}

// бинарный поиск с рекурсией
fun binarySearch(list: List<Int>, value: Int): String {
    println(list)
    val midValue = list.size/2

    return if(list[midValue] == value) {
        "It was found! - ${list[midValue]}"
    } else {
        if(list[midValue] > value) {
            println("Теперь ищем вначале списка ${list.dropLast(midValue)}, дропнули последние $midValue")
            binarySearch(list.dropLast(midValue), value)
        } else {
            println("Теперь ищем в конце списка ${list.drop(midValue)}, дропнули первые $midValue")
            binarySearch(list.drop(midValue), value)
        }
    }
}
