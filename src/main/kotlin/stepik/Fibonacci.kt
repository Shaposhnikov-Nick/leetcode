package stepik

fun main() {
    val list = (0..10).map { fibonacci(it) }
    val list2 = fibonacciList(10)
    println(list.joinToString(separator = ", "))
    println(list2.joinToString(separator = ", "))
    println("Sum: ${fibonacciSum(10)}")
}

/**
 * O(n2)
 */
fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}

/**
 * O(n)
 */
fun fibonacciList(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    list.add(0)
    list.add(1)

    for (i in 2..n) {
        list.add(list[i - 1] + list[i - 2])
    }

    return list
}

/**
 * Функция для суммы n первых чисел Фибоначчи:
 */
fun fibonacciSum(n: Int): Int {
    if (n <= 0) return 0
    if (n == 1) return 0
    if (n == 2) return 1

    var a = 0
    var b = 1
    var sum = a + b

    for (i in 2 until n) {
        val next = a + b
        sum += next
        a = b
        b = next
    }

    return sum
}