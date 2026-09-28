import java.util.HashMap;

public class Solution_146_LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}

class LRUCache {
    // кэш
    HashMap<Integer, Node> data = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-2, -2);
    // вместимость кэша
    int dataCapacity;

    public LRUCache(int capacity) {
        this.dataCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        var node = data.get(key);
        if (node == null) return -1;
        // двигаем узел в начало как MRU
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        var node = data.get(key);

        // если узел с таким ключом существует
        if (node != null) {
            // изменяем значение
            node.value = value;
            // двигаем узел в начало как MRU
            moveToHead(node);
        } else {
            // проверяем заполнен ли кэш
            if (data.size() >= dataCapacity) {
                // последний использованный элемент
                var lru = tail.prev;
                // удаляем его
                removeNode(lru);
                data.remove(lru.key);
            }
            // создаем новый узел
            node = new Node(key, value);
            data.put(key, node);
            // двигаем узел в начало как MRU
            moveToHead(node);
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        var lastMru = head.next;
        head.next = node;
        node.next = lastMru;
        node.prev = head;
        lastMru.prev = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}