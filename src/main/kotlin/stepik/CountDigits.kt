package stepik

/**
 * Подсчет количества цифр в числе
 */
fun main() {
//    val n = readln().toInt();
    val result = countDigits(123)
    println(result)
}

fun countDigits(n: Int): Int {
    var c = Math.abs(n)
    var count = 1
    while (c >= 10) {
        c /= 10
        count++
    }
    return count
}