package at.fhj.msd;

public class MyQueueArray<E> {
  private E[] queue;
  private int maxSize;
  private int size;

  public MyQueueArray(int maxSize) {
    this.maxSize = maxSize;
    queue = (E[]) new Object[maxSize];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(E item) {
    if (size == maxSize) {
      throw new RuntimeException("Queue is full.");
    }
    queue[size] = item;
    size++;
  }

  public E dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty.");
    }
    E item = queue[0];
    for (int i = 1; i < size; i++) {
      queue[i - 1] = queue[i];
    }
    queue[size - 1] = null;
    size--;
    return item;
  }

  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return queue[0];
  }
}
