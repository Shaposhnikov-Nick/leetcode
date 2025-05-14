package stepik.math

fun main() {
    val input = readln().split(" ")
    val base = input[0].toDouble()
    val exponent = input[1].toInt()
    println(String.format("%.2f", calculatePower(base, exponent)))
}

/**
 * Рекурсивоное возведение в степень
 */
fun calculatePower(base: Double, exponent: Int): Double {
    return if (exponent == 1) base else base * calculatePower(base, exponent - 1)
}