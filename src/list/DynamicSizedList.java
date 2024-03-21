package list;
import java.util.Arrays;
public class DynamicSizedList <E>{
    //Generic array
    private E [] data;

    //constructor
    public static final int DEFAULT_CAPACITY =3;

    //Variable to update size
    private int size =0;

    //Constructors to update list
    public DynamicSizedList() {
        this (DEFAULT_CAPACITY);
    }

    //Check index
    public void checkIndex(int i,int n){
        if(i<0||i>=n)
            throw new IndexOutOfBoundsException("Illegal Index: "+i);
    }

    //Constructor with initial capacity
    public DynamicSizedList(int intitialCapacity) {
        if(intitialCapacity <= 0){
            throw new IllegalArgumentException("Invalid initial capacity: "+ intitialCapacity);
        }
        data = (E[]) new Object[intitialCapacity];
    }

    //Method to add
    public void add(E e){
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = e;
    }

    //Method to add to specific index
    public void resize(int newCapacity) {
        data = Arrays.copyOf(data,newCapacity);
    }


    //Method to remove at index i
    public E remove(int i) {
        checkIndex(i, size+1);
        E temp = data[i];
        for(int k=1; k<size-1; k++) {
            data[k] =data[k+1];
        }
        data[size-1]= null;
        size--;

        return temp;
    }

    //Method to return the size
    public int size() {
        return size;
    }

    //Method to check if list is empty
    public boolean isEmpty() {
        return size==0;
    }

    //Method to get element at an index
    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        return data[i];
    }

    //Method to replace at an index and return
    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size);

        E temp = data[i];
        data[i] = e;
        return temp;
    }

    //Method to check if an index contain an element
    public boolean contains(Object item) {
        for(int j=0; j<size-1; j++) {
            if(get(j).equals(item)) {
                return true;
            }
        }
        return false;
    }

    //Method to swap two element at an index
    public E swap(int i, int j) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        checkIndex(j, size);

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data[i];
    }


}
