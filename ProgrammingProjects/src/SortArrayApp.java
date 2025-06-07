//3.4 Programming Project oddevensort()

class SortArray {
    private long[] arr;
    private int nElems;

    public SortArray(int size) {
        this.arr = new long[size];
        nElems = 0;
    }
    public void insert(long val) {
        arr[nElems] = val;
        nElems++;
    }
    public void bubbleSort() {
        int out;
        for (out = nElems-1; out > 0; out--) {
            for (int j = 0; j < out ; j++) {
                if (arr[j] > arr[j+1]) {
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }
    public void bidirectBubbleSort() {
        int out;
        int left = 0;
        int right = nElems-1;
        while (left < right) {
            for(int i = 0; i < right; i++)
               if (arr[i] > arr[i+1])
                    swap(i, i+1);
            right--;

            for (int i = right; i > left ; i--)
                if (arr[i-1] > arr[i])
                    swap(i, i-1);
            left++;
        }
    }

    public void oddEvenSort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i <= nElems-2; i+=2) { //odd phase
                if (arr[i] > arr[i+1]) {
                    swap(i, i+1);
                    isSorted = false;
                }
            }
            for (int i = 0; i <= nElems-2; i+=2) { //even phase
                if (arr[i] > arr[i+1]) {
                    swap(i, i+1);
                    isSorted = false;
                }
            }
        }
    }
    public void swap(int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
public class SortArrayApp {
    public static void main(String[] args) {
        int maxSize = 1000;
        SortArray arr;
        arr = new SortArray(maxSize);
//        for (int i = 0; i < maxSize; i++) {
//            long n = (int) (Math.random() * (maxSize - 1)); //random number
//            arr.insert(n);
//        }
        for (int i = maxSize; i > 0 ; i--) {
            arr.insert(i);
        }
        arr.display();
        //arr.bubbleSort();
        //arr.bidirectBubbleSort();
        arr.oddEvenSort();
        arr.display();
    }
}
