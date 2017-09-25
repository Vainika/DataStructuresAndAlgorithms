import java.util.Arrays;

public class BinarySearch {

    private boolean recursiveBinarySearch(int[] arr, int first, int last, int key) {
        if( first > last )
            return false;
        int mid = (first + last) / 2;
        if(arr[mid] == key)
            return true;
        else if (arr[mid] < key) {
            return (recursiveBinarySearch(arr, mid + 1, last, key));
        } else if (arr[mid] > key) {
            return (recursiveBinarySearch(arr, first, mid - 1, key));
        }
        return false;
    }

    private boolean iterativeBinarySearch(int[] arr, int first, int last, int key) {
        int mid;
        while( first <= last) {
            mid = (first + last) / 2;
            if(arr[mid] == key)
                return true;
            else if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] > key) {
                last = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {34,2,67,23,14,89};
        Arrays.sort(arr); // 2, 14, 23, 34, 67, 89
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Recursive Binary Search " + binarySearch.recursiveBinarySearch(arr, 0, arr.length - 1 , 88));
        System.out.println("Iterative Binary Search " + binarySearch.iterativeBinarySearch(arr, 0, arr.length - 1 , 88));
    }
}
