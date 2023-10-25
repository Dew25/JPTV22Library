/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22library;

import entity.History;
import managers.HistoryManager;
import entity.Book;
import entity.Reader;
import java.util.Arrays;
import managers.BookManager;
import managers.ReaderManager;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class App {
    private final Scanner scanner;
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private HistoryManager historyManager;
    
    public App() {
        this.scanner = new Scanner(System.in);
        this.books = new Book[0];
        this.readers = new Reader[0];
        this.histories = new History[0];
        this.bookManager = new BookManager(scanner);
        this.readerManager = new ReaderManager(scanner);
        this.historyManager = new HistoryManager(scanner);
    }
    
    
    
    
    void run() {
        boolean repeat = true;
        System.out.println("------ Library ------");
        do{
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("2. Add new reader");
            System.out.println("3. Print list books");
            System.out.println("4. Print list readers");
            System.out.println("5. Give the book to the reader");
            System.out.println("6. Return book");
            System.out.println("7. Print list readed books");
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0,7);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    addBookToBooks(bookManager.addBook());
                    break;
                case 2:
                    addReaderToReaders(readerManager.addReader());
                    break;
                case 3:
                    bookManager.pirntListBooks(books);
                    break;
                case 4:
                    readerManager.pirntListReaders(readers);
                    break;
                case 5:
                    addHistoryToHistories(historyManager.giveBookToReader(readers, books));
                    break;
                case 6:
                    historyManager.returnBook(histories);
                    break;
                case 7:
                    historyManager.printListReadingBooks(histories);
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
        }while(repeat);
    }

    private void addBookToBooks(Book book) {
        this.books = Arrays.copyOf(this.books, this.books.length + 1);
        this.books[this.books.length - 1] = book;
    }

    private void addReaderToReaders(Reader reader) {
        this.readers = Arrays.copyOf(this.readers, this.readers.length + 1);
        this.readers[this.readers.length - 1] = reader;
        
    }
    private void addHistoryToHistories(History history) {
        this.histories = Arrays.copyOf(this.histories, this.histories.length + 1);
        this.histories[this.histories.length - 1] = history;
    }

    
    
}