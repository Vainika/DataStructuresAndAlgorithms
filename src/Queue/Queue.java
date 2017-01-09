/**
 * Created by Vainika
 * on 1/8/2017.
 */
public class Queue<T> {

    private class Node<T> {
        T data;
        Node next;
        public Node (T data){
            this.data = data;
            this.next = null;
        }
    }

    Node head,tail;

    private boolean isEmpty () {
        return head == null;
    }

    private void enqueue (T data) {
        Node temp = new Node(data);
        if (isEmpty()){
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    private T dequeue () {
        T item;
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        item = (T) head.data;
        head = head.next;
        return item;
    }

    public static void main (String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(12);
        queue.enqueue(5);
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
