/**
 * 705 Design HashSet
 *
 * Easy
 *
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 *
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 *
 *
 * Constraints:
 *
 * 0 <= key <= 106
 * At most 104 calls will be made to add, remove, and contains.
 */
fun main() {
    val mySet = MyHashSet2()
}

class MyHashSet2() {
    private val capacity = 1000

    // массив для хранения связных списков (бакеты)
    private val table = Array<Node?>(capacity) { null }

    // вложенный класс для хранения значений в связном списке
    class Node(
        val value: Int
    ) {
        var next: Node? = null
        var prev: Node? = null
    }


    fun add(key: Int) {
        // высчитываем индекс бакета и берем отуда значение
        val index = key % capacity
        val node = table[index]

        // если значения нет, создаем новую Node  добавляем в бакет
        if (node == null) {
            val newNode = Node(key)
            table[index] = newNode
            return
        }

        // иначе проверяем, есть ли в связном списке такое значени
        // и если оно отсутствует, то добавляем
        if (!contains(key)) {
            val newNode = Node(key)
            node.prev = newNode
            newNode.next = node
            table[index] = newNode
        }
    }

    fun remove(key: Int) {
        // высчитываем индекс бакета и берем отуда значение
        //если бакет пуст - return
        val index = key % capacity
        val node = table[index] ?: return

        // если есть узлы, обходим весь связный список в поисках нужного числа
        var current: Node? = node
        while (current != null) {
            // если находим такое значение
            if (current.value == key) {
                // если оно в первом узле
                if (current.prev == null) {
                    // меняем ссылку в бакете на следующий узел
                    table[index] = current.next
                    // зануляем у него ссылку на предыдущий узел
                    if (current.next != null) current.next?.prev = null
                } else {
                    // исключаем узел из списка
                    current.prev?.next = current.next
                    if (current.next != null) {
                        current.next?.prev = current.prev
                    }
                }

                return
            }

            current = current.next
        }

    }

    fun contains(key: Int): Boolean {
        // высчитываем индекс бакета и берем отуда значение
        val index = key % capacity
        val node = table[index] ?: return false

        // обходим весь связный список и если находим искомое значение, возвращаем true
        var current: Node? = node
        while (current != null) {
            if (current.value == key) return true
            current = current.next
        }

        return false
    }

}