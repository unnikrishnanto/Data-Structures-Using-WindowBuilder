package com.dsimplementation.datastructures;

public class Queue {
	private int queue[];
	private int size;
	private int front = -1;
	private int rear = -1;

	public Queue createQueue(int size) {
		queue = new int[size];
		this.size = size;
		return this;
	}

	public String enque(int element) {
		if(rear == size-1) {
			return "Queue is Full.";
		} else {
			queue[++rear] = element;
			return "Added to Queue";
		}
	}
	public String deque(){
		if(rear == -1 ||(front == size-1)) {
			return "Queue is Empty";
		} else {
			return String.valueOf(queue[++front]);
		}
	}
	
	public String peek(){
		if(rear == -1 ||(front == size-1)) {
			return "Queue is Empty";
		} else {
			return String.valueOf(queue[front + 1]);
		}
	}
	
	public String getQueue() {
		if(rear == -1 ||(front == size-1)) {
			return "Queue is Empty";
			
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = front+1; i <= rear; i++) {
				sb.append(queue[i]);
				if(i < rear)
					sb.append(", ");
			}
			return sb.toString();
		}
	}
	

}
