package nf.co.rogerio.jpa;

import javax.persistence.EntityManager;

import nf.co.rogerio.jpa.entity.Student;
import nf.co.rogerio.jpa.util.JPAUtil;

public class App {
	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Student student = new Student(
				"Rogério",
				"Araújo",
				"rogerio@mail.com"
		);

		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

		JPAUtil.shutdown();
	}

}
