import java.util.Arrays;
import java.util.Scanner;

public class MaxBinaryHeap {

    private int size;

    private int[] heapArray;

    private int capacity;

    public MaxBinaryHeap() {
        size = 0;
        capacity =10;
        heapArray = new int[capacity];
    }

    public void insert(int item) {
        CheckCapacity();
        heapArray[size] = item;
        size++;
        heapifyup();
    }

    private void heapifyup() {
        int index = size -1;
        while (hasParent(index) && getParent(index) < heapArray[index]) {
            int root = getParentIndex(index);
            swap(root, index);
            index = root;
        }
    }

    private void swap(int root, int node) {
        int temp;
        temp = heapArray[root];
        heapArray[root] = heapArray[node];
        heapArray[node] = temp;
    }

    private void printTree() {
        for (int i=0 ; i< size ; i++) {
            System.out.println(heapArray[i]);
        }
    }

    private void CheckCapacity() {
        if(size == capacity){
            heapArray = Arrays.copyOf(heapArray, capacity *2);
            capacity = capacity * 2;
        }
    }

    private int getLeftNodeIndex(int parentIndex) {
        return 2*parentIndex +1;
    }

    private int getRightNodeIndex(int parentIndex) {
        return 2*parentIndex +2;
    }

    private int getParentIndex(int nodeIndex) {
        return (nodeIndex -1)/2;
    }

    private boolean hasParent (int index) {
        return getParentIndex(index) > -1;
    }

    private boolean hasLeftNode (int index) {
        return getLeftNodeIndex(index) < size;
    }

    private boolean hasRightNode (int index) {
        return getRightNodeIndex(index) < size;
    }

    private int getLeftNode (int index) {
        return heapArray[getLeftNodeIndex(index)];
    }

    private int getRightNode (int index) {
        return heapArray[getRightNodeIndex(index)];
    }

    private int getParent (int index) {
        return heapArray[getParentIndex(index)];
    }

    public int peek () {
        if (size ==0) {
            throw new IllegalStateException();
        }
        return heapArray[0];
    }

    public int remove () {
        if(size == 0) {
            throw  new IllegalStateException();
        }
        int item = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftNode(index)) {
            int largerIndex = getLeftNodeIndex(index);
            if (hasRightNode(index) && getLeftNode(index) < getRightNode(index)) {
                largerIndex = getRightNodeIndex(index);
            }
            if (heapArray[index] > heapArray[largerIndex]) {
                break;
            } else {
                swap(index,largerIndex);
            }
            index = largerIndex;
        }
    }

    public static void main (String args[]) {
        MaxBinaryHeap maxBinaryHeap = new MaxBinaryHeap();
        maxBinaryHeap.insert(1);
        maxBinaryHeap.insert(20);
        maxBinaryHeap.insert(3);
        maxBinaryHeap.insert(43);
        maxBinaryHeap.insert(61);
        maxBinaryHeap.printTree();

        while(true) {
            System.out.println("Please Enter the corresponding digit of Your Choice:");
            System.out.println("1.Insert");
            System.out.println("2.Remove");
            System.out.println("3.Print");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1 : System.out.println("Enter the value to insert:");
                         int value = in.nextInt();
                         maxBinaryHeap.insert(value);
                         maxBinaryHeap.printTree();
                         break;
                case 2 : maxBinaryHeap.remove();
                         maxBinaryHeap.printTree();
                         break;
                case 3 : maxBinaryHeap.printTree();
                         break;
                default: System.out.println("Invalid Entry");
                        break;

            }
        }
    }

}