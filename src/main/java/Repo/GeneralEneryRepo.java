package Repo;

import Entity.JournalEntery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneralEneryRepo extends MongoRepository<JournalEntery,Long> {
}
