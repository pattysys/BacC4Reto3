package co.proyecto4.proyecto4.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.proyecto4.proyecto4.model.User;
import co.proyecto4.proyecto4.service.UserService;

/**
 *
 * @author PatriciaMunevar
 */
@RestController
@RequestMapping("/api/user")

/**
 *
 * Clase publica Usercontroller
 */
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *
     * Hacer llamados get
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     *
     * peticion new
     */
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
            return userService.getUser(id);
    }

    /**
     *
     * peticion new
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    /**
     *
     * clase update
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     *
     * clase traer especifico
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /**
     *
     * clase autenticar usuario
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     *
     * clase verificar email
     */
      @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }

}


