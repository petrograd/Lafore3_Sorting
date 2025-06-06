//3.2 method median()
//3.3 method noDups

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
    public long median() {
        int mid = nElems/2;

        if (nElems%2 == 0)
            return ((a[mid] + a[mid-1])/2);
        else return a[mid];
    }
    private long get(int ind) {
        if (ind < nElems)
            return a[ind];
        return -1;
    }
    public static ArrayIns noDups(ArrayIns sendA) {
        ArrayIns b;

        b = new ArrayIns(sendA.nElems);

        int indB = 0, indSen = 0, cnt = 0;

        for (int i = 0; i < sendA.nElems; i++) {
            if (i == 0) {
                b.insert(sendA.get(i));
                continue;
            }
            if (sendA.get(i) == sendA.get(i-1))
                continue;
            else {
                b.insert(sendA.get(i));
            }
        }
        return b;
    }
}

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 1000;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr.insert((long) (Math.random()* (maxSize+1)));
//            arr.insert(i);
        }
//        for (int i = maxSize; i > 0 ; i--) {
//            arr.insert(i);
//        }
//        arr.display();
//        arr.insertionSort();
//        arr.display();

        long ms = System.currentTimeMillis();
        //   arr.display();
        arr.insertionSort();
        arr.display();
        System.out.println((System.currentTimeMillis() - ms)/1000 + " sek");

        System.out.println("Median: " + arr.median());
        ArrayIns arr2 = ArrayIns.noDups(arr);
        arr2.display();

    }
}
