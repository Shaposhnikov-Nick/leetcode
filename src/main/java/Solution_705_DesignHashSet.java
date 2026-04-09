public class Solution_705_DesignHashSet {
    public static void main(String[] args) {
        var mySet = new MyHashSet();
        mySet.add(1);
        mySet.add(2);
        mySet.remove(1);
        // mySet.add(1);
        mySet.contains(2);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class MyHashSet {

    // вложенный класс для хранения значений в связном списке
    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    // массив для хранения связных списков (бакеты)
    private Node[] table;
    private int capacity = 1000;

    public MyHashSet() {
        table = new Node[capacity];
    }

    public void add(int key) {
        // высчитываем индекс бакета и берем отуда значение
        var index = key % capacity;
        var node = table[index];
        // если значения нет, создаем новую Node  добавляем в бакет
        if (node == null) {
            node = new Node(key);
            table[index] = node;
        } else {
            // иначе проверяем, есть ли в связном списке такое значени
            // и если оно отсутствует, то добавляем
            if (!contains(key)) {
                var newNode = new Node(key);
                node.prev = newNode;
                newNode.next = node;
                table[index] = newNode;
            }

        }
    }

    public void remove(int key) {
        // высчитываем индекс бакета и берем отуда значение
        var index = key % capacity;
        var node = table[index];
        //если бакет пуст - return
        if (node == null) return;

        // если есть узлы, обходим весь связный список в поисках нужного числа
        var current = node;
        while (current != null) {
            // если находим такое значение
            if (current.value == key) {
                // если оно в первом узле
                if (current.prev == null) {
                    // меняем ссылку в бакете на следующий узел
                    table[index] = current.next;
                    // зануляем у него ссылку на предыдущий узел
                    if (table[index] != null) {
                        table[index].prev = null;
                    }
                } else {
                    // исключаем узел из списка
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(int key) {
        // высчитываем индекс бакета и берем отуда значение
        var index = key % capacity;
        var node = table[index];
        if (node == null) return false;

        // обходим весь связный список и если находим искомое значение, возвращаем true
        var current = node;
        while (current != null) {
            if (current.value == key) return true;
            current = current.next;
        }

        return false;
    }
}