/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entity.History;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Melnikov
 */
public class HistoryFacade extends AbstractFacade<History>{
    EntityManager em;

    public HistoryFacade() {
        super(History.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public List<History> findHistoryToReadingBooks() {
        try {
//            return em.createQuery("SELECT history FROM History history WHERE history.returnBook = null")
//                .getResultList();
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<History> criteriaQuery = criteriaBuilder.createQuery(History.class);
            Root<History> historyRoot = criteriaQuery.from(History.class);

            criteriaQuery.select(historyRoot);
            criteriaQuery.where(criteriaBuilder.isNull(historyRoot.get("returnBook")));

            return em.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
