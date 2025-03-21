package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heightOf(root);
	}

	private int heightOf(BSTNode<T> node){
		int height = -1;
		if(!node.isEmpty()){
			height = 1 + Math.max(0, Math.max( heightOf((BSTNode<T>)node.getLeft()), heightOf((BSTNode<T>)node.getRight())));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchIn(root, element);
	}

	private BSTNode<T> searchIn(BSTNode<T> node, T element){
		BSTNode<T> resp = null;
		if(!node.isEmpty()){
			if(node.getData().equals(element)){
				resp = node;
			}
			else if(node.getData().compareTo(element) > 0){
				resp = searchIn((BSTNode<T>)node.getLeft(), element);
			}
			else{
				resp = searchIn((BSTNode<T>)node.getRight(), element);
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		insertIn(root, element);
	}

	private void insertIn(BSTNode<T> node, T element){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<>());
			node.getRight().setParent(node);
		}
		else if(node.getData().compareTo(element) > 0){
			insertIn((BSTNode<T>)node.getLeft(), element);
		}
		else{
			insertIn((BSTNode<T>)node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximumOf(root);
	}

	private BSTNode<T> maximumOf(BSTNode<T> node) {
		BSTNode<T> resp = null;
		if(!node.isEmpty()){
			if(node.isLeaf()){
				resp = node;
			}
			else{
				resp = maximumOf((BSTNode<T>)node.getRight());
			}
		}
		return resp;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimumOf(root);
	}

	private BSTNode<T> minimumOf(BSTNode<T> node){
		BSTNode<T> resp = null;
		if(!node.isEmpty()){
			if(node.isLeaf()){
				resp = node;
			}
			else{
				resp = maximumOf((BSTNode<T>)node.getLeft());
			}
		}
		return resp;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	private BSTNode<T> sucessorOf(BSTNode<T> node, T element){
		BSTNode<T> resp = null;
		if(!node.isEmpty()){
			if(node.getData().compareTo(element) > 0)
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
