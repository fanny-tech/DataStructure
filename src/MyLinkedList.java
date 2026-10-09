
    public class MyLinkedList<T> {
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head;
        private int size;


        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addLast(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        //removed
        public T removeFirst() {
            if (head == null) {
                return null;
            }
            T removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index iri hanze y'uburebure bwa list!");
            }
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }


        public int size() {
            return size;
        }


        public void reverse() {
            Node<T> prev = null;
            Node<T> current = head;
            Node<T> next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }


        public T findMiddle() {
            if (head == null) {
                return null;
            }
            Node<T> slow = head;
            Node<T> fast = head;


            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
    }

