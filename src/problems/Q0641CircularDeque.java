package problems;

public class Q0641CircularDeque {
    public static class MyCircularDeque {
        private int[] array;
        private int front;
        private int rear;
        private int size;
        private final int MAX_SIZE;
        public MyCircularDeque(int k) {
            this.array = new int[2 * k];
            this.front = k - 1;
            this.rear = k;
            this.size = 0;
            this.MAX_SIZE = k;
        }

        public boolean insertFront(int value) {
            if (front < 0 || size >= MAX_SIZE) return false;
            array[front] = value;
            front -= 1;
            size += 1;
            return true;
        }

        public boolean insertLast(int value) {
            if (rear >= array.length || size >= MAX_SIZE) return false;
            array[rear] = value;
            rear += 1;
            size += 1;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) return false;
            array[++front] = 0;
            size -= 1;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) return false;
            array[--rear] = 0;
            size -= 1;
            return true;
        }

        public int getFront() {
            if (size == 0) return -1;
            return array[front + 1];
        }

        public int getRear() {
            if (size ==0) return -1;
            return array[rear - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == MAX_SIZE;
        }
    }
}
