package stepik.stack

import java.util.Arrays

/**
 * Стек с защитой от ошибок (1 балл)
 *
 * Напишите программу моделирующую работу стека.
 * Программа считывает последовательность команд и в зависимости от команды выполняет ту или иную операцию. После выполнения каждой команды программа должна вывести одну строчку. Возможные команды для программы:
 *
 * push n - Добавить в стек число n (значение n задается после команды). Программа должна вывести ok.
 * pop - Удалить из стека последний элемент. Программа должна вывести его значение.
 * back - Программа должна вывести значение последнего элемента, не удаляя его из стека.
 * size - Программа должна вывести количество элементов в стеке.
 * clear - Программа должна очистить стек и вывести ok.
 * exit - Программа должна вывести bye и завершить работу.
 * Перед исполнением операций back и pop программа должна проверять, содержится ли в стеке хотя бы один элемент. Если во входных данных встречается операция back или pop и при этом стек пуст, то программа должна вместо числового значения вывести строку error.
 *
 * Формат ввода
 *
 * Вводятся команды управления стеком, по одной на строке.
 *
 * Формат вывода
 *
 * Программа должна вывести протокол работы стека, по одному сообщению на строке.
 */
fun main() {
    val stack = ErrorProtectedStack()

    while (true) {
        val command = readln()
        stack.performCommand(command)

        if (command == "exit") break
    }
}

class ErrorProtectedStack {
    val capacity = 16
    var top = -1
    var elementData = IntArray(capacity)

    fun performCommand(commandString: String) {
        val keys = commandString.split(" ")
        val command = keys[0]
        val value = if (keys.size == 2) keys[1] else null

        when (command) {
            "push" -> push(value!!.toInt())
            "pop" -> pop()
            "back" -> back()
            "size" -> size()
            "clear" -> clear()
            "exit" -> exit()
        }
    }

    private fun push(value: Int) {
        if (isFull()) resize(elementData.size * 2)
        elementData[++top] = value
        println("ok")
    }

    private fun pop() {
        if (isEmpty())
            println("error")
        else
            println(elementData[top--])
    }

    private fun back() {
        if (isEmpty())
            println("error")
        else
            println(elementData[top])
    }

    private fun size() {
        println(top + 1)
    }

    private fun clear() {
        elementData = IntArray(capacity)
        top = -1
        println("ok")
    }

    private fun exit() {
        println("bye")
    }

    private fun isFull(): Boolean {
        return elementData.size - 1 == top
    }

    private fun isEmpty(): Boolean {
        return top == -1
    }

    private fun resize(newCapacity: Int) {
        elementData = elementData.copyOf(newCapacity)
    }
}