/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import facade.HistoryFacade;
import facade.ReaderFacade;
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
    private final HistoryFacade historyFacade;
   

    public HistoryManager(Scanner scanner) {
        this.scanner = scanner;
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);
        this.historyFacade = new HistoryFacade();
        
    }

    public void giveBookToReader() {
        System.out.println("------------- Give the book to the reader ----------------");
        History history = new History();
        readerManager.pirntListReaders();
        System.out.print("Enter number reader: ");
        int readerNumber = InputFromKeyboard.inputNumberFromRange(1, null);
        history.setReader(readerManager.getById(readerNumber));
        bookManager.pirntListBooks();
        System.out.print("Enter number book: ");
        int bookId = InputFromKeyboard.inputNumberFromRange(1, null);
        Book book = bookManager.getById(bookId);
        if(book.getCount() > 0){
            history.setBook(bookManager.getById(bookId));
            book.setCount(book.getCount()-1);
            bookManager.update(book);
            history.setGiveBookToReaderDate(new GregorianCalendar().getTime());
            historyFacade.create(history);
        }else{
            System.out.println("Все экземпляры книги на руках");
        }
    }

    public void returnBook() {
        System.out.println("-------- Return book to library ---------");
        
        if(this.printListReadingBooks()<1){
            System.out.println("Список пуст");
            return;
        }
        System.out.print("Enter number book: ");
        int historyNumber = InputFromKeyboard.inputNumberFromRange(1, null);
        History history = historyFacade.find((long)historyNumber);
        if(history.getBook().getCount() < history.getBook().getQuantity()){
            history.setReturnBook(new GregorianCalendar().getTime());
            history.getBook().setCount(history.getBook().getCount()+1);
            System.out.printf("Книга \"%s\" возвращена%n",history.getBook().getTitle());
        }else{
            System.out.println("Все экземпляры книги в библотеке"); 
        }
    }

    public int printListReadingBooks() {
        List<History> historiesToReadigBooks = historyFacade.findHistoryToReadingBooks();
        System.out.println("List reading books:");
        for (int i = 0; i < historiesToReadigBooks.size(); i++) {
            System.out.printf("%d. %s. reading %s %s%n",
                    i+1,
                    historiesToReadigBooks.get(i).getBook().getTitle(),
                    historiesToReadigBooks.get(i).getReader().getFirstname(),
                    historiesToReadigBooks.get(i).getReader().getLastname()
            );
        }
        return historiesToReadigBooks.size();
    }
    
}
