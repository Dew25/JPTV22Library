/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Melnikov
 */
public class SaveManager {
    private final String BOOK_FILENAME = "books";
    private final String READER_FILENAME = "readers";
    private final String HISTORIES_FILENAME = "histories";
    public void saveBooks(List<Book> books){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(BOOK_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public List<Book> loadBooks(){
        List<Book> books = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(BOOK_FILENAME);
            ois = new ObjectInputStream(fis);
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return books;
    }
    public void saveReaders(List<Reader> readers){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(READER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public List<Reader> loadReaders(){
        List<Reader> readers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(READER_FILENAME);
            ois = new ObjectInputStream(fis);
            readers = (List<Reader>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return readers;
    }
    public void saveHistories(List<History> histories){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(HISTORIES_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public List<History> loadHistories(){
        List<History> histories = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(HISTORIES_FILENAME);
            ois = new ObjectInputStream(fis);
            histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return histories;
    }
}
