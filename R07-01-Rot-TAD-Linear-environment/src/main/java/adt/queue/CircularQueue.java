package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail; //aponta pro ultimo adicionado
	private int head; //aponta para o ultimo apagado
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		tail = (tail + 1) % array.length;
		array[tail] = element;
		elements += 1; 
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		head = (head + 1) % array.length;
		elements -= 1;
		return array[head];
	}

	@Override
	public T head() {
		if(isEmpty()){
			return null;
		}
		return array[(head + 1) % array.length];
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
