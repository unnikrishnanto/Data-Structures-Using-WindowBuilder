package com.dsimplementation.datastructures;

public class Array{
	private int[] array;
	
	public String createArray(int size) {
		if(size <=0) {
			return "Size must be greater than 0.";
		}
		array = new int[size];
		return "Array of Size "+ size + " Created.";
	}
	
	public String set(int element, int index) {
		if(index >= array.length) {
			return "Invalid index " + index + " for array of size " + array.length + ".";
		}
		array[index] = element;
		return "Element "+ element + " added at index " + index + "." ;
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
	
	public String deleteFromIndex(int index) {
		if(index >= array.length) {
			return "Invalid index " + index + " for array of size " + array.length + ".";
		}
		int element = array[index];
		array[index] = 0;
		return "Removed element "+ element + " at index " + index + ".";
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
