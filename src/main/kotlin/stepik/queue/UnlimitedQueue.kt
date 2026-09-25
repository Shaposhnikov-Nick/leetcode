package stepik.queue

/**
 * 3.6 Очередь
 * Очередь неограниченного размера (1 балл)
 *
 * Реализуйте структуру данных "очередь".  Напишите программу, содержащую описание очереди и моделирующую работу очереди, реализовав все указанные здесь методы. Программа считывает последовательность команд и в зависимости от команды выполняет ту или иную операцию. После выполнения каждой команды программа должна вывести одну строчку. Возможные команды для программы:
 *
 * push
 * Добавить в очередь число n (значение n задается после команды). Программа должна вывести ok.
 *
 * pop
 * Удалить из очереди первый элемент. Программа должна вывести его значение.
 *
 * front
 * Программа должна вывести значение первого элемента, не удаляя его из очереди.
 *
 * size
 * Программа должна вывести количество элементов в очереди.
 *
 * clear
 * Программа должна очистить очередь и вывести ok.
 *
 * exit
 * Программа должна вывести bye и завершить работу.
 *
 * Размер очереди должен быть ограничен только размером доступной оперативной памяти.
 * Перед исполнением операций front и pop программа должна проверять, содержится ли в очереди хотя бы один элемент.
 * Если во входных данных встречается операция front или pop, и при этом очередь пуста,
 * то программа должна вместо числового значения вывести строку error.
 *
 * Входные данные
 * Вводятся команды управления очередью, по одной на строке.
 *
 * Выходные данные
 * Требуется вывести протокол работы очереди, по одному сообщению на строке.
 */
fun main() {
    val queue = UnlimitedQueue()

    while (true) {
        val command = readln()
        if (command == "exit") break
        queue.performCommand(command)
    }

    print("bye")
}

class UnlimitedQueue {
    private val capacity = 16
    private val elementData = ArrayDeque<Int>(capacity)

    fun performCommand(commandStr: String) {
        val keys = commandStr.split(" ")
        val command = keys[0]
        val value = if (keys.size == 2) keys[1].toInt() else null

        when (command) {
            "push" -> push(value!!)
            "pop" -> pop()
            "front" -> front()
            "size" -> size()
            "clear" -> clear()
        }
    }

    private fun push(value: Int) {
        elementData.addLast(value)
        println("ok")
    }

    private fun pop() {
        if (isEmpty())
            println("error")
        else
            println(elementData.removeFirst())
    }

    private fun front() {
        if (isEmpty())
            println("error")
        else
            println(elementData.first())
    }

    private fun size() {
        println(elementData.size)
    }

    private fun clear() {
        elementData.clear()
        println("ok")
    }

    private fun isEmpty() = elementData.isEmpty()
}