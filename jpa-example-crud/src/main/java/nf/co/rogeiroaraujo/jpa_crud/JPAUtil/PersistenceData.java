package nf.co.rogeiroaraujo.jpa_crud.JPAUtil;

import nf.co.rogeiroaraujo.jpa_crud.Interface.Persistence;
import nf.co.rogeiroaraujo.jpa_crud.Model.Animal;

import javax.persistence.EntityManager;

public class PersistenceData implements Persistence {

    private final EntityManager em;

    public PersistenceData(EntityManager em) {
        this.em = em;
    }
    
    public void insert(){
        Animal animal = new Animal("Dog", "Rex");
        Animal animal_2 = new Animal("Bird", "Piu Piu");
        Animal animal_3 = new Animal("Cat", "Tom");

        em.getTransaction().begin();
        em.persist(animal);
        em.persist(animal_2);
        em.persist(animal_3);
        em.getTransaction().commit();
    }
}
