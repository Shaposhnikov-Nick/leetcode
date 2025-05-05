package stepik

fun main() {
    val list = (0..10).map { fibonacci(it) }
    println(list.joinToString(separator = ", "))
}

fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}