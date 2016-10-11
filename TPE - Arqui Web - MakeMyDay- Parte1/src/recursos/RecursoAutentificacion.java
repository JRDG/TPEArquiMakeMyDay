package recursos;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import entidades.Usuario;
import persistencia.UsuarioDAO;
import recursos.autorizacion.Credencial;
import recursos.autorizacion.TokenHelper;


@Path("/autenticacion")
public class RecursoAutentificacion {
	
		@POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response autenticarUser(Credencial credentials) {
			System.out.println("coso");
	        String username = credentials.getUsername();
	        String password = credentials.getPassword();
	        try {

	            // Authenticate the user using the credentials provided
	            autenticar(username, password);

	            // Issue a token for the user
	            String token = emitirToken(username);

	            // Return the token on the response
	            return Response.ok(token).build();

	        } catch (Exception e) {
	            return Response.status(Response.Status.UNAUTHORIZED).build();
	        }
	        // Authenticate the user, issue a token and return a response
	    }
		

	  	private void autenticar(String username, String password) throws Exception {
	        // Authenticate against a database, LDAP, file or whatever
	        // Throw an Exception if the credentials are invalid
		     Usuario user = new Usuario();
		     user.setNombre(username);
		     user.setPassword(password);
		     user = UsuarioDAO.login(user);
		     if(!user.esValido()){
		    	 throw new RuntimeException();
		     }
		  
	    }
	    private String emitirToken(String userName) {
	        // Issue a token (can be a random String persisted to a database or a JWT token)
	        // The issued token must be associated to a user
	        // Return the issued token

	        String token = TokenHelper.generarToken(userName);
	    	TokenHelper.setToken(token, userName);
	    	return token;
	    }
}
