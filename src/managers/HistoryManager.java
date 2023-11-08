/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class HistoryManager {

    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;

    public HistoryManager(Scanner scanner) {
        this.scanner = scanner;
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);
        
    }

    public History giveBookToReader(List<Reader> readers, List<Book> books) {
        System.out.println("------------- Give the book to the reader ----------------");
        History history = new History();
        /*
         * 1. Выводим нумерованный список читателей
         * 2. Просим ввести номер читателя
         * 3. получим по индексу читателя из массива читателей
         * 4. Инициируем поле в history.setReader(reader)
         * 5-9. Повторить действия 1-4 с книгой
         * 10. Инициируем дату выдачи книги тукущим временем
         */
        int countReadersInList = readerManager.pirntListReaders(readers);
        System.out.print("Enter number reader: ");
        int readerNumber = InputFromKeyboard.inputNumberFromRange(1, countReadersInList);
        history.setReader(readers.get(readerNumber-1));

        int countBooksInList = bookManager.pirntListBooks(books);
        System.out.print("Enter number book: ");
        int bookNumber = InputFromKeyboard.inputNumberFromRange(1, countBooksInList);
        if(books.get(bookNumber-1).getCount() > 0){
            history.setBook(books.get(bookNumber-1));
            books.get(bookNumber-1).setCount(books.get(bookNumber-1).getCount()-1);
            history.setGiveBookToReaderDate(new GregorianCalendar().getTime());
        }else{
            System.out.println("All books are read");
            return null;
        }
        return history;
    }

    public void returnBook(List<History> histories) {
        System.out.println("-------- Return book to library ---------");
        int countBooksInList;
        if((countBooksInList = this.printListReadingBooks(histories))<1){
            System.out.println("Not books");
            return;
        }
        System.out.print("Enter number book: ");
        int historyNumber = InputFromKeyboard.inputNumberFromRange(1, null);
        if(histories.get(historyNumber-1).getBook().getCount() < histories.get(historyNumber-1).getBook().getQuantity()){
            histories.get(historyNumber-1).setReturnBook(new GregorianCalendar().getTime());
            histories.get(historyNumber-1).getBook().setCount(histories.get(historyNumber-1).getBook().getCount()+1);
            System.out.printf("Book \"%s\" returned%n",histories.get(historyNumber-1).getBook().getTitle());
        }else{
            System.out.println("All books are already in stock"); 
        }
    }

    public  int printListReadingBooks(List<History> histories) {
        int countReadingBooks = 0;
        System.out.println("List reading books:");
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getReturnBook() == null){
                System.out.printf("%d. %s. reading %s %s%n",
                        i+1,
                        histories.get(i).getBook().getTitle(),
                        histories.get(i).getReader().getFirstname(),
                        histories.get(i).getReader().getLastname()
                );
                countReadingBooks++;
            }
        }
        if(countReadingBooks < 1){
            System.out.println("\tNo books to read");
        }
        return countReadingBooks;
    }

    
    
    
}
