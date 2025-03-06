package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return data.equals(null);
	}

	@Override
	public int size() {
		int size = 0;
		if(data.equals(null)){
			return size;
		}
		else{
			size += next.size();
			size += 1;
		}
		return size;
	}

	@Override
	public T search(T element) {
		T resp = null;
		if(data.equals(null)){
			return resp;
		}
		else if(data.equals(element)){
			resp = data;
		}
		return resp;

	}

	@Override
	public void insert(T element) {
		if(data.equals(null)){
			data = element;
			next = new RecursiveSingleLinkedListImpl<>();
		}
		else{
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!data.equals(null)){
			if(data.equals(element)){
				data = next.getData();
				next = next.getNext();
			}
			else{
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
