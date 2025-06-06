class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        this.a = new long[max];
        nElems = 0;
    }
    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }
    public void display() {
        for (int i = 0; i < nElems; i++) {
            if (i == 0)
                System.out.print(a[i]);
            else
                System.out.print(", " + a[i]);
        }
        System.out.println();
    }
    public void bubbleSort() {
        int out, in;
        for(out = nElems-1; out > 0; out--) {
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1])
                    swap(in, in + 1);

        }
    }
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

}
public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100000;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (int)( Math.random()*(maxSize-1) ); //random number
            arr.insert(n);
      //      arr.insert(i);   //sorted number
        }
//        for (int i = maxSize; i > 0 ; i--) {
//            arr.insert(i);  //reverse sorted
//        }
            long ms = System.currentTimeMillis();
    //    arr.display();
        arr.bubbleSort();
        arr.display();
        System.out.println((System.currentTimeMillis() - ms)/1000 + " sek");

    }
}
