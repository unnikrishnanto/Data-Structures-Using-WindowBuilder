package com.dsimplementation.datastructures;

public class Array{
	private int[] array;
	
	public Array createArray(int size) {
		array = new int[size];
		return this;
	}
	
	public boolean set(int element, int index) {
		if(index >= array.length) {
			return false;
		}
		array[index] = element;
		return true;
	}
	
	public boolean deleteElement(int element) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == element) {
				array[i] = 0;
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteFromIndex(int index) {
		if(index >= array.length) {
			return false;
		}
		array[index] = 0;
		return true;
	}
	
	
	
	public String getArray() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i <array.length; i++) {
			sb.append(array[i]);
			if(i < array.length -1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
