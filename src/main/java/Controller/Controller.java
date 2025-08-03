package Controller;

import Entity.JournalEntery;
import Service.JournalEnteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class Controller {
    @Autowired
    private JournalEnteryService jn;

    @PostMapping()
    public boolean addEntery(@RequestBody JournalEntery data) {
        jn.saveData(data);
        return true;
    }

    @GetMapping()
    public List<JournalEntery> getAllEntery() {
        return jn.getdata();
    }

    @DeleteMapping("/{id}")
    public boolean deletbyId(@PathVariable String id) {
        return jn.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public JournalEntery getByID(@PathVariable String id) {
        return jn.getById(id);
    }

    @PutMapping("/id/{id}")
    public boolean updatebyId(@PathVariable String id, @RequestBody JournalEntery data) {
        return jn.updateById(id, data);
    }
}
