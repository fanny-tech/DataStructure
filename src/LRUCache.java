

    import java.util.HashMap;

    public class LRUCache {
        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final HashMap<Integer, Node> map;
        private final Node head;
        private final Node tail;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();

            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }


        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            remove(node);
            addToFront(node);

            return node.value;
        }


        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                addToFront(node);
            } else {
                if (map.size() >= capacity) {

                    Node lru = tail.prev;
                    remove(lru);
                    map.remove(lru.key);
                }

                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToFront(newNode);
            }
        }


        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2); // Capacity ni 2

            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println("Get 1: " + cache.get(1));

            cache.put(3, 3);
            System.out.println("Get 2: " + cache.get(2));

            cache.put(4, 4);
            System.out.println("Get 1: " + cache.get(1));
            System.out.println("Get 3: " + cache.get(3));
            System.out.println("Get 4: " + cache.get(4));
        }
    }

