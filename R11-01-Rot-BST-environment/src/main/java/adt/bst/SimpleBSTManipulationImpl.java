package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals((BSTNode<T>)tree1.getRoot(), (BSTNode<T>)tree2.getRoot());
	}

	private boolean equals(BSTNode<T> node, BSTNode<T> node2){
		boolean resp = true;
		if(!node.isEmpty() || !node2.isEmpty()){
			if(node.isEmpty() || node2.isEmpty()){
				resp = false;
			}
			else if(!node.getData().equals(node2.getData())){
				resp = false;
			}
			else{
				resp = equals((BSTNode<T>)node.getLeft(), (BSTNode<T>)node2.getLeft()) && equals((BSTNode<T>)node.getRight(), (BSTNode<T>)node2.getRight());
			}
		}
		return resp;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar((BSTNode<T>)tree1.getRoot(), (BSTNode<T>)tree2.getRoot());
	}

	private boolean isSimilar(BSTNode<T> node, BSTNode<T> node2){
		boolean resp = true;
		if(!node.isEmpty() || !node2.isEmpty()){
			if(node.isEmpty() || node2.isEmpty()){
				resp = false;
			}
			else{
				resp = isSimilar((BSTNode<T>)node.getLeft(), (BSTNode<T>)node2.getLeft()) && isSimilar((BSTNode<T>)node.getRight(), (BSTNode<T>)node2.getRight());
			}
		}
		return resp;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		return orderStatistic((BSTNode<T>)tree.getRoot(), k);
	}

	private T orderStatistic(BSTNode<T> node, int k){
		T resp = null;
		if(!node.isEmpty()){
			if(size((BSTNode<T>)node.getLeft()) + 1 == k){
				resp = node.getData();
			}
			else if(size((BSTNode<T>)node.getLeft()) + 1 > k){
				resp = orderStatistic((BSTNode<T>)node.getLeft(), k);
			}
			else{
				resp = orderStatistic((BSTNode<T>)node.getRight(), k - (size((BSTNode<T>)node.getLeft()) + 1));
			}
		}
		return resp;
	}

	private int size(BSTNode<T> node) {
		int resp = 0;
		if (!node.isEmpty()) {
			resp = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return resp;
	}


}
