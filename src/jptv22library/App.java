/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22library;

import managers.HistoryManager;
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
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    
    public App() {
        this.scanner = new Scanner(System.in);
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
            System.out.println("8. Add a copy of an existing book in the library");
            
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0,8);
            System.out.printf("Selected task %d, continue? (y/n): ",task);
            String continueRun = InputFromKeyboard.inputSymbolYesOrNo();
            if(continueRun.equals("n")){
                continue;
            }
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    bookManager.createBook();
                    break;
                case 2:
                    readerManager.createReader();
                    break;
                case 3:
                    bookManager.pirntListBooks();
                    break;
                case 4:
                    readerManager.pirntListReaders();
                    break;
                case 5:
                    historyManager.giveBookToReader();
                    break;
                case 6:
                    historyManager.returnBook();
                    break;
                case 7:
                    historyManager.printListReadingBooks();
                    break;
                case 8:
                    bookManager.addCopyOfExistingBookInLibrary();
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
            System.out.println("-----------------------------");
        }while(repeat);
        System.out.println("Exit. By-by!");
    }

   
    
}
