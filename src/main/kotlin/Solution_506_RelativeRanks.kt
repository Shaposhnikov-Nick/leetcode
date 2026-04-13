import java.util.*

fun main() {
    val score = intArrayOf(10, 3, 8, 9, 4)
    findRelativeRanks(score)
}

/**
 * Используем очередь с приоритетом для хранения баллов (reverseOrder() чтобы сортировка была по убыванию)
 * Добавляем в очередь баллы каждого участника
 * Берем из очереди баллы каждого участника
 * Ищем индекс этого участника в score
 * Определяем место участника
 */
fun findRelativeRanks(score: IntArray): Array<String> {
    // Используем очередь с приоритетом для хранения баллов (reverseOrder() чтобы сортировка была по убыванию)
    val heap = PriorityQueue<Int>(Comparator.reverseOrder())
    val answer = Array<String>(score.size) { "" }
    val prizePlaces = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal")

    // Добавляем в очередь баллы каждого участника
    score.forEach { heap.add(it) }

    var place = 1

    while (heap.isNotEmpty()) {
        val value = heap.poll()
        // Ищем индекс этого участника в score
        val index = score.indexOf(value)
        // Определяем место участника и добавляем в answer с тем же индексом
        when (place) {
            1 -> answer[index] = prizePlaces[0]
            2 -> answer[index] = prizePlaces[1]
            3 -> answer[index] = prizePlaces[2]
            else -> answer[index] = place.toString()
        }
        // увеличиваем счетчик места
        place++
    }

    return answer
}