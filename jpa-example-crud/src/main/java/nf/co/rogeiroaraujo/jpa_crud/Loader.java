package nf.co.rogeiroaraujo.jpa_crud;

import nf.co.rogeiroaraujo.jpa_crud.JPAUtil.PersistenceData;
import nf.co.rogeiroaraujo.jpa_crud.Model.Animal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Loader {

    public static void main(String[] args) {
//        final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_HIBERNATE";
        final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_ECLIPSE";

        EntityManager em = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();

        new PersistenceData(em).insert();

        allAnimals(em);
    }
    
    private static void allAnimals(EntityManager em) {
        String sql = "SELECT a FROM Animal a";
        TypedQuery<Animal> query = em.createQuery(sql, Animal.class);
        List<Animal> resultList = query.getResultList();

        forEach(resultList);
    }

    private static void forEach(List<Animal> resultList) {
        resultList.forEach(
                p -> System.out.println(p.getNome())
        );
    }
}
