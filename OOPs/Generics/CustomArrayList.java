package OOPs.Generics;

import java.util.Arrays;

public class CustomArrayList {
    private final int DEFAULT_SIZE = 10;
    private int[] data;
    private int size = 0;
    
    CustomArrayList() {
        // initializing data array with default size
        this.data = new int[DEFAULT_SIZE];
    }

    // add function will add an element in our CustomArrayList
    public void add(int num){
        if(isFull()){ // checking is our internal array full or not
            // if it is full then we will resize our internal array
            resize();
        }

        // adding the num to the data and after adding to the data, incrementing the size by 1
        data[size++] = num;
    }

    // basically isFull function will check if internal array is full or not
    private boolean isFull(){
        return size == data.length;
    }
    
    // resize will resize the array of about double its size and re-initialize the data with new data (will retain old data too)
    private void resize(){
        int[] new_data = new int[data.length * 2];

        for(int i=0; i<data.length; i++){
            new_data[i] = data[i];
        }

        data = new_data;
    }

    // remove function will just decrement size by 1
    public int remove(){
        return data[--size];
    }

    // get will return the element at specified index
    public int get(int index){
        return data[index];
    }

    // size will return the current size of the data (only till elements)
    public int size(){
        return size;
    }

    // set will just set the value at specified index
    public void set(int index, int value){
        data[index] = value;
    }

    // case out array to String
    public String toString(){
        return Arrays.toString(data);
    }

    // print array in the form of String
    public void print(){
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args){
        CustomArrayList list = new CustomArrayList();

        list.add(2);
        list.add(5);
        list.add(7);

        list.print();

        list.remove();
        list.print();
        list.set(0, 10);

        list.print();

        
    }
}
