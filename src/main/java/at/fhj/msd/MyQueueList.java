package at.fhj.msd;

/**
 * A generic queue implementation based on a doubly linked list.
 * Follows FIFO (First In, First Out) principle.
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueueList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  /**
   * A doubly linked list node that stores data and links to previous and next
   * nodes.
   *
   * @param <E> the type of element stored in the node
   */
  private static class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    /**
     * Constructs a new node containing the given data.
     *
     * @param data the data to store in the node
     */
    Node(E data) {
      this.data = data;
    }
  }

  /**
   * Constructs an empty queue.
   */
  public MyQueueList() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Returns the number of elements in the queue.
   *
   * @return the size of the queue
   */
  public int size() {
    return size;
  }

  /**
   * Checks if the queue is empty.
   *
   * @return {@code true} if the queue contains no elements, {@code false}
   *         otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Inserts the specified element at the end of the queue.
   *
   * @param e the element to add
   */
  public void put(E e) {
    Node<E> newNode = new Node<>(e);
    if (isEmpty()) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    size++;
  }

  /**
   * Retrieves and removes the element at the front of the queue.
   *
   * @return the element at the front of the queue, or {@code null} if the queue
   *         is empty
   */
  public E get() {
    if (isEmpty())
      return null;
    E data = head.data;
    head = head.next;
    if (head != null) {
      head.prev = null;
    } else {
      tail = null;
    }
    size--;
    return data;
  }
}
