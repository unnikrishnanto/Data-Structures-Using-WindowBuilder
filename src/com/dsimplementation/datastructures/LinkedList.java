package com.dsimplementation.datastructures;

public class LinkedList {
	Node head = null;
	
	private class Node{
		Node pre;
		int data;
		Node next;
		public Node(int data) {
			super();
			this.pre = null;
			this.data = data;
			this.next = null;
		}
	}
	
	public String addFirst(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		} else {
			head.pre = newNode;
			newNode.next = head;
			head = newNode;
		} 
		return "Node Added Sucessfully";
	}

	
	public String addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		} else if(head.next == null) {
			head.next = newNode;
			newNode.pre = head;
		} else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.pre = temp;
		}
		return "Node Added Sucessfully";
	}
	
    public String deleteFromFront() {
    	int element;
    	if(head == null) {
    		return "Linked List is Empty.";
    	}
    	else if (head.next == null) {
    		element = head.data;
    		head = null;
    	} else {
    		element = head.data;
    		head = head.next;
    		head.pre = null;
    	}	
		return "Deleted element is " + String.valueOf(element);
	}
    
    public String deleteFromRear() {
    	int element;
    	if(head == null) {
    		return "Linked List is Empty.";
    	}
    	else if (head.next == null) {
    		element = head.data;
    		head = null;
    	} else {
    		Node temp = head;
    		while(temp.next.next != null) {
    			temp = temp.next;
    		}  		
    		element = temp.next.data;
    		temp.next = null;
    	}	
		return "Deleted element is " + String.valueOf(element);
    }
    
    public String addNthNode(int position, int element) {
    	Node newNode = new Node(element);
    	if(position <=0) {
    		return "Enter a position greater than zero.";
    	}
    	if (position == 1) { 
    		if(head == null) {
    			head = newNode;
    		} else {
    			newNode.next = head;
    			head.pre = newNode;
    			head = newNode;
    		}
    		return "Node added sucessfully";
		} 
    	int size = findSize();
    	if(position > size+1) {
    		return "Cannot insert a node at position " + position + " of a List of size "+ size +".";
    	} else {
    		Node temp = head;
			while(position > 2) {
				temp = temp.next;
				position--;
			}
			if(temp.next != null) {
				newNode.next = temp.next;
				temp.next.pre = newNode;
			}
			temp.next = newNode;
			newNode.pre = temp;
			return "Node added Sucessfully.";
		}
    	
	}
	
    public String deleteNthNode(int position) {
    	if(position <=0) {
    		return "Enter a position greater than zero.";
    	}
    	int size = findSize();
    	if(size == 0) {
    		return "Linked List is Empty";
    	} else if(position > size) {
    		return "Position "+ position + " not valid for a list of size " + size + "."; 
    	} else {
    		int element;
    		if(position == 1) {
    			if(head.next == null) {
    				element = head.data;
    				head = null;
    			} else {
    				element = head.data;
    				head = head.next;
    				head.pre = null;
    			}
    			return "Deleted node with data " + element +".";
    		} else {
    			Node temp = head;
        		while(position > 1) {
        			temp = temp.next;
        			position--;
        		}
        		element = temp.data;
        		if(temp.next == null) {
        			temp.pre.next = null;
        		}else {
        		temp.next.pre = temp.pre;
        		temp.pre.next = temp.next;
        		}
        		return "Deleted node with data " + element +".";
    		}
    	}
    }
    
    
    private int findSize() {
    	if(head == null)
    		return 0;
    	else {
    		int size = 0;
        	Node temp = head;
        	while(temp !=null) {
        		size++;
        		temp = temp.next;
        	}
        	return size;
    	}
    }
    	
    
    
    public String getLLFromFront() {
    	
    	if(head == null) {
    		return "Linked List is Empty.";
    	}
    	 else {
    		StringBuilder sb = new StringBuilder();
    		Node temp = head;
    		while(temp != null) {
    			sb.append(temp.data);
    			sb.append(" => ");
    			temp = temp.next;
    		}
    		sb.append("null");
    		return sb.toString();
    	 }
    }
    
public String getLLFromRear() {
    	
    	if(head == null) {
    		return "Linked List is Empty.";
    	}
    	 else {
    		StringBuilder sb = new StringBuilder();
    		Node temp = head;
    		while(temp.next != null) {
    			temp = temp.next;
    		}
    		while(temp != null) {
    			sb.append(temp.data);
    			sb.append(" => ");
    			temp = temp.pre;
    		}
    		sb.append("null");
    		return sb.toString();
    	 }
    }
    
}
