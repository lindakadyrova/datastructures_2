package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyQueueArrayTest {

  private MyQueueArray<Integer> queue;

  @BeforeEach
  public void setUp() {
    queue = new MyQueueArray<>(3);
  }

  @Test
  public void testIsEmpty() {
    assertTrue(queue.isEmpty());
    queue.enqueue(1);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, queue.size());
    queue.enqueue(1);
    assertEquals(1, queue.size());
    queue.enqueue(2);
    assertEquals(2, queue.size());
    queue.dequeue();
    assertEquals(1, queue.size());
  }

  @Test
  public void testEnqueue() {
    queue.enqueue(1);
    queue.enqueue(2);
    assertEquals(2, queue.size());
    assertEquals(1, queue.peek());
  }

  @Test
  public void testEnqueueThrowsWhenFull() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertThrows(RuntimeException.class, () -> queue.enqueue(4));
  }

  @Test
  public void testDequeue() {
    queue.enqueue(1);
    queue.enqueue(2);
    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testDequeueThrowsWhenEmpty() {
    assertThrows(RuntimeException.class, () -> queue.dequeue());
    queue.enqueue(1);
    queue.dequeue();
    assertThrows(RuntimeException.class, () -> queue.dequeue());
  }

  @Test
  public void testPeek() {
    assertNull(queue.peek());
    queue.enqueue(1);
    assertEquals(1, queue.peek());
    queue.enqueue(2);
    assertEquals(1, queue.peek());
    queue.dequeue();
    assertEquals(2, queue.peek());
  }

  @Test
  public void testQueueOrder() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertEquals(3, queue.dequeue());
  }

  @Test
  public void testQueueAfterDequeue() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.dequeue();
    queue.enqueue(3);
    assertEquals(2, queue.dequeue());
    assertEquals(3, queue.dequeue());
  }
}