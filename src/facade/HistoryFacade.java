/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entity.Book;
import entity.History;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class HistoryFacade {
    EntityManager em;

    public HistoryFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    public void create(History history){
        em.getTransaction().begin();
            em.persist(history);
        em.getTransaction().commit();
    }
    public void edit(History history){
        em.getTransaction().begin();
            em.merge(history);
        em.getTransaction().commit();
    }
    public History find(Long id){
        return em.find(History.class,id);
    }
    public List<History> findAll(){
        return em.createQuery("SELECT history FROM History history").getResultList();
    }

    public List<History> findHistoryToReadingBooks() {
        try {
            return em.createQuery("SELECT history FROM History history WHERE history.returnBook = null")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
