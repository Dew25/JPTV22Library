/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import facade.AuthorFacade;
import facade.BookFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class BookManager {

    private final Scanner scanner;
    private final BookFacade bookFacade;
    private final AuthorManager authorManager;

    public BookManager(Scanner scanner) {
        this.scanner = scanner;
        this.bookFacade = new BookFacade();
        this.authorManager = new AuthorManager(scanner);
    }

    public void createBook() {
        System.out.println("----- Add new book -----");
        Book book;
        book = new Book();
        System.out.print("Enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter published year: ");
        book.setPublishedYear(InputFromKeyboard.inputNumberFromRange(1800, 2050));
        authorManager.printListAuthors();
        
        System.out.println("Если авторов в списке нет, нажмите 0, если есть - 1");
        int isAuthor = InputFromKeyboard.inputNumberFromRange(0, 1);
        if(isAuthor == 0){
            //добавить автора в базу
        }
        int countAuthors = InputFromKeyboard.inputNumberFromRange(1, 5);
        Integer[] authorsBook = new Integer[5];
        for (int i = 0; i < countAuthors; i++) {
            System.out.println("Выберите номер автора "+i+1);
            authorsBook[i]=InputFromKeyboard.inputNumberFromRange(1, countAuthors);
        }
        List<Author>listAuthorsBook = new ArrayList<>();
        for (int i = 0; i < authorsBook.length; i++) {
            if(authorsBook[i] != 0){
                listAuthorsBook.add(authorManager.findAuthorById((long)authorsBook[i]));
            }
        }
        book.setAuthors(listAuthorsBook);
        System.out.print("Enter quantity copy: ");
        book.setQuantity(InputFromKeyboard.inputNumberFromRange(1, 10));
        book.setCount(book.getQuantity());
        System.out.println("Added book: "+book.toString());
        bookFacade.create(book);
    }

    public int pirntListBooks(List<Book> books) {
        int count = 0;
        System.out.println("List books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. %s. %d. %s. In stock: %d%n",
                    i+1,
                    books.get(i).getTitle(),
                    books.get(i).getPublishedYear(),
                    Arrays.toString(books.get(i).getAuthors().toArray()),
                    books.get(i).getCount()
            );
            count++;
        }
        return count;
    }

    public void addCopyOfExistingBookInLibrary(List<Book> books) {
        this.pirntListBooks(books);
        System.out.println("Enter the book number to add copies: ");
        int bookNumber = InputFromKeyboard.inputNumberFromRange(1, books.size());
        System.out.println("How many copies of the book should I add?: ");
        int copyNumber = InputFromKeyboard.inputNumberFromRange(1, 10);
        books.get(bookNumber-1).setQuantity(books.get(bookNumber-1).getQuantity() + copyNumber);
        books.get(bookNumber-1).setCount(books.get(bookNumber-1).getCount() + copyNumber);
    }
    
}
