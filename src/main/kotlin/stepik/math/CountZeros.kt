package stepik.math

fun main() {
    val n = readln().toLong()
    println(countZeros(n))
}

/**
 * Подсчет нулей в числе
 */
fun countZeros(n: Long): Int{
    var num = n
    var count = 0

    while (num > 1) {
        val digit = num % 10
        if (digit.toInt() == 0) count++
        num /= 10
    }

    return count
}