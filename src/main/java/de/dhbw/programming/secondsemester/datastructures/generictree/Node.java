package de.dhbw.programming.secondsemester.datastructures.generictree;

import java.util.List;
import java.util.Objects;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(final T value, final Node<T> left, final Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    void add(final T newValue) {
        if (this.getValue() == null) {
            this.setValue(newValue);
        } else {
            final int compRes = newValue.compareTo(this.getValue());
            if (compRes < 0) { // less than
                if (this.left == null) {
                    this.left = new Node<>(null, null, null);
                }
                this.left.add(newValue);
            } else if (compRes > 0) { // greater than
                if (this.right == null) {
                    this.right = new Node<>(null, null, null);
                }
                this.right.add(newValue);
            } else {
            }  // == 0 -> duplicate, do not add
        }
    }

    void traverse(final List<T> list) {
        // in order -> left self right
        if (this.value == null) {
            return;
        } else {
            if (this.left != null) {
                this.left.traverse(list);
            }
            list.add(this.value);
            if (this.right != null) {
                this.right.traverse(list);
            }
        }
    }

    T getValue() {
        return this.value;
    }

    void setValue(final T value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Node<?> node = (Node<?>) o;
        return Objects.equals(this.value, node.value) && Objects.equals(this.left, node.left) && Objects.equals(this.right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.left, this.right);
    }
}
