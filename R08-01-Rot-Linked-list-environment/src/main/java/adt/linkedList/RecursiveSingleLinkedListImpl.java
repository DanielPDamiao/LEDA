package adt.linkedList;
import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		int size = 0;
		if(data != null){
			size += next.size();
			size += 1;
		}
		return size;
	}

	@Override
	public T search(T element) {
		T resp = null;
		if(data != null){
			if(data.equals(element)){
				resp = data;
			}
			else{
				resp = next.search(element);
			}
		}
		return resp;

	}

	@Override
	public void insert(T element) {
		if(data == null){
			data = element;
			next = new RecursiveSingleLinkedListImpl<>();
		}
		else{
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(data != null){
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
		ArrayList<T> list = new ArrayList<>();
		list = toList(list);
		return (T[]) list.toArray();
	}

	private ArrayList<T> toList(ArrayList<T> list) {
		if(data != null){
			list.add(data);
			list = next.toList(list);
		}
		return list;
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
