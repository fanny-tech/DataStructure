
    class MyStack<T> {
        private MyLinkedList<T> list;

        public MyStack() {
            list = new MyLinkedList<>();
        }

        public void push(T data) {
            list.addFirst(data);
        }

        public T pop() {
            return list.removeFirst();
        }

        public T peek() {
            return list.get(0);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }


    class MyQueue<T> {
        private MyStack<T> stackIn;
        private MyStack<T> stackOut;

        public MyQueue() {
            stackIn = new MyStack<>();
            stackOut = new MyStack<>();
        }

        public void enqueue(T data) {
            stackIn.push(data);
        }

        public T dequeue() {
            shiftStacks();
            return stackOut.pop();
        }

        public T peek() {
            shiftStacks();
            return stackOut.peek();
        }

        public boolean isEmpty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }


        private void shiftStacks() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }
    }


    class ExpressionValidator {
        public static boolean isBalanced(String expr) {
            MyStack<Character> stack = new MyStack<>();

            for (int i = 0; i < expr.length(); i++) {
                char ch = expr.charAt(i);

                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }

                else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((ch == ')' && top != '(') ||
                            (ch == '}' && top != '{') ||
                            (ch == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

