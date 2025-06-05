class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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
    public void selectSort() {
        int out, in;
        for(out = 0; out < nElems-1; out++) {
            int minInd = out;
            for (in = out+1; in < nElems; in++)
                if (a[minInd] > a[in])
                    minInd = in;
            swap(out, minInd);
        }

    }
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

}


public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100000;
        ArraySel arr;
        arr = new ArraySel(maxSize);
        for (int i = 0; i < maxSize; i++) {
            //arr.insert((int)(Math.random()*100)+1);
            arr.insert(i);
        }
//        for (int i = maxSize; i > 0 ; i--) {
//            arr.insert(i);
//        }
//        arr.display();
//        arr.selectSort();
//        arr.display();
        long ms = System.currentTimeMillis();
        //   arr.display();
        arr.selectSort();
        //   arr.display();
        System.out.println((System.currentTimeMillis() - ms)/1000 + " sek");
    }
}
