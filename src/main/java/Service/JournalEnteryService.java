package Service;

import Entity.JournalEntery;
import Repo.GeneralEneryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEnteryService {
    @Autowired
    private GeneralEneryRepo generalEneryRepo;

    public void saveData(JournalEntery data) {
        generalEneryRepo.save(data);
    }

    public List<JournalEntery> getdata() {
        return generalEneryRepo.findAll();
    }

    public boolean deleteById(String id) {
        try {
            Optional<JournalEntery> journal = generalEneryRepo.findById(id);
            if (journal.isPresent()) {
                generalEneryRepo.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error deleting journal entry: " + e.getMessage());
            return false;
        }
    }

    public JournalEntery getById(String id) {
        Optional<JournalEntery> journal = generalEneryRepo.findById(id);
        return journal.orElse(null);
    }

    public boolean updateById(String id, JournalEntery data) {
        try {
            Optional<JournalEntery> existingJournal = generalEneryRepo.findById(id);
            if (existingJournal.isPresent()) {
                data.setId(id);
                generalEneryRepo.save(data);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error updating journal entry: " + e.getMessage());
            return false;
        }
    }
}
