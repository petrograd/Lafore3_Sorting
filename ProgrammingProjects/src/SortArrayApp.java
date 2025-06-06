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
    public void biderectBubbleSort() {
        int out;
        for(out = 0; out <= nElems/2; out++) {
            for (int i = 0; i < nElems-1-out; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(i, i+1);
                }
            }
            for (int i = nElems-1-out; i > out ; i--) {
                if (arr[i] < arr[i-1])
                    swap(i, i-1);
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
        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * (maxSize - 1)); //random number
            arr.insert(n);
        }

        arr.display();
        //arr.bubbleSort();
        arr.biderectBubbleSort();
        arr.display();
    }
}
