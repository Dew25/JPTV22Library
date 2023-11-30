/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import facade.ReaderFacade;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class ReaderManager {

    private final Scanner scanner;
    private final ReaderFacade readerFacade;

    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
        this.readerFacade = new ReaderFacade();
    }

    public void createReader() {
        System.out.println(" ----- Add new reader -----");
        Reader reader = new Reader();
        System.out.print("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("Added reader " + reader.toString());
        readerFacade.create(reader);
    }

    public int pirntListReaders() {
        List<Reader> readers = readerFacade.findAll();
        int count = 0;
        System.out.println("List readers: ");
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s. %s. %s%n",
                    readers.get(i).getId(),
                    readers.get(i).getFirstname(),
                    readers.get(i).getLastname(),
                    readers.get(i).getPhone()
            );
            count++;
        }
        return count;
    }

    public Reader getById(int id) {
        return readerFacade.find((long)id);
    }
    
    
}
