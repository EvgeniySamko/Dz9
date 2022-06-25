package ru.skypro.ArrayList;

public interface MetodArray<E> extends Iterable<E> {
    boolean add(E e);

    void delete(int index);

    E get(int index);

    int size();

    boolean set(int index, E e);


}
