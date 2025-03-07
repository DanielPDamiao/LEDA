package adt.linkedList;
import java.util.ArrayList;

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
		while(!actual.isNIL() && !actual.getData().equals(element)){
			actual = actual.getNext();
		}
		return actual.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> actual = head;
		if(isEmpty()){
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>();
			newHead.setData(element);
			newHead.setNext(head);
			head = newHead;
		}
		else{
			while(!actual.isNIL()){
				actual = actual.getNext();
			}
			actual.setData(element);
			actual.setNext(new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if(head.getData().equals(element)){
			head = head.getNext();
		}
		else{
			SingleLinkedListNode<T> actual = head;
			while(!actual.isNIL()){
				if(actual.getData().equals(element)){
					actual.setData(actual.getNext().getData());
					actual.setNext(actual.getNext().getNext());
				}
				else{
					actual = actual.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<>();
		SingleLinkedListNode<T> actual = head;
		while(!actual.isNIL()){
			array.add(actual.getData());
			actual = actual.getNext();
		}
		return (T[]) array.toArray();
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
