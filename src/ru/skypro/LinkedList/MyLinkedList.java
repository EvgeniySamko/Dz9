package ru.skypro.LinkedList;

public class MyLinkedList extends Node {
    private Node first;
    private Node last;
    private int size;

    public boolean add(Object obj) {
        Node n = new Node();
        if (first == null) {
            n.setPrev(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
        } else {
            n.setPrev(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);
        }
        last = n;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        // получить узел
        Node temp = node(index);

        if (temp != null) {
            Node up = temp.getPrev();
            Node down = temp.getNext();
            up.setNext(down);
            if (down != null) {
                down.setPrev(up);
            }
        }
        size--;
    }

    public Node node(int index) {
        Node temp = null;
        if (first != null) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        return temp;
    }

    public Object get(int index) {
        Node temp = node(index);
        if (temp != null) {
            return temp.getObj();
        } else {
            return null;
        }
    }

    public void add(int index, Object obj) {
        Node temp = node(index);

        Node newNode = new Node();
        newNode.setObj(obj);

        if (temp != null) {
            Node up = temp.getPrev();
            up.setNext(newNode);
            newNode.setPrev(up);

            newNode.setNext(temp);
            temp.setPrev(newNode);
        }
        size++;
    }

    public void set(int index, Object obj) {
        Node temp = node(index);
        if (temp != null) {
            temp.setObj(obj);
        }
    }
    public void show() {
        Node temp = new Node();
        if (first != null) {
            temp = first;
            while (temp != null) {
                System.out.print(temp.getObj() + " ");
                temp = temp.getNext();
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add("Привет");
        list.add("Пока");
        list.add("дтодж");
        list.add("уеу");
        list.add("впавап");
        list.add("пввапв");

        list.add(1, "141516");
        System.out.println(list.get(2));
        list.set(5, "293031");
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println();
        list.show();

    }
}





