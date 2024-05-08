package de.dhbw.programming.firstsemester.inheritance.periodic;

public class Main {
    public static void main(final String[] args) {
        final var periodicTable = new PeriodicTable();

        periodicTable.addElement(new Element(
                "Hydrogen", "H", 1, 'K', 3, true)
        );
        periodicTable.addElement(new Element(
                "Helium", "He", 2, 'K', 3, true)
        );
        periodicTable.addElement(new Metal(
                "Sodium", "Na", 11, 'M', 1, true, false, 21 * Math.pow(10, 6))
        );
        periodicTable.addElement(new Metal(
                "Iron", "Fe", 26, 'N', 1, false, false, 10.02 * Math.pow(10, 6))
        );
        periodicTable.addElement(new Metal(
                "Germanium", "Ge", 32, 'N', 1, false, true, 1.45 * Math.pow(10, 6))
        );
        periodicTable.addElement(new Element(
                "Bromine", "Br", 35, 'N', 2, true)
        );
        periodicTable.addElement(new Metal(
                "Tellurium", "Te", 52, 'O', 1, true, true, 0.005)
        );
        periodicTable.addElement(new Metal(
                "Gold", "Au", 79, 'P', 1, false, false, 44.0 * Math.pow(10, 6))
        );

        for (final Element e : periodicTable.getElements()) {
            System.out.println(e);
        }

        final var m = periodicTable.getMetals();
        System.out.printf("METALS: %s%n", m);
    }
}
