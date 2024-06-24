package de.dhbw.programming.secondsemester.datastructures.generictree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericTree<T extends Comparable<T>> {
    private final Node<T> root;
    static Random random = new Random();

    public static void main(final String[] args) {
        final var genericTree = new GenericTree<Integer>();
        for (int i = 0; i < 10; i++) {
            final int randInt = random.nextInt(20);
            System.out.println(randInt);
            genericTree.add(randInt);
        }
        genericTree.traverse();


    }

    public GenericTree() {
        this.root = new Node<>(null, null, null);
    }

    public void add(final T newValue) {
        this.root.add(newValue);
    }

    public List<T> traverse() {
        final List<T> list = new ArrayList<>();
        this.root.traverse(list);
        System.out.println(list);
        return list;
    }
}
