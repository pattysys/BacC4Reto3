package co.proyecto4.proyecto4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.proyecto4.proyecto4.model.User;
import co.proyecto4.proyecto4.repository.crud.UserCrudRepository;
/**
 *
 * @author PatriciaMunevar
 */
@Repository
/**
 *
 * clase user repository
 */
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    /**
    *
    * metodo para traer todo
    */
       public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
  /**
    *
    * metodo para obtener usuario
    */

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
  /**
    *
    * metodo para crear usuarios
    */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
    *
    * metodo para actualizar usuarios
    */  
    public void update(User user) {
        userCrudRepository.save(user);
    }
   /**
    *
    * metodo para eliminar usuarios
    */   
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
  /**
    *
    * metodo para verificar email
    */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
  /**
    *
    * metodo para autenticar email y password
    */    
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
  /**
    *
    * metodo para ordenar por id
    */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
     
     
}
