package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entidades.Usuario;

public class UsuarioDAO extends BaseJPADAO<Usuario> {

	private static UsuarioDAO uDao;

	private UsuarioDAO() {
		super(Usuario.class);
	}

	public static UsuarioDAO getInstance() {
		if (uDao == null)
			uDao = new UsuarioDAO();
		return uDao;
	}

	public static Usuario login(Usuario usuario) {
		EntityManager em = EntityManagerFactory.createEntityManager();
		Usuario usuarioBD = new Usuario();
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.nombre = ?1 AND u.password = ?2 ";
			Query query = em.createQuery(jpql, Usuario.class);
			query.setParameter(1, usuario.getNombre());
			query.setParameter(2, usuario.getPassword());
			usuarioBD = (Usuario) query.getSingleResult();
			usuarioBD.setEsValido(true);
		} catch (NoResultException e) {
			usuario.setEsValido(false);
		} catch (Exception e) {
			usuario.setEsValido(false);
		} finally {
			em.close();
		}
		return usuarioBD;
	}
}
