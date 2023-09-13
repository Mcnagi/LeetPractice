package problems;

import java.util.HashMap;
import java.util.Map;

public class Q0146LRUCache {
  LRUCache lruCache;

  public Q0146LRUCache(int capacity) {
    this.lruCache = new LRUCache(capacity);
  }

  class LRUCache {

    class Entry {
      int key;
      int value;
      Entry prev;
      Entry next;

      public Entry(int key, int value) {
        this.key = key;
        this.value = value;
      }

      public void remove() {
        prev.next = this.next;
        if (this.next != null) this.next.prev = this.prev;
      }
    }

    Entry head;
    Entry current;
    final int CAPACITY;
    Map<Integer, Entry> keyToEntry = new HashMap<>();
    int size = 0;

    public LRUCache(int capacity) {
      this.CAPACITY = capacity;
      this.head = new Entry(-1, -1);
      this.current = head;
    }

    public void addEntry(int key, int value) {
      Entry tmp = new Entry(key, value);
      tmp.prev = this.current;
      this.current.next = tmp;
      this.current = tmp;
      keyToEntry.put(key, tmp);
      size += 1;
    }

    public void removeEntry(int key) {
      Entry entry = keyToEntry.get(key);
      if (current == keyToEntry.get(key)) current = entry.prev;
      entry.remove();
      keyToEntry.remove(key);
      size -= 1;
    }

    public int get(int key) {
      if (keyToEntry.containsKey(key)) {
        Entry entry = keyToEntry.get(key);
        // update to end of the linked list
        int value = entry.value;
        removeEntry(key);
        addEntry(key, value);
        return value;
      }
      return -1;
    }

    public void put(int key, int value) {
      if (keyToEntry.containsKey(key)) {
        removeEntry(key);
      }
      addEntry(key, value);
      if (size > CAPACITY) removeEntry(head.next.key);
    }
  }

  public static void main(String[] args) {
    System.out.println("Expecting: 1,-1,-1,3,4");
    var q = new Q0146LRUCache(2);
    q.lruCache.put(1, 1);
    q.lruCache.put(2, 2);
    System.out.println(q.lruCache.get(1));
    q.lruCache.put(3, 3);
    System.out.println(q.lruCache.get(2));
    q.lruCache.put(4, 4);
    System.out.println(q.lruCache.get(1));
    System.out.println(q.lruCache.get(3));
    System.out.println(q.lruCache.get(4));

    q = new Q0146LRUCache(1);
    q.lruCache.put(1, 1);
    q.lruCache.put(1, 2);
    System.out.println(q.lruCache.get(1));
    q.lruCache.put(2, 3);
    System.out.println(q.lruCache.get(1));
    q.lruCache.put(1, 10);
    System.out.println(q.lruCache.get(1));
    System.out.println(q.lruCache.get(2));
    System.out.println(q.lruCache.get(3));
  }
}
