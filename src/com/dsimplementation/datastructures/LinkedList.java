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
		return "Sucessfully Added "+ data + " To The Front.";
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
		return "Sucessfully Added "+ data + " To The Rear.";
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
		return "Deleted " + element + " From Front.";
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
		return "Deleted " + element + " From Rear.";
    }
    
    public String addNthNode(int index, int element) {
    	Node newNode = new Node(element);
    	if(index < 0) {
    		return "Enter an index greater than or equal to zero.";
    	}
    	if (index == 0) { 
    		if(head == null) {
    			head = newNode;
    		} else {
    			newNode.next = head;
    			head.pre = newNode;
    			head = newNode;
    		}
    		return "Added "+ element + " at index " + index + "." ;
		} 
    	int size = findSize();
    	if(index > size) {
    		return "Cannot insert a node at index " + index  + " into a List of size "+ size +".";
    	} else {
    		Node temp = head;
			int pos =0;
    		while(pos < index-1) {
				temp = temp.next;
				pos++;
			}
			if(temp.next != null) {
				newNode.next = temp.next;
				temp.next.pre = newNode;
			}
			temp.next = newNode;
			newNode.pre = temp;
			return  "Added "+ element + " at index " + index + ".";
		}
    	
	}
	
    public String deleteNthNode(int index) {
    	if(index < 0) {
    		return "Enter a position greater than or equal zero.";
    	}
    	int size = findSize();
    	if(size == 0) {
    		return "Linked List is Empty";
    	} else if(index >= size) {
    		return "Position "+ index + " not valid for a list of size " + size + "."; 
    	} else {
    		int element;
    		if(index == 0) {
    			if(head.next == null) {
    				element = head.data;
    				head = null;
    			} else {
    				element = head.data;
    				head = head.next;
    				head.pre = null;
    			}
    			return "Deleted node with data " + element +" from index " + index + ".";
    		} else {
    			Node temp = head;
    			int pos = 0;
        		while(pos < index) {
        			temp = temp.next;
        			pos++;
        		}
        		element = temp.data;
        		if(temp.next == null) {
        			temp.pre.next = null;
        		}else {
        		temp.next.pre = temp.pre;
        		temp.pre.next = temp.next;
        		}
        		return "Deleted node with data " + element +" from index " + index + ".";
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
