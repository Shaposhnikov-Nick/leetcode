/**
 * 735 Asteroid Collision
 *
 * Medium
 *
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 *
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 *
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
fun main() {
    val asteroids = intArrayOf(5, 10, -5, 7, -14, 8)
    println(asteroidCollision(asteroids).contentToString())
}

/**
 * Объяснение решения:
 *
 * Стек для отслеживания астероидов: Мы используем стек для хранения астероидов, которые еще могут столкнуться с последующими.
 *
 * Итерация по астероидам:
 *
 * Если стек пуст или текущий астероид движется вправо (положительный), мы просто добавляем его в стек.
 *
 * Если текущий астероид движется влево (отрицательный), нам нужно проверить возможные столкновения с астероидами в стеке.
 *
 * Обработка столкновений:
 *
 * Нет столкновений: Если верхний элемент стека тоже движется влево (отрицательный) или стек пуст, добавляем текущий астероид в стек.
 *
 * Уничтожение обоих астероидов: Если размеры астероидов равны (но противоположны по направлению), удаляем верхний элемент стека и не добавляем текущий астероид.
 *
 * Уничтожение текущего астероида: Если верхний астероид в стеке больше по размеру, текущий астероид уничтожается, и мы ничего не добавляем в стек.
 *
 * Уничтожение астероида в стеке: Если текущий астероид больше по размеру, удаляем верхний элемент стека и продолжаем проверять следующий астероид в стеке.
 *
 * Результат: После обработки всех астероидов преобразуем стек в массив и возвращаем его.
 */
fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = ArrayDeque<Int>()

    for (asteroid in asteroids) {
        if (stack.isEmpty() || asteroid > 0) {
            stack.addLast(asteroid)
        } else {
            while (true) {
                val top = stack.lastOrNull()
                when {
                    top == null || top < 0 -> {
                        stack.addLast(asteroid)
                        break
                    }

                    top == -asteroid -> {
                        stack.removeLast()
                        break
                    }

                    top > -asteroid -> break

                    else -> stack.removeLast()
                }
            }

        }
    }

    return stack.toIntArray()

}