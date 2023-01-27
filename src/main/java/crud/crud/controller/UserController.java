package crud.crud.controller;

import crud.crud.dto.UserDTO;
import crud.crud.entity.Users;
import crud.crud.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("all")
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> listUsers = userService.getAll();
        return ResponseEntity.ok(listUsers);
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") String id){
        System.out.println("id del ususario aqui => " + id);
        return  ResponseEntity.ok(userService.getOne(id));
    }

    @PostMapping("")
    public ResponseEntity<Users> createUser(@RequestBody UserDTO user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> updateUsers(@RequestBody UserDTO user, @PathVariable("id") String id){
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
