package javacode.linkedlistSet;

public class DesignLinkedList707DoubleImpl {

    DoublyNode head;
    DoublyNode tail;
    int size;

    public DesignLinkedList707DoubleImpl() {
        this.head = new DoublyNode();
        this.tail = new DoublyNode();
        head.next=tail;
        tail.prev=head;
        this.size = 0;
    }
    public static void main(String[] args) {
        DesignLinkedList707DoubleImpl linkedList707 = new DesignLinkedList707DoubleImpl();
        linkedList707.addAtHead(1);
        linkedList707.addAtHead(2);
        linkedList707.addAtTail(3);
        linkedList707.addAtTail(4);
        linkedList707.print();
        linkedList707.addAtIndex(1,5);
        linkedList707.print();
        System.out.println(linkedList707.get(1));
        linkedList707.deleteAtIndex(2);
        linkedList707.deleteAtIndex(0);
        linkedList707.print();
    }
    public int get(int index) {
        if (!validForQuery(index)) {
            return -1;
        }
        int mid = size / 2;
        if (index <= mid) {
            DoublyNode node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.val;
        } else {
            DoublyNode node = tail.prev;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node.val;
        }
    }

    public void addAtHead(int val) {
        DoublyNode newNode = new DoublyNode(val, null, null);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        DoublyNode newNode = new DoublyNode(val, null, null);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev=newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (!validForAdd(index)) {
            return;
        }
        DoublyNode newNode = new DoublyNode(val, null, null);
        DoublyNode node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (!validForQuery(index)) {
            return;
        }
        int mid = size / 2;
        if (index <= mid) {
            DoublyNode node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;

        } else {
            DoublyNode node = tail.prev;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    private boolean validForAdd(int index) {
        return index >=0 && index<=size;
    }

    private boolean validForQuery(int index) {
        return index>=0 && index < size;
    }
    public void print() {
        DoublyNode node = head.next;
        while(node!=tail){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("");
    }
    class DoublyNode{
        int val;
        DoublyNode prev;
        DoublyNode next;

        public DoublyNode() {
        }

        public DoublyNode(int val, DoublyNode prev, DoublyNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
