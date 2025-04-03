package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for(Integer element : array){
			insert(element);
		}
		Integer resp = null;
		while(index >= 0){
			if(rootElement() == numero){
				resp = rootElement();
				break;
			}
			else if(rootElement() < numero){
				if(resp == null){
					resp = rootElement();
				}
				else if(rootElement() > resp){
					resp = rootElement();
				}
			}
			extractRootElement();
		}
		return resp;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for(Integer element : array){
			insert(element);
		}
		Integer resp = null;
		while(index >= 0){
			if(rootElement() == numero){
				resp = rootElement();
				break;
			}
			else if(rootElement() > numero){
				if(resp == null){
					resp = rootElement();
				}
				else if(rootElement() < resp){
					resp = rootElement();
				}
			}
			extractRootElement();
		}
		return resp;
	}

}
