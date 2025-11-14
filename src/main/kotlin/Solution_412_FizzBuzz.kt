/**
 * 412 Fizz Buzz
 *
 * Easy
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 *
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
fun main() {
    val n = 5
    fizzBuzz(n)
}

fun fizzBuzz(n: Int): List<String> {
    val list = mutableListOf<String>()
    for (i in 1..n) {
        val value = when {
            i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i.toString()
        }
        list.add(value)
    }

    return list
}

fun fizzBuzz2(n: Int): List<String> {
    return (1..n).map { i ->
        val divBy3 = i % 3 == 0
        val divBy5 = i % 5 == 0
        when {
            divBy3 && divBy5 -> "FizzBuzz"
            divBy3 -> "Fizz"
            divBy5 -> "Buzz"
            else -> i.toString()
        }
    }
}