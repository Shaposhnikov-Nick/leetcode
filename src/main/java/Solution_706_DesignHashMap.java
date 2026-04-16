public class Solution_706_DesignHashMap {
    public static void main(String[] args) {
        var map = new MyHashMap2();
        map.put(1, 1);
    }
}

class MyHashMap2 {
    // вложенный класс для хранения значений в связном списке
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // массив для хранения связных списков (бакеты)
    private int capacity = 1000;
    private Node[] table;

    public MyHashMap2() {
        this.table = new Node[capacity];
    }

    public void put(int key, int value) {
        // высчитываем индекс бакета и берем отуда значение
        var index = key % capacity;
        var node = table[index];

        // если значения нет, создаем новую Node и добавляем в бакет
        if (node == null) {
            table[index] = new Node(key, value);
            return;
        }

        // ищем в связном списке узел с таким же ключом
        var current = node;
        while (current != null) {
            // если находим, меняем его значение
            if (current.key == key) {
                current.value = value;
                return;
            } else if (current.next == null) {
                // если узла с таким ключом нет, добавляем новый узел последним в списке
                var newNode = new Node(key, value);
                current.next = newNode;
                newNode.prev = current;
                return;
            }
            current = current.next;
        }
    }

    public int get(int key) {
        // высчитываем индекс бакета и берем отуда значение
        var index = key % capacity;
        var node = table[index];

        if (node == null) return -1;

        // проходим по всему списку и если находим узел с таким ключом, возвращаем его значение
        var current = node;
        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }

        // если не нашли, возвращаем -1
        return -1;
    }

    public void remove(int key) {
        // высчитываем индекс бакета и берем отуда значение
        var index = key % capacity;
        var node = table[index];

        if (node == null) return;

        // проходим по списку и ием узел с таким ключом
        var current = node;
        while (current != null) {
            // если находим
            if (current.key == key) {
                // и это первый узел в списке
                if (current.prev == null) {
                    // меняем ссылку в бакете на второй узел
                    table[index] = current.next;
                    // у второго узла зануляем ссылку на предыдущий узел
                    if (current.next != null)
                        current.next.prev = null;
                } else {
                    // иначе меняем ссылку предыдущего узла на следующий после current
                    current.prev.next = current.next;
                    // если следующий узел не null, меняем у него сслыку на предыдущий
                    if (current.next != null)
                        current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }
}