package de.dhbw.programming.secondsemester.enums.months;

public enum Month {
    JANUARY(31, "Hartung, Eismond"),
    FEBRUARY(28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
    MARCH(31, "Lenzing, Lenzmond"),
    APRIL(30, "Launing, Ostermond"),
    MAY(31, "Winnemond, Blumenmond"),
    JUNE(30, "Brachet, Brachmond"),
    JULY(31, "Heuert, Heumond"),
    AUGUST(31, "Ernting, Erntemond, Bisemond"),
    SEPTEMBER(30, "Scheiding, Herbstmond"),
    OCTOBER(31, "Gilbhart, Gilbhard, Weinmond"),
    NOVEMBER(30, "Nebelung, Windmond, Wintermond"),
    DECEMBER(31, "Julmond, Heilmond, Christmond, Dustermond");

    private final String oldGermanNames;
    private final int days;

    Month(final int days, final String oGN) {
        this.days = days;
        this.oldGermanNames = oGN;
    }

    public String getOldGermanNames() {
        return this.oldGermanNames;
    }
}
