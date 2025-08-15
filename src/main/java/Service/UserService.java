package Service;

import Entity.JournalEntery;
import Entity.User;
import Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepo myuserrepo;


    public void saveData(User data) {
        myuserrepo.save(data);
    }
    public List<User> getalluserse(){
        return myuserrepo.findAll();
    }

}
