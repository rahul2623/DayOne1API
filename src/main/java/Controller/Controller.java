package Controller;

import Entity.JournalEntery;
import Service.JournalEnteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class Controller {

    @Autowired
    private JournalEnteryService jn;

    // CREATE
    @PostMapping
    public ResponseEntity<Boolean> addEntery(@RequestBody JournalEntery data) {
        try {
            jn.saveData(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<JournalEntery>> getAllEntery() {
        try {
            List<JournalEntery> entries = jn.getdata();
            return ResponseEntity.ok(entries);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // READ BY ID
    @GetMapping("/id/{id}")
    public ResponseEntity<JournalEntery> getByID(@PathVariable String id) {
        JournalEntery entry = jn.getById(id);
        if (entry != null) {
            return ResponseEntity.ok(entry);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // UPDATE
    @PutMapping("/id/{id}")
    public ResponseEntity<Boolean> updatebyId(@PathVariable String id, @RequestBody JournalEntery data) {
        boolean updated = jn.updateById(id, data);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        boolean deleted = jn.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
