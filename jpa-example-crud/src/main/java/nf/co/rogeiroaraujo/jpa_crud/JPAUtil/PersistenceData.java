package nf.co.rogeiroaraujo.jpa_crud.JPAUtil;

import nf.co.rogeiroaraujo.jpa_crud.Interface.Persistence;
import nf.co.rogeiroaraujo.jpa_crud.Model.Animal;

import javax.persistence.EntityManager;

// classe que persiste os dados no banco
public class PersistenceData implements Persistence {

    // criando a instancia do gerenciador de entidades
    private final EntityManager em;

    public PersistenceData(EntityManager em) {
        this.em = em;
    }
    
    public void insert(){
        
        // criação dos objetos o qual serão persistidos
        Animal animal = new Animal("Dog", "Rex");
        Animal animal_2 = new Animal("Bird", "Piu Piu");
        Animal animal_3 = new Animal("Cat", "Tom");

        // abrindo uma nova transaçao com o banco de dados
        em.getTransaction().begin();
        // persistindo os objetos criados anteriormente
        em.persist(animal);
        em.persist(animal_2);
        em.persist(animal_3);
        
        // criando a sincronização dos dados
        em.flush();
        
        // confirmação da persistencia no banco de dados
        em.getTransaction().commit();
    }
}
