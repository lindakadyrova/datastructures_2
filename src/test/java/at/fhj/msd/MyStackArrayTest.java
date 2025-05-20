package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackArrayTest {

    private MyStackArray<String> stringStack;
    private MyStackArray<Integer> intStack;

    @BeforeEach
    void setUp() {
        stringStack = new MyStackArray<>(5);
        intStack = new MyStackArray<>(3);
    }

    @Test
    void testNewStackIsEmpty() {
        assertTrue(stringStack.isEmpty());
        assertEquals(0, stringStack.size());
    }

    @Test
    void testPushIncreasesSize() {
        stringStack.push("A");
        assertFalse(stringStack.isEmpty());
        assertEquals(1, stringStack.size());

        stringStack.push("B");
        assertEquals(2, stringStack.size());
    }

    @Test
    void testPopDecreasesSize() {
        stringStack.push("A");
        stringStack.push("B");
        stringStack.pop(); // removes "B"
        assertEquals(1, stringStack.size());
        stringStack.pop(); // removes "A"
        assertEquals(0, stringStack.size());
    }

    @Test
    void testLIFOOrder() {
        stringStack.push("first");
        stringStack.push("second");
        stringStack.push("third");

        assertEquals("third", stringStack.pop());
        assertEquals("second", stringStack.pop());
        assertEquals("first", stringStack.pop());
    }

    @Test
    void testPopFromEmptyThrowsUnderflow() {
        assertThrows(RuntimeException.class, () -> stringStack.pop(), "Underflow expected");
    }

    @Test
    void testGenericTypeWithInteger() {
        intStack.push(100);
        intStack.push(200);
        assertEquals(200, intStack.pop());
        assertEquals(100, intStack.pop());
    }

    @Test
    void testNullValuesAreHandled() {
        stringStack.push(null);
        assertEquals(1, stringStack.size());
        assertNull(stringStack.pop());
        assertTrue(stringStack.isEmpty());
    }

    @Test
    void testMultiplePushAndPop() {
        for (int i = 0; i < 3; i++) {
            intStack.push(i);
        }

        assertEquals(3, intStack.size());

        for (int i = 2; i >= 0; i--) {
            assertEquals(i, intStack.pop());
        }

        assertTrue(intStack.isEmpty());
    }
}
