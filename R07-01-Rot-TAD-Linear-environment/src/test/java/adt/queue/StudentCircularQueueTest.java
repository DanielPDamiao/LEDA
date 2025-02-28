package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

public class StudentCircularQueueTest {

	public Queue<Integer> meiotermo;
	public Queue<Integer> cheio;
	public Queue<Integer> vazio;
    public Queue<Integer> umelemento;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		meiotermo.enqueue(1);
		meiotermo.enqueue(2);
		meiotermo.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		cheio.enqueue(1);
		cheio.enqueue(2);

        // Fila com 1 elemento cheia.
        umelemento.enqueue(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		meiotermo = new CircularQueue<>(5);
		cheio = new CircularQueue<>(2);
		vazio = new CircularQueue<>(1);
        umelemento = new CircularQueue<>(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(null, vazio.head());
        assertEquals((Integer) 1, meiotermo.head());
        assertEquals((Integer) 1, cheio.head());
        assertEquals((Integer) 1, umelemento.head());
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertFalse(meiotermo.isEmpty());
		assertTrue(vazio.isEmpty());
        assertFalse(umelemento.isEmpty());
        umelemento.dequeue();
        assertTrue(umelemento.isEmpty());
	}

	@Test
	public void testIsFull() throws Exception {
		assertFalse(meiotermo.isFull());
        assertTrue(umelemento.isFull());
        umelemento.dequeue();
        assertFalse(umelemento.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			meiotermo.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws Exception {
		cheio.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
        umelemento.dequeue();
        umelemento.enqueue(1);
        umelemento.enqueue(2);
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), meiotermo.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), vazio.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

    @Test
    public void testEspecial() throws Exception {
        assertTrue(cheio.isFull());
        assertEquals((Integer) 1, cheio.head());
        
        cheio.dequeue();
        assertFalse(cheio.isFull());
        assertEquals((Integer) 2, cheio.head());
        
        cheio.enqueue(3);
        assertTrue(cheio.isFull());
        assertEquals((Integer) 2, cheio.head());
        
        cheio.dequeue();
        assertFalse(cheio.isFull());
        assertEquals((Integer) 3, cheio.head());
        
        cheio.enqueue(4);
        assertTrue(cheio.isFull());
        assertEquals((Integer) 3, cheio.head());
    }
}