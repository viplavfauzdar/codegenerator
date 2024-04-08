package com.viplav.utils.spring.other;

public class CircularLinkedList {
    
    private Node head;
    private Node tail;

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    public void print() {
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != null && temp != head);
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);
        head = prev;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.print();
        linkedList.reverse();
        System.out.println();
        linkedList.print();
    }
}
