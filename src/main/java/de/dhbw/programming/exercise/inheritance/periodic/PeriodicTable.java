package de.dhbw.programming.exercise.inheritance.periodic;

import java.util.ArrayList;
import java.util.List;

public class PeriodicTable {
    private final List<Element> elements = new ArrayList<>();

    public boolean hasElement(final int ordinal) {
        return this.elements.stream().anyMatch(element -> element.getOrdinal() == ordinal);
    }

    public void addElement(final Element e) {
        if (!this.hasElement(e.getOrdinal())) {
            this.elements.add(e);
        }
    }

    public Element getElement(final int ordinal) {
        return this.elements.stream().filter(element -> element.getOrdinal() == ordinal).findFirst().orElse(null);
    }

    public List<Element> getMetals() {
        final ArrayList<Element> res = new ArrayList<>();
        res.addAll(this.elements);  // copy without ref

        res.removeIf(element -> element.getClass().getName().equals("Metal"));
        return res;
    }

    public List<Element> getElements() {
        return this.elements;
    }
}
