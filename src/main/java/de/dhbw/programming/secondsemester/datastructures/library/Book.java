package de.dhbw.programming.secondsemester.datastructures.library;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;

    public Book(final String title, final String author, final int year, final String publisher) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Book book = (Book) o;
        return this.year == book.year && Objects.equals(this.title, book.title) && Objects.equals(this.author, book.author) && Objects.equals(this.publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.author, this.year, this.publisher);
    }
}
