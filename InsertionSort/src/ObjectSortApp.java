class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age  ) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void displayPerson() {
        System.out.print(" Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }
    public String getLastName() {
        return lastName;
    }
}
class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int maxSize) {
        a = new Person[maxSize];
        nElems = 0;
    }
    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }
    public void display() {
        for (int i = 0; i < nElems; i++) {
            a[i].displayPerson();
        }
        System.out.println();
    }
    public void insertionSort() {
        int out, in;
        Person temp;
        for (out = 1; out < nElems; out++) {
            temp = a[out];
            in = out;
            while (in > 0 && (a[in-1].getLastName().compareTo(temp.getLastName()) > 0)) {
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }
    }
}
public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb personsList = new ArrayInOb(maxSize);

        personsList.insert("John", "Elton", 24);
        personsList.insert("Smith", "Lorraine", 37);
        personsList.insert("Yee", "Tom", 43);
        personsList.insert("Adams", "Henry", 63);
        personsList.insert("Hashimoto", "Sato", 21);
        personsList.insert("Stimson", "Henry", 29);
        personsList.insert("Velasquez", "Jose", 72);
        personsList.insert("Lamarque", "Henry", 54);
        personsList.insert("Vang", "Minh", 22);
        personsList.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting: ");
        personsList.display();
        System.out.println("After sorting: ");
        personsList.insertionSort();
        personsList.display();
    }
}
