class MyCircularDeque {
    private Node head,tail;
    private int max,size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size=0;
        max = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())return false;
        if(isEmpty()){
            size++;
            head = new Node(value);
            tail = head;
            return true;
        }
        size++;
        Node t = new Node(value);
        t.next = head;
        head.prev = t;
        tail.next = t;
        t.prev = tail;
        head = t;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())return false;
        if(isEmpty()){
            size++;
            head = new Node(value);
            tail = head;
            return true;
        }
        size++;
        Node t = new Node(value);
        tail.next = t;
        t.prev = tail;
        head.prev = t;
        t.next = head;
        tail = t;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())return false;
        size--;
        if(isEmpty()){
            head=null;
            tail=head;
            return true;
        }
        tail.next = head.next;
        head=head.next;
        head.prev = tail;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())return false;
        size--;
        if(isEmpty()){
            head=null;
            tail=head;
            return true;
        }
        head.prev = tail.prev;
        tail=tail.prev;
        tail.next= head;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty()? -1 : head.data;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty()? -1 : tail.data;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==max;
    }
}
class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data){
        this.data = data;
    }
    
}
