package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		BSTImpl<Integer> bst = new BSTImpl<>();
		for(Integer n : array){
			bst.insert(n);
		}
		return floorOf(bst.getRoot(), numero);
	}

	private Integer floorOf(BSTNode<Integer> node, double element){
		Integer resp = null;
		if(!node.isEmpty()){
			if(node.getData() <= element){
				resp = floorOf((BSTNode<Integer>)node.getRight(), element);
				if(resp == null){
					resp = node.getData();
				}
			}
			else{
				resp = floorOf((BSTNode<Integer>)node.getLeft(), element);
			}
		}
		return resp;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		BSTImpl<Integer> bst = new BSTImpl<>();
		for(Integer n : array){
			bst.insert(n);
		}
		return ceilOf(bst.getRoot(), numero);
	}

	private Integer ceilOf(BSTNode<Integer> node, double element){
		Integer resp = null;
		if(!node.isEmpty()){
			if(node.getData() >= element){
				resp = ceilOf((BSTNode<Integer>)node.getLeft(), element);
				if(resp == null){
					resp = node.getData();
				}
			}
			else{
				resp = ceilOf((BSTNode<Integer>)node.getRight(), element);
			}
		}
		return resp;
	}

}
