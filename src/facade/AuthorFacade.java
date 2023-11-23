/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Author;
import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class AuthorFacade {
    EntityManager em;

    public AuthorFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    public void create(Author author){
        em.getTransaction().begin();
            em.persist(author);
        em.getTransaction().commit();
    }
    public void edit(Author author){
        em.getTransaction().begin();
            em.merge(author);
        em.getTransaction().commit();
    }
    public Author find(Long id){
        return em.find(Author.class,id);
    }
    public List<Author> findAll(){
        return em.createQuery("SELECT author FROM Author author").getResultList();
    }
}
