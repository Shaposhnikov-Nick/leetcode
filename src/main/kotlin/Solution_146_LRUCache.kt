/**
 * 146 LRU Cache
 *
 * Medium
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
fun main() {
    val lRUCache = LRUCache2(2)
    lRUCache.put(1, 1) // cache is {1=1}
    lRUCache.put(2, 2) // cache is {1=1, 2=2}
    lRUCache.get(1) // return 1
    lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2) // returns -1 (not found)
    lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1) // return -1 (not found)
    lRUCache.get(3) // return 3
    lRUCache.get(4) // return 4
}

/**
 * Идея
 * Нужна структура, которая одновременно:
 * Быстро находит элемент по ключу — O(1) → хеш-таблица (dict / HashMap)
 * Отслеживает порядок использования — чтобы знать, кто «самый давний» → двусвязный список
 * Комбинация этих двух структур даёт O(1) на get и put.
 *
 * Почему именно двусвязный список?
 * Массив — удаление/перемещение элемента из середины O(n).
 * Односвязный список — нельзя удалить узел за O(1), не имея ссылки на предыдущий.
 * Двусвязный список — у каждого узла есть prev и next, поэтому удаление и вставка узла за O(1), если у нас есть ссылка на сам узел.
 *
 * Структура данных
 * Хеш-таблица: key → узел двусвязного списка
 * Узел хранит:
 * key
 * value
 * prev
 * next
 *
 * Двусвязный список используется как «очередь порядка использования»:
 * Голова (head) — самый недавно использованный (Most Recently Used, MRU)
 * Хвост (tail) — самый давний (Least Recently Used, LRU)
 *
 * head <-> [MRU] <-> ... <-> [LRU] <-> tail
 *
 * Операции
 * Вспомогательные (работают за O(1))
 * addToHead(node) — вставить узел сразу после head (пометить как «только что использованный»)
 * removeNode(node) — вынуть узел из списка (связать его prev и next напрямую)
 * moveToHead(node) = removeNode(node) + addToHead(node)
 * removeTail() — удалить узел перед tail (это и есть LRU-жертва)
 *
 * get(key)
 * Если ключа нет в хеш-таблице → вернуть -1.
 * Если есть → взять узел, переместить его в голову (он стал недавно использованным), вернуть value.
 *
 * put(key, value)
 * Если ключ уже есть:
 * обновить value в узле,
 * переместить узел в голову.
 *
 * Если ключа нет:
 * создать новый узел,
 * добавить в хеш-таблицу и в голову списка,
 * если размер превысил capacity:
 * удалить хвостовой узел (LRU),
 * удалить его ключ из хеш-таблицы.
 *
 * Ключевые моменты, которые легко забыть
 * В узле нужно хранить key, а не только value. Иначе при вытеснении хвоста мы не сможем удалить запись из хеш-таблицы (нам нужен ключ).
 *
 * Dummy head/tail сильно упрощают код — не нужно проверять null у соседей.
 *
 * При get тоже нужно обновлять порядок (move to head), иначе LRU-логика сломается.
 *
 * При обновлении существующего ключа через put — тоже move to head.
 */
class LRUCache2(capacity: Int) {
    // вместимость кэша
    val dataCapacity = capacity

    // кэш
    val data = HashMap<Int, Node>()
    val head = Node(-1, -1)
    val tail = Node(-2, -2)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = data[key] ?: return -1
        // двигаем узел в начало как MRU
        moveToHead(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = data[key]

        // если узел с таким ключом существует
        if (node != null) {
            // изменяем значение
            node.value = value
            // двигаем узел в начало как MRU
            moveToHead(node)
        } else {
            // проверяем заполнен ли кэш
            if (data.size >= dataCapacity) {
                // последний использованный элемент
                val lru = tail.prev!!
                // удаляем его
                removeNode(lru)
                data.remove(lru.key)
            }
            // создаем новый узел
            val node = Node(key, value)
            data[key] = node
            // двигаем узел в начало как MRU
            moveToHead(node)
        }
    }

    private fun addToHead(node: Node) {
        val lastMru = head.next
        head.next = node
        node.next = lastMru
        lastMru?.prev = node
        node.prev = head
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        node.prev = null
        node.next = null
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    class Node(
        var key: Int,
        var value: Int
    ) {
        var next: Node? = null
        var prev: Node? = null
    }

}