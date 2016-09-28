package persistencia;

public interface DAO<E> {
	E persist(E entity);
    E findById(int id);
}
