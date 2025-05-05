package stepik

fun main() {
    println(factorial(5))
}

fun factorial(i: Int): Long {
    return if (i == 0) 1 else i * factorial(i - 1)
}

