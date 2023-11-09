/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Melnikov
 */
public class Book implements Serializable{
    private String title;
    private int publishedYear;
    private Author[] authors = new Author[0];
    private int quantity; //Всего закупленных в библиотеку экземпляров
    private int count; //экземпляров в наличии.

    public Book() {
    }

    public Book(String title, int publishedYear, int quantity, int count) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.quantity = quantity;
        this.count = count;
    }

    
    @Override
    public String toString() {
        return "Book{" 
                + "title=" + title 
                + ", publishedYear=" + publishedYear 
                + ", authors=" + Arrays.toString(authors) 
                + ", quantity=" + quantity
                + ", count=" + count
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + this.publishedYear;
        hash = 53 * hash + Arrays.deepHashCode(this.authors);
        hash = 53 * hash + this.quantity;
        //hash = 53 * hash + this.count;
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
        if (this.quantity != other.quantity) {
            return false;
        }
//        if (this.count != other.count) {
//            return false;
//        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Arrays.deepEquals(this.authors, other.authors);
    }

    
    
    
}
