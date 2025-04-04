package adt.avltree;

import java.util.ArrayList;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int resp = 0;
		if(!node.isEmpty()){
			resp = heightOf((BSTNode<T>)node.getLeft()) - heightOf((BSTNode<T>)node.getRight());
		}
		return resp;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if(!node.isEmpty()){
			int balance = calculateBalance(node);
			if(balance > 1 || balance < -1){
				if(balance > 0 && calculateBalance((BSTNode<T>)node.getLeft()) >= 0){
					node = Util.rightRotation(node);
					if(node.getParent() == null){
						root = node;
					}
				}
				else if(balance > 0){
					Util.leftRotation((BSTNode<T>)node.getLeft());
					node = Util.rightRotation(node);
					if(node.getParent() == null){
						root = node;
					}
				}
				else if(balance < 0 && calculateBalance((BSTNode<T>)node.getRight()) <= 0){
					 node = Util.leftRotation(node);
					 if(node.getParent() == null){
						root = node;
					}
				}
				else{
					Util.rightRotation((BSTNode<T>)node.getRight());
					node = Util.leftRotation(node);
					if(node.getParent() == null){
						root = node;
					}
				}
				rebalanceUp(node);
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if(node.getParent() != null){
			rebalance((BSTNode<T>)node.getParent());
		}
	}

	@Override
	public void insert(T element){
		insert(element, root);
	}

	private void insert(T element, BSTNode<T> node){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<>());
			node.getRight().setParent(node);
		}
		else{
			if(node.getData().compareTo(element) > 0){
				insert(element, (BSTNode<T>) node.getLeft());
			}
			else{
				insert(element, (BSTNode<T>) node.getRight());
			}
			rebalance(node);
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList();
		this.preOrderList(list, this.root);
		return (T[])list.toArray(new Comparable[this.size()]);
	 }
  
	 private void preOrderList(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
		   list.add(node.getData());
		   this.preOrderList(list, (BSTNode<T>)node.getLeft());
		   this.preOrderList(list, (BSTNode<T>)node.getRight());
		}
  
	 }

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList();
		this.postOrderList(list, this.root);
		return (T[])list.toArray(new Comparable[this.size()]);
	 }
  
	 private void postOrderList(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
		   this.preOrderList(list, (BSTNode<T>)node.getLeft());
		   this.preOrderList(list, (BSTNode<T>)node.getRight());
		   list.add(node.getData());
		}
  
	 }

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.searchIn(root, element);
		this.removeOf(node);
	}

	private void removeOf(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.isLeaf()){
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
				rebalanceUp(node);
			}
			else if(!node.getLeft().isEmpty() && !node.getRight().isEmpty()){
				BSTNode<T> sucessor = sucessorOf(root, node.getData());
				node.setData(sucessor.getData());
				removeOf(sucessor);
			}
			else {
				if(node.getParent() == null){
					if(!node.getLeft().isEmpty()){
						node.getLeft().setParent(null);
						root = (BSTNode<T>)node.getLeft();
					}
					else{
						node.getRight().setParent(null);
						root = (BSTNode<T>)node.getRight();
					}
				}
				else{
					if(node.getData().compareTo(node.getParent().getData()) > 0){
						if(!node.getLeft().isEmpty()){
							node.getLeft().setParent(node.getParent());
							node.getParent().setRight(node.getLeft());
						}
						else{
							node.getRight().setParent(node.getParent());
							node.getParent().setRight(node.getRight());
						}
					}
					else{
						if(!node.getLeft().isEmpty()){
							node.getLeft().setParent(node.getParent());
							node.getParent().setLeft(node.getLeft());
						}
						else{
							node.getRight().setParent(node.getParent());
							node.getParent().setLeft(node.getRight());
						}
					}
				}
				rebalanceUp(node);
			}
		}
	}

	private BSTNode<T> sucessorOf(BSTNode<T> node, T element) {
		BSTNode<T> resp = null;
		if (!node.isEmpty()) {
		   if ((node.getData()).compareTo(element) > 0) {
			  resp = this.sucessorOf((BSTNode<T>)node.getLeft(), element);
			  if (resp == null) {
				 resp = node;
			  }
		   } else {
			  resp = this.sucessorOf((BSTNode<T>)node.getRight(), element);
		   }
		}
  
		return resp;
	 }

	private BSTNode<T> searchIn(BSTNode<T> node, T element) {
		BSTNode<T> resp = new BSTNode<>();
		if (!node.isEmpty()) {
		   if (node.getData().equals(element)) {
			  resp = node;
		   } else if ((node.getData()).compareTo(element) > 0) {
			  resp = this.searchIn((BSTNode<T>)node.getLeft(), element);
		   } else {
			  resp = this.searchIn((BSTNode<T>)node.getRight(), element);
		   }
		}
  
		return resp;
	 }

	@Override
	public int height() {
		return this.heightOf(this.root);
	 }
  
	private int heightOf(BSTNode<T> node) {
	int height = -1;
	if (!node.isEmpty()) {
		height = 1 + Math.max(this.heightOf((BSTNode<T>)node.getLeft()), this.heightOf((BSTNode<T>)node.getRight()));
	}

	return height;
	}
}
