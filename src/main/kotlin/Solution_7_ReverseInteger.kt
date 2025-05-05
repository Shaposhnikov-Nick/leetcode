/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
fun main() {
    val x = 1563847412
    val result = reverse(x)
    println(result)

}

fun reverse(x: Int): Int {
    var result = 0
    var num = Math.abs(x)
    val arr = mutableListOf<Int>()

    while (num > 0) {
        val digit = num % 10
        arr.add(digit)
        num /= 10
    }

    arr.reversed().forEachIndexed { index, digit ->
        val m = digit * Math.pow(10.0, index.toDouble()).toLong()
        if (m > Int.MAX_VALUE || result + m > Int.MAX_VALUE) return 0
        result += m.toInt()
    }

    return if (x > 0) result else 0 - result
}

fun reverse2(x: Int): Int {
    var num = x
    var result = 0

    while (num != 0) {
        val digit = num % 10
        num /= 10

        // Проверка на переполнение Int
        if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && digit > 7)) return 0
        if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && digit < -8)) return 0

        result = result * 10 + digit
    }

    return result

}

/**
 * Using toString()
 */
fun reverse3(x: Int): Int {
    val reversed = try {
        Math.abs(x).toString().reversed().toInt()
    } catch (e: NumberFormatException) {
        0
    }
    return if (x > 0) reversed else 0 - reversed
}