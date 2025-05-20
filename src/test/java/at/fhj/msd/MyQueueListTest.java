package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueListTest {

    private MyQueueList<String> stringQueue;
    private MyQueueList<Integer> intQueue;

    @BeforeEach
    void setUp() {
        stringQueue = new MyQueueList<>();
        intQueue = new MyQueueList<>();
    }

    @Test
    void testNewQueueIsEmpty() {
        assertTrue(stringQueue.isEmpty());
        assertEquals(0, stringQueue.size());
    }

    @Test
    void testPutIncreasesSize() {
        stringQueue.put("A");
        assertFalse(stringQueue.isEmpty());
        assertEquals(1, stringQueue.size());

        stringQueue.put("B");
        assertEquals(2, stringQueue.size());
    }

    @Test
    void testGetReturnsCorrectElement() {
        stringQueue.put("A");
        stringQueue.put("B");

        assertEquals("A", stringQueue.get());
        assertEquals("B", stringQueue.get());
    }

    @Test
    void testGetReducesSize() {
        stringQueue.put("A");
        stringQueue.put("B");
        stringQueue.get(); // removes "A"
        assertEquals(1, stringQueue.size());
        stringQueue.get(); // removes "B"
        assertEquals(0, stringQueue.size());
    }

    @Test
    void testGetFromEmptyQueueReturnsNull() {
        assertNull(stringQueue.get());
    }

    @Test
    void testQueueMaintainsFIFOOrder() {
        stringQueue.put("first");
        stringQueue.put("second");
        stringQueue.put("third");

        assertEquals("first", stringQueue.get());
        assertEquals("second", stringQueue.get());
        assertEquals("third", stringQueue.get());
    }

    @Test
    void testQueueBecomesEmptyAgain() {
        stringQueue.put("item");
        stringQueue.get();
        assertTrue(stringQueue.isEmpty());
    }

    @Test
    void testGenericTypeWithIntegers() {
        intQueue.put(10);
        intQueue.put(20);

        assertEquals(10, intQueue.get());
        assertEquals(20, intQueue.get());
        assertNull(intQueue.get());
    }

    @Test
    void testNullValuesAreHandled() {
        stringQueue.put(null);
        assertEquals(1, stringQueue.size());
        assertNull(stringQueue.get());
        assertEquals(0, stringQueue.size());
    }

    @Test
    void testMultiplePutAndGet() {
        for (int i = 0; i < 100; i++) {
            intQueue.put(i);
        }
        assertEquals(100, intQueue.size());

        for (int i = 0; i < 100; i++) {
            assertEquals(i, intQueue.get());
        }
        assertTrue(intQueue.isEmpty());
    }
}
