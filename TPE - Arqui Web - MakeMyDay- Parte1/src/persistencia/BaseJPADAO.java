package persistencia;

import javax.persistence.EntityManager;

public class BaseJPADAO<E> implements DAO<E>{

	Class<E> entityClass;
	
	public BaseJPADAO(Class<E> entityClass){
		this.entityClass=entityClass;
	}
	
	@Override
	public E persist(E entity) {
		EntityManager entityManager=EntityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public E findById(int id) {
		EntityManager entityManager=EntityManagerFactory.createEntityManager();
		E entity=entityManager.find(entityClass, id);
		entityManager.close();
		return entity;
	}

}
