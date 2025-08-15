package Controller;

import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {
@Autowired
    UserService myservice;
        @PostMapping("/adduser/")
        ResponseEntity<Boolean> adddata(@RequestBody User myuserdata){
            try{
                myservice.saveData(myuserdata);
                return ResponseEntity.status(HttpStatus.CREATED).body(true);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(false);
            }
        }
}
