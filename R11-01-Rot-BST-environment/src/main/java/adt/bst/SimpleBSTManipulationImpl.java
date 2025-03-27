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
		return orderStatistic(tree, (BSTNode<T>)tree.getRoot(), k);
	}

	private T orderStatistic(BST<T> tree, BSTNode<T> node, int k){
		T resp = null;
		if(!node.isEmpty()){
			if(k == 1){
				resp = node.getData();
			}
			else{
				resp = orderStatistic(tree, sucessorOf((BSTNode<T>)tree.getRoot(), node.getData()), k-1);
			}
		}
		return resp;
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

}
