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

        //instacia o EntityManager
        EntityManager em = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();

        // instancia a classe de persistencia
        new PersistenceData(em).insert();

        // exibe (select) todas as informações da tabela do banco de dados
        allAnimals(em);
    }
    
    // metodo que busca todas as informações no banco de dados
    private static void allAnimals(EntityManager em) {
        // define a consulta JPQL
        String sql = "SELECT a FROM Animal a";
        // define o tipo de consulta, e o tipo
        TypedQuery<Animal> query = em.createQuery(sql, Animal.class);
        // define o tipo de retorno da consulta
        List<Animal> resultList = query.getResultList();
        
        // imprime o nome de todos os animais selecionados
        forEach(resultList);
    }

    private static void forEach(List<Animal> resultList) {
        resultList.forEach(
                p -> System.out.println(p.getNome())
        );
    }
}
