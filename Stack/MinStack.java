package Stack;

class MinStack {
    Node head = null;
    public MinStack() {}
    
    public void push(int val) {
        if(head == null){
            head = new Node(val, val, head);
        } else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

class Node{
    int val, min;
    Node next;

    Node(int val, int min, Node next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
