/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class EntityManagerSingleton {
    private static final EntityManagerSingleton instance = new EntityManagerSingleton();
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    private EntityManagerSingleton() {
    // Создание EntityManagerFactory (обычно, она создается один раз при запуске приложения)
        this.entityManagerFactory = Persistence.createEntityManagerFactory("JKTV22LibraryPU");

        // Создание EntityManager
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManagerSingleton getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
