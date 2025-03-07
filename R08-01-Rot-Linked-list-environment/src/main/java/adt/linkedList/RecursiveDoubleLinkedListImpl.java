package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if(data == null){
			data = element;
			next = new RecursiveDoubleLinkedListImpl<>();
			if(previous == null){
				previous = new RecursiveDoubleLinkedListImpl<>();
			}
		}
		else{
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(data != null){
			if(data.equals(element)){
				if(previous.isEmpty() && next.isEmpty()){
					data = null;
					previous = null;
					next = null;
				}
				else{
					data = next.getData();
					next = next.getNext();
					if(next != null){
						((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
					}
				}
			}
			else{
				next.remove(element);
			}
		}
	}


	@Override
	public void insertFirst(T element) {
		if(isEmpty()){
			insert(element);
		}
		else{
			RecursiveDoubleLinkedListImpl<T> auxNext = (RecursiveDoubleLinkedListImpl<T>) next;
			next = new RecursiveDoubleLinkedListImpl<>();
			next.setData(this.data);
			((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
			next.setNext(auxNext);
			data = element;
		}

	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			data = next.getData();
			next = next.getNext();
			if(next != null){
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(next.isEmpty()){
				data = next.getData();
				next = next.getNext();
			}
			else{
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
