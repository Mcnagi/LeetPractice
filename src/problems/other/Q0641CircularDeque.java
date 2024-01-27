package problems.other;

public class Q0641CircularDeque {
  public static class MyCircularDeque {
    private int[] array;
    private int front;
    private int size;
    private final int MAX_SIZE;

    public MyCircularDeque(int k) {
      this.array = new int[k];
      this.front = 0;
      this.size = 0;
      this.MAX_SIZE = k;
    }

    public boolean insertFront(int value) {
      if (size >= MAX_SIZE) return false;
      array[front] = value;
      front = (front - 1 + MAX_SIZE) % MAX_SIZE;
      size += 1;
      return true;
    }

    public boolean insertLast(int value) {
      if (size >= MAX_SIZE) return false;
      array[(front + size + 1) % MAX_SIZE] = value;
      size += 1;
      return true;
    }

    public boolean deleteFront() {
      if (size == 0) return false;
      front = (front + 1) % MAX_SIZE;
      array[front] = 0;
      size -= 1;
      return true;
    }

    public boolean deleteLast() {
      if (size == 0) return false;
      array[(front + size) % MAX_SIZE] = 0;
      size -= 1;
      return true;
    }

    public int getFront() {
      if (size == 0) return -1;
      return array[(front + 1) % MAX_SIZE];
    }

    public int getRear() {
      if (size == 0) return -1;
      return array[(front + size) % MAX_SIZE];
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean isFull() {
      return size == MAX_SIZE;
    }
  }
}
