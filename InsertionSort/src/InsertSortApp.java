class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int size) {
        a = new long[size];
        nElems = 0;
    }
    public void insert(long val) {
        a[nElems] = val;
        nElems++;
    }
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
    public void insertionSort() {
        int out, in;
        long temp;
        for(out = 1; out < nElems; out++){
            temp = a[out];
            in = out;
            while (in > 0 && a[in-1] >= temp) {
                a[in] = a[in-1];
                in--;
            }
            a[in] = temp;
        }
    }
}

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        for (int i = 0; i < 20; i++) {
            arr.insert((long) (Math.random()*100));
        }
        arr.display();
        arr.insertionSort();
        arr.display();
    }
}
