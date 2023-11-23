/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Melnikov
 */
@Entity
public class History implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Book book;
    @OneToOne
    private Reader reader;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date giveBookToReaderDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnBook;

    public History() {
    }

    public History(Book book, Reader reader, Date giveBookToReaderDate, Date returnBook) {
        this.book = book;
        this.reader = reader;
        this.giveBookToReaderDate = giveBookToReaderDate;
        this.returnBook = returnBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getGiveBookToReaderDate() {
        return giveBookToReaderDate;
    }

    public void setGiveBookToReaderDate(Date giveBookToReaderDate) {
        this.giveBookToReaderDate = giveBookToReaderDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.book);
        hash = 17 * hash + Objects.hashCode(this.reader);
        hash = 17 * hash + Objects.hashCode(this.giveBookToReaderDate);
        hash = 17 * hash + Objects.hashCode(this.returnBook);
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
        final History other = (History) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.giveBookToReaderDate, other.giveBookToReaderDate)) {
            return false;
        }
        if (!Objects.equals(this.returnBook, other.returnBook)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String returnBook = "";
        if(returnBook != null){
            returnBook = this.returnBook.toString();
        }
        return "History{" 
                + "book=" + book.getTitle()
                + ", reader=" + reader.getFirstname()
                + " " + reader.getLastname()
                + ", giveBookToReaderDate=" + giveBookToReaderDate 
                + ", returnBook=" + returnBook
                + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
