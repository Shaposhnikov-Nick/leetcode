/**
 * 706 Design HashMap
 *
 * Easy
 *
 * Design a HashMap without using any built-in hash table libraries.
 *
 * Implement the MyHashMap class:
 *
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 */
fun main() {
    val map = MyHashMap()
    map.put(1, 1)
    map.put(2, 2)
    map.put(1, 3)
    val v = map.get(1)
    map.remove(1)
}

class MyHashMap {
    private val capacity = 1000

    // массив для хранения связных списков (бакеты)
    private val table = Array<Node?>(capacity) { null }

    // вложенный класс для хранения значений в связном списке
    class Node(var key: Int, var value: Int) {
        var next: Node? = null
        var prev: Node? = null
    }

    fun put(key: Int, value: Int) {
        // высчитываем индекс бакета и берем отуда значение
        val index = key % capacity
        val node = table[index]

        // если значения нет, создаем новую Node и добавляем в бакет
        if (node == null) {
            table[index] = Node(key, value)
            return
        }

        // ищем в связном списке узел с таким же ключом
        var current = node
        while (current != null) {
            // если находим, меняем его значение
            if (current.key == key) {
                current.value = value
            } else if (current.next == null) {
                // если узла с таким ключом нет, добавляем новый узел последним в списке
                val newNode = Node(key, value)
                current.next = newNode
                newNode.prev = current
                return
            }
            current = current.next
        }
    }

    fun get(key: Int): Int {
        // высчитываем индекс бакета и берем отуда значение
        val index = key % capacity
        val node = table[index] ?: return -1

        // проходим по всему списку и если находим узел с таким ключом, возвращаем его значение
        var current: Node? = node
        while (current != null) {
            val node = current
            if (node.key == key) return node.value
            current = current.next
        }

        // если не нашли, возвращаем -1
        return -1
    }

    fun remove(key: Int) {
        // высчитываем индекс бакета и берем отуда значение
        val index = key % capacity
        val node = table[index] ?: return

        // проходим по списку и ием узел с таким ключом
        var current: Node? = node
        while (current != null) {
            // если находим
            if (current.key == key) {
                // и это первый узел в списке
                if (current.prev == null) {
                    // меняем ссылку в бакете на второй узел
                    table[index] = current.next
                    // у второго узла зануляем ссылку на предыдущий узел
                    current.next?.prev = null
                } else {
                    // иначе меняем ссылку предыдущего узла на следующий после current
                    current.prev!!.next = current.next
                    // если следующий узел не null, меняем у него сслыку на предыдущий
                    if (current.next != null)
                        current.next?.prev = current.prev
                }
                return
            }

            current = current.next
        }

    }
}