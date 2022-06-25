package ru.skypro.ArrayList;

import java.util.Iterator;

public class MyArrayList<E> implements MetodArray<E> {

    private E[] values;

    MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int elemAfterIndex = temp.length - index - 1;
            System.arraycopy
                    (temp, index + 1,
                            values, index,
                            elemAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean set(int index, E e) {
        values[index] = e;

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }


    public static void main(String[] args) {


        MyArrayList<String> str = new MyArrayList<>();

        str.add("Один");
        str.add("Два");
        str.add("Три");
        str.add("Четыре");
        str.add("Пять");


        str.set(2, "замена");

        System.out.println(str.size());
        str.delete(0);

        for (String str1 : str) {
            System.out.println(str1);
        }
        System.out.println();
        System.out.println(str.get(2));
    }
}

