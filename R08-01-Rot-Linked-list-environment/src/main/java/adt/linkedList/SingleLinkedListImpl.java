package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> actual = head;
		int size = 0;
		while(!actual.isNIL()){
			size += 1;
			actual = actual.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> actual = head;
		while(!actual.isNIL()){
			if(actual.getData().equals(element)){
				return element;
			}
			actual = actual.getNext();
		}
		return null;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> actual = head;
		while(!actual.isNIL()){
			actual = actual.getNext();
		}
		actual.setData(element);
		actual.setNext(new SingleLinkedListNode<>());
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> actual = head;
		while(!actual.isNIL()){
			if(actual.getData().equals(element)){
				actual.setData(actual.getNext().getData());
				actual.setNext(actual.getNext().getNext());
				break;
			}
			actual = actual.getNext();
		}
	}

	@Override
	public T[] toArray() {
		T[] array = new T[size()];
		SingleLinkedListNode<T> actual = head;
		while(!actual.isNIL()){
			actual = actual.getNext();
		}
		actual.setData(element);
		actual.setNext(new SingleLinkedListNode<>());
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
