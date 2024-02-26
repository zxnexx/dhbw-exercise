package de.dhbw.programming.exercise.inheritance.periodic;

import java.util.Objects;

public class Element {
    private String name;
    private String symbol;
    private int ordinal;
    private char shell;
    private int phase;
    private boolean group;  // true = Main-group; false = Side-group

    public Element(final String name, final String symbol, final int ordinal, final char shell, final int phase, final boolean group) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.group = group;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public void setOrdinal(final int ordinal) {
        this.ordinal = ordinal;
    }

    public char getShell() {
        return this.shell;
    }

    public void setShell(final char shell) {
        this.shell = shell;
    }

    public int getPhase() {
        return this.phase;
    }

    public void setPhase(final int phase) {
        this.phase = phase;
    }

    public boolean isGroup() {
        return this.group;
    }

    public void setGroup(final boolean group) {
        this.group = group;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Element element = (Element) o;
        return this.ordinal == element.ordinal && this.shell == element.shell && this.phase == element.phase && this.group == element.group && Objects.equals(this.name, element.name) && Objects.equals(this.symbol, element.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.symbol, this.ordinal, this.shell, this.phase, this.group);
    }

    @Override
    public String
    toString() {
        return "Element{" +
                "name='" + this.name + '\'' +
                ", symbol='" + this.symbol + '\'' +
                ", ordinal=" + this.ordinal +
                ", shell=" + this.shell +
                ", phase=" + this.phase +
                ", group=" + this.group +
                '}';
    }
}
