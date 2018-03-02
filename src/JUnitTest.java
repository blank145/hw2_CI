import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {
	private BoundedQueue q; 
	private int capacity;
	@Before
	public void setUp() {
		capacity = 2;
		q = new BoundedQueue(capacity);
	}
	@Test
	public void enQueueTestA() {
		q.enQueue("A");
		q.enQueue("B");
		assertEquals(q.deQueue(), "A");	
	}
	@Test
	public void enQueueTestB() {
		q.enQueue("A");
		q.enQueue("B");
		q.enQueue("C");
	}
	
	@Test
	public void deQueueTestA() {
		q.enQueue("A");
		q.enQueue("B");
		assertEquals(q.deQueue(), "A");
	}
	
	@Test(expected = IllegalStateException.class) 
	public void deQueueTestB() {
		q.enQueue("A");
		q.enQueue("B");
		q.deQueue();
		q.deQueue();
		q.deQueue();
	}
	
	@Test
	public void isEmptyTest() {
		assertEquals(q.isEmpty(), true);
		q.enQueue(3);
		assertEquals(q.isEmpty(), false);
	}
	
	@Test
	public void isFullTest() {
		assertEquals(q.isFull(), false);
		q.enQueue(1);
		assertEquals(q.isFull(), false);
		q.enQueue(2);
		assertEquals(q.isFull(), true);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(q.toString(), "[]");
		q.enQueue("x");
		assertEquals(q.toString(), "[x]");
		q.enQueue("y");
		assertEquals(q.toString(), "[x, y]");
	}

}
