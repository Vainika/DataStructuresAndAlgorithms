/**
 * Created by Vainika
 * on 1/7/2017.
 */
public class Stack {

    private class Node {
        int data;
        Node next;
        Node (int data) {
        this.data = data;
        this.next = null;
        }
    }

    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push (int data) {
        Node temp = new Node(data);
        if(!isEmpty()){
            temp.next = head;
            head = temp;
            return;
        }
        head = temp;
    }

    public int pop () {
        if(isEmpty()){
           throw new IllegalStateException("The Stack is Empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    private void printStack() {
        Node temp;
        temp = head;
        System.out.println("The Values in the Stack are:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main (String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.printStack();
        System.out.println("Popped value in stack " + stack.pop());
        System.out.println("Popped value in stack " + stack.pop());
        System.out.println("Popped value in stack " + stack.pop());
    }

}
