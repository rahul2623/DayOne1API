package Controller;

import Entity.JournalEntery;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @PostMapping("/")
    public boolean addEntery(@RequestBody JournalEntery data){
    return true;
    }
    @GetMapping("/")
    public JournalEntery getAllEntery(){
        return null;
    }
    @DeleteMapping("/{id}")
    public boolean deletbyId(@PathVariable Long id){
        return true;
    }
    @GetMapping("/id/{id}")
    public JournalEntery getByID(@PathVariable Long id){
        return null;
    }
    @PutMapping("/id/{id}")
    public boolean updatebyId(@PathVariable Long id){
        return true;
    }
}
