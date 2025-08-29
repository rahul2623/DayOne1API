package Controller;

import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService myservice;

    @PostMapping("/adduser")
    public ResponseEntity<Boolean> adddata(@RequestBody User myuserdata) {
        try {
            myservice.saveData(myuserdata);
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>> getalluser() {
        try {
            List<User> data = myservice.getalluserse();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
        } catch (Exception e) {
            System.out.println("Hello");
            return ResponseEntity.badRequest().body(null);
        }
    }
}
