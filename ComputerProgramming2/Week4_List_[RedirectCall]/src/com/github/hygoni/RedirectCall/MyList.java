package com.github.hygoni.RedirectCall;

public class MyList {

	private int size;
	private Node head;
	private Node tail;

	private class Node {
		private Object data;
		private Node next;
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
		public String toString() {
			return data.toString();
		}
	}

	public MyList() {
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Object data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		if(head.next == null) {
			tail = head;
		}
		size++;
	}

	public void addLast(Object data) {
		Node node = new Node(data);
		if(size == 0) {
			addFirst(data);
			return;
		}
		tail.next = node;
		tail = node;
		size++;
	}

	public void add(int idx, Object data) {
		Node node = node(idx-1);
		Node newNode = new Node(data);
		newNode.next = node.next;
		node.next = newNode;
		size++;
	}
	
	public void add(Object data) {
		addLast(data);
	}
	
	public Object removeFirst() {
		if(size == 0) {
			return null;
		}
		Object ret = head.data;
		head = head.next;
		size--;
		return ret;
	}
	
	public Object remove(int idx) {
		if(size == 0) {
			return null;
		} else if(idx == 0) {
			return removeFirst();
		}
		Node node = node(idx-1);
		Node toRemove = node.next;
		node.next = toRemove.next;
		Object ret = toRemove.data;
		if(toRemove == tail) {
			tail = toRemove.next;
		}
		size--;
		return ret;
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	public Node node(int k) {
		Node node = head;
		for(int i = 0; i < k; i++) {
			if(node.next == null) {
				throw new ListIndexException("리스트의 인덱스가 잘못되었습니다.");
			}
			node = node.next;
		}
		return node;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node node = head;
		for(int i = 0; i < size; i++) {
			sb.append(node);
			if(i != size-1) {
				sb.append(", ");
				node = node.next;
			}
			
		}
		sb.append("]");
		return sb.toString();
	}
	
	public String search(String from) {
		Node node = head;
		for(int i = 0; i < size; i++) {
			
			if(Redirect.isFrom(node.data, from)) {
				return Redirect.getTo(node.data);
			}
			node = node.next;
		}
		return null;
	}
}


@SuppressWarnings("serial")
class ListIndexException extends RuntimeException {
	public ListIndexException(String msg) {
		super(msg);
	}
}
