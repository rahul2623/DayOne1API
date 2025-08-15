package Service;

import Entity.JournalEntery;
import Entity.User;
import Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class UserService {
    @Autowired
    UserRepo myuserrepo;


    public void saveData(User data) {
        myuserrepo.save(data);
    }

}
