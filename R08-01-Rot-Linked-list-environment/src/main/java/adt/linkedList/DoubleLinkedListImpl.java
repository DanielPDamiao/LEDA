package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element){
		if(isEmpty()){
			insertFirst(element);
		}
		else{
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			newNode.setData(element);
			newNode.setNext(new DoubleLinkedListNode<>());
			newNode.setPrevious(last);
			last.setNext(newNode);
			last = newNode;
		}
	}

	@Override
	public T search(T element){
		DoubleLinkedListNode<T> nodeHead = (DoubleLinkedListNode<T>) head;
		DoubleLinkedListNode<T> nodeLast = last;
		T resp = null;
		while(!nodeHead.equals(nodeLast) && !nodeHead.getNext().equals(nodeLast) && !nodeHead.getData().equals(element) && !nodeLast.getData().equals(element)){
			nodeHead = (DoubleLinkedListNode<T>) nodeHead.getNext();
			nodeLast = (DoubleLinkedListNode<T>) nodeLast.getPrevious();
		}
		if(nodeHead.getData().equals(element) || nodeLast.getData().equals(element)){
			resp = element;
		}
		return resp;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.setData(element);
		newNode.setPrevious(new DoubleLinkedListNode<>());
		if(head.isNIL()){
			newNode.setNext(new DoubleLinkedListNode<>());
			setHead(newNode);
			setLast((DoubleLinkedListNode<T>) head);
		}
		else{
			((DoubleLinkedListNode<T>) head).setPrevious(newNode);
			newNode.setNext((DoubleLinkedListNode<T>) head);
			setHead(newNode);
		}
	}

	@Override
	public void removeFirst() {
		if(!head.isNIL()){
			setHead(head.getNext());
			if(head.isNIL()){
				setLast((DoubleLinkedListNode<T>) head);
			}
			else{
				((DoubleLinkedListNode<T>) head).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!last.isNIL()){
			setLast(last.getPrevious());
			last.setNext(new DoubleLinkedListNode<>());
		}
	}
	
	@Override
	public void remove(T element){
		DoubleLinkedListNode<T> nodeHead = (DoubleLinkedListNode<T>) head;
		DoubleLinkedListNode<T> nodeLast = last;
		while(!nodeHead.equals(nodeLast) && !nodeHead.getNext().equals(nodeLast) && !nodeHead.getData().equals(element) && !nodeLast.getData().equals(element)){
			nodeHead = (DoubleLinkedListNode<T>) nodeHead.getNext();
			nodeLast = (DoubleLinkedListNode<T>) nodeLast.getPrevious();
		}
		if(nodeHead.getData().equals(element)){
			((DoubleLinkedListNode<T>) nodeHead.getNext()).setPrevious(nodeHead.getPrevious());
			((DoubleLinkedListNode<T>) nodeHead.getPrevious()).setNext(nodeHead.getNext());
		}
		if(nodeLast.getData().equals(element)){
			((DoubleLinkedListNode<T>) nodeLast.getNext()).setPrevious(nodeLast.getPrevious());
			((DoubleLinkedListNode<T>) nodeLast.getPrevious()).setNext(nodeLast.getNext());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
