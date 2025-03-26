package adt.bst;

import java.util.ArrayList;

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
			height = 1 + Math.max(heightOf((BSTNode<T>)node.getLeft()), heightOf((BSTNode<T>)node.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchIn(root, element);
	}

	private BSTNode<T> searchIn(BSTNode<T> node, T element){
		BSTNode<T> resp = new BSTNode<T>();
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
			if(node.getRight().isEmpty()){
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
			if(node.getLeft().isEmpty()){
				resp = node;
			}
			else{
				resp = minimumOf((BSTNode<T>)node.getLeft());
			}
		}
		return resp;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		return sucessorOf(root, element);
	}

	private BSTNode<T> sucessorOf(BSTNode<T> node, T element){
		BSTNode<T> resp = null;
		if(!node.isEmpty()){
			if(node.getData().compareTo(element) > 0){
				resp = sucessorOf((BSTNode<T>)node.getLeft(), element);
				if(resp == null){
					resp = node;
				}
			}
			else{
				resp = sucessorOf((BSTNode<T>)node.getRight(), element);
			}
		}
		return resp;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		return predecessorOf(root, element);
	}

	private BSTNode<T> predecessorOf(BSTNode<T> node, T element){
		BSTNode<T> resp = null;
		if(!node.isEmpty()){
			if(node.getData().compareTo(element) < 0){
				resp = predecessorOf((BSTNode<T>)node.getRight(), element);
				if(resp == null){
					resp = node;
				}
			}
			else{
				resp = predecessorOf((BSTNode<T>)node.getLeft(), element);
			}
		}
		return resp;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		removeOf(node);
	}

	private void removeOf(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.isLeaf()){
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
			}
			else if(!node.getLeft().isEmpty() && !node.getRight().isEmpty()){
				BSTNode<T> sucessor = sucessorOf(node, node.getData());
				T temp = sucessor.getData();
				removeOf(sucessor);
				node.setData(temp);
				
			}

			else{
				if(node.getParent() == null){
					if(!node.getLeft().isEmpty()){
						root = (BSTNode<T>)node.getLeft();
						node.getLeft().setParent(null);
					}
					else{
						root = (BSTNode<T>)node.getRight();
						node.getRight().setParent(null);
					}
				}
				else{
					if(node.getData().compareTo(node.getParent().getData()) < 0){
						if(!node.getLeft().isEmpty()){
							node.getParent().setLeft((BSTNode<T>)node.getLeft());
							node.getLeft().setParent((BSTNode<T>)node.getParent());
						}
						else{
							node.getParent().setLeft((BSTNode<T>)node.getRight());
							node.getRight().setParent((BSTNode<T>)node.getParent());
						}
					}
					else{
						if(!node.getLeft().isEmpty()){
							node.getParent().setRight((BSTNode<T>)node.getLeft());
							node.getLeft().setParent((BSTNode<T>)node.getParent());
						}
						else{
							node.getParent().setRight((BSTNode<T>)node.getRight());
							node.getRight().setParent((BSTNode<T>)node.getParent());
						}
					}
				}
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		preOrderList(list, root);
		return (T[])list.toArray(new Comparable[size()]);
	}

	private void preOrderList(ArrayList<T> list, BSTNode<T> node) {
		if(!node.isEmpty()){
			list.add(node.getData());
			preOrderList(list, (BSTNode<T>)node.getLeft());
			preOrderList(list, (BSTNode<T>)node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		orderList(list, root);
		return (T[])list.toArray(new Comparable[size()]);
	}

	private void orderList(ArrayList<T> list, BSTNode<T> node){
		if(!node.isEmpty()){
			orderList(list, (BSTNode<T>)node.getLeft());
			list.add(node.getData());
			orderList(list, (BSTNode<T>)node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		postOrderList(list, root);
		return (T[])list.toArray(new Comparable[size()]);
	}

	private void postOrderList(ArrayList<T> list, BSTNode<T> node){
		if(!node.isEmpty()){
			postOrderList(list, (BSTNode<T>)node.getLeft());
			postOrderList(list, (BSTNode<T>)node.getRight());
			list.add(node.getData());
		}
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
