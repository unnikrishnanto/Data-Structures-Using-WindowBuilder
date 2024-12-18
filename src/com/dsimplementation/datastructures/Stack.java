package com.dsimplementation.datastructures;

public class Stack {
	private int[] stack;
	private int top =-1;
	
	public Stack createStacK(int size) {
		stack = new int[size];
		return this;
	}
	
	public boolean push(int element) {
		if(top == stack.length -1) {
			return false;
		} else {
			stack[++top] = element;
			return true;
		}
	}
	
	public String pop() {
		if(top== -1) {
			return "Stack\nis\nEmpty.";
		} else {
			return "Element\n" + String.valueOf(stack[top--]) +"\nPopped.";
		}
	}
	
	public String peek() {
		if(top== -1) {
			return "Stack\nis\nEmpty.";
		} else {
			return "Element\n at top\nis\n" + String.valueOf(stack[top]) + ".";
		}
	}
	
	public String getStack() {
		if(top== -1) {
			return "Stack\nis\nEmpty.";
		} else {
			StringBuilder sb = new StringBuilder();
			int temp = top;
			while(temp > -1) {
				sb.append(stack[temp--]);
				if(temp >= 0) {
					sb.append("\n");
				} 
			}
			return sb.toString();
		}
	}

}
