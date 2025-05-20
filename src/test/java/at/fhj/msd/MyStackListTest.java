package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackListTest {

  private MyStackList<Integer> stack;

  @BeforeEach
  public void setUp() {
    stack = new MyStackList<>();
  }

  @Test
  public void testIsEmpty() {
    assertTrue(stack.isEmpty());
    stack.push(1);
    assertFalse(stack.isEmpty());
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, stack.size());
    stack.push(1);
    assertEquals(1, stack.size());
    stack.push(2);
    assertEquals(2, stack.size());
    stack.pop();
    assertEquals(1, stack.size());
  }

  @Test
  public void testPushAndPop() {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
  }

  @Test
  public void testPopThrowsWhenEmpty() {
    assertThrows(RuntimeException.class, () -> stack.pop());
    stack.push(1);
    stack.pop();
    assertThrows(RuntimeException.class, () -> stack.pop());
  }

  @Test
  public void testStackOrder() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    assertEquals(30, stack.pop());
    assertEquals(20, stack.pop());
    assertEquals(10, stack.pop());
  }

  @Test
  public void testPushAfterPop() {
    stack.push(100);
    stack.push(200);
    stack.pop();
    stack.push(300);
    assertEquals(300, stack.pop());
    assertEquals(100, stack.pop());
  }

  @Test
  public void testMultipleOperations() {
    assertTrue(stack.isEmpty());
    stack.push(5);
    stack.push(10);
    assertEquals(2, stack.size());
    assertEquals(10, stack.pop());
    assertEquals(1, stack.size());
    stack.push(15);
    assertEquals(15, stack.pop());
    assertEquals(5, stack.pop());
    assertTrue(stack.isEmpty());
  }
}