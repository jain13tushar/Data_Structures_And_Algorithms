package com.datastructure.linkedlist;

public class LinkedList {

	private Node head;

	private Node tail;

	private int length;

	class Node {

		int value;

		Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		this.head = newNode;
		this.tail = newNode;
		this.length = 1;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void getHead() {
		System.out.println("Head: " + head.value);
	}

	public void getTail() {
		System.out.println("Tail: " + tail.value);
	}

	public void getLength() {
		System.out.println("Length: " + length);
	}

	// prepend
	public void addBegin(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	// append
	public void addEnd(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;

	}

	public boolean set(int index, int value) {
		Node temp = get(index);

		if (temp != null) {
			temp.value = value;
			return true;
		}
		return false;

	}

	public boolean insert(int index, int value) {
		if (index < 0 || index >= length) {
			return false;
		}

		if (index == 0) {
			addBegin(value);
			return true;
		}

		if (index == length) {
			addEnd(value);
			return true;
		}

		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;

	}

	public Node removeEnd() {
		if (length == 0) {
			return null;
		} else {
			Node pre = head;
			Node temp = head;
			while (temp.next != null) {
				pre = temp;
				temp = temp.next;
			}
			tail = pre;
			tail.next = null;
			length--;
			if (length == 0) {
				head = null;
				tail = null;
			}
			return temp;
		}

	}

	public Node removeFirst() {
		if (length == 0) {
			return null;
		} else {
			Node temp = head;
			head = head.next;
			temp.next = null;
			length--;
			if (length == 0) {
				tail = null;
			}
			return temp;
		}

	}

	public Node get(int index) {
		if (index < 0 || index >= length) {
			return null;
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

}
