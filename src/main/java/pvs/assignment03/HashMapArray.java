package pvs.assignment03;

import java.util.HashMap;

/**
 * Assignment 3 exercise 1. Array-class which uses a {@link HashMap}.
 *
 * @author Christian
 *
 * @param <V> Value of the array.
 */
public class HashMapArray<V> {
  private int capacity;
  private HashMap<Integer, V> hashMap;

  public HashMapArray(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("HashMapArray can't have capacity less than 0.");
    }
    this.capacity = capacity;
    hashMap = new HashMap<>(capacity);
  }

  public void addAtIndex(int index, V value) {
    if (index < 0 || index >= capacity) {
      throw new ArrayIndexOutOfBoundsException();
    }
    hashMap.put(index, value);
  }

  public V get(int index) {
    if (index < 0 || index >= capacity) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return hashMap.get(index);
  }

  public int size() {
    return capacity;
  }
}
