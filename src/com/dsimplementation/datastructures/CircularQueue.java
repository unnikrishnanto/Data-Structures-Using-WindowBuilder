package com.dsimplementation.datastructures;

public class CircularQueue {
	int[] queue;
	int size;
	int front = -1;
	int rear = -1;

	public CircularQueue(int size) {
		this.size = size;
		queue = new int[size]; 
	}

	public String enque(int data) {
		if ((rear + 1) % size == front) {
			return "Queue is Full.";
		} else if (front == -1 && rear == -1) { // if queue is empty.
 			front++; // front = 0
			queue[++rear] = data; // rear = 0.
		} else { 
			rear = (rear + 1) % size;
			queue[rear] = data;
		}
		return "Element added sucessfully.";
	}
	
	public String deque() {
		if(front == -1 && rear == -1) {
			return "Queue is Empty.";
		} else if (front == rear) { // it is the last element.
			int e = queue[front];
			rear = -1;
			front = -1;
			return "Deleted element is : " + e;
		} else {
			int e = queue[front];
			front = (front+1)% size;
			return "Deleted element is : " + e;
		}
	}
	
	public String peek() {
		if(front == -1 && rear == -1) {
			return "Queue is Empty.";
		} else {
			return "Element at front is: " + queue[front];
		}
	}
	
	public String getQueue() {
		if(front == -1 && rear == -1) {
			return "Queue is Empty.";
		} else {
			int i = front;
			StringBuilder q = new StringBuilder();
			while(i != rear) {
				q.append(queue[i] + " ");
				i = (i + 1) % size;
			}
			q.append(queue[i]);
			return q.toString();
		}
	}
}
