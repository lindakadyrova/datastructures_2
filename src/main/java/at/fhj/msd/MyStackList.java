package at.fhj.msd;

public class MyStackList<E> {
  private Node<E> head;
  private int size;

  private static class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
      this.data = data;
    }
  }

  public MyStackList() {
    head = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void push(E e) {
    Node<E> newNode = new Node<>(e);
    newNode.next = head;
    head = newNode;
    size++;
  }

  public E pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack Underflow");
    }
    E item = head.data;
    head = head.next;
    size--;
    return item;
  }
}
