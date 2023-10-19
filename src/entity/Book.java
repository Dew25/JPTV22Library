/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Melnikov
 */
public class Book {
    private String title;
    private int publishedYear;
    private Author[] authors = new Author[0];

    public Book() {
    }

    public Book(String title, int publishedYear, Author[] authors) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.authors = authors;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + this.publishedYear;
        hash = 71 * hash + Arrays.deepHashCode(this.authors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Arrays.deepEquals(this.authors, other.authors)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "title=" + title 
                + ", publishedYear=" + publishedYear 
                + ", authors=" + Arrays.toString(authors) 
                + '}';
    }

    public void addAuthor(Author author) {
        /*
         * 1. создать копию athors с дополнительной пустой ячейкой
         * 2. добавить в пустую ячейку ссылку на author полученый из параметра
         */
        this.authors = Arrays.copyOf(this.authors, this.authors.length + 1);
        this.authors[this.authors.length-1] = author;
    }
    
    
}
