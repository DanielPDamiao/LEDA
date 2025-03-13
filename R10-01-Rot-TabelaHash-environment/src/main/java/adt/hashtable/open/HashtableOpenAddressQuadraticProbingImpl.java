package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		int probe = 0;
		int key = ((HashFunctionOpenAddress) getHashFunction()).hash(element, probe);
		while((this.table[key] != null && !(this.table[key] instanceof DELETED)) && probe < capacity()){
			probe += 1;
			COLLISIONS += 1;
			key = ((HashFunctionOpenAddress) getHashFunction()).hash(element, probe);
		}
		if(this.table[key] == null || this.table[key] instanceof DELETED){
			this.table[key] = element;
			elements += 1;
		}
	}

	@Override
	public void remove(T element) {
		int key = indexOf(element);
		if(key != -1){
			this.table[key] = new DELETED();
			elements -= 1;
		}
	}

	@Override
	public T search(T element) {
		T resp = null;

		int probe = 0;
		int key = ((HashFunctionOpenAddress) getHashFunction()).hash(element, probe);
		while(this.table[key] != null && !this.table[key].equals(element) && probe < capacity()){
			probe += 1;
			key = ((HashFunctionOpenAddress) getHashFunction()).hash(element, probe);
		}
		if(this.table[key] != null && this.table[key].equals(element)){
			resp = element;
		}
		return resp;
	}

	@Override
	public int indexOf(T element) {
		int resp = -1;

		int probe = 0;
		int key = ((HashFunctionOpenAddress) getHashFunction()).hash(element, probe);
		while(this.table[key] != null && !this.table[key].equals(element) && probe < capacity()){
			probe += 1;
			key = ((HashFunctionOpenAddress) getHashFunction()).hash(element, probe);
		}
		if(this.table[key] != null && this.table[key].equals(element)){
			resp = key;
		}
		return resp;
	}
}
