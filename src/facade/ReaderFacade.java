/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class ReaderFacade {
     EntityManager em;

    public ReaderFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    public void create(Reader reader){
        em.getTransaction().begin();
            em.persist(reader);
        em.getTransaction().commit();
    }
    public void edit(Reader reader){
        em.getTransaction().begin();
            em.merge(reader);
        em.getTransaction().commit();
    }
    public Reader find(Long id){
        return em.find(Reader.class,id);
    }
    public List<Reader> findAll(){
        return em.createQuery("SELECT reader FROM Reader reader").getResultList();
    }
}
