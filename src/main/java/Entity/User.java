package Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "users")
@Data
public class User {
    @Id
private ObjectId id;
    @Indexed(unique = true)
    @NonNull
private String username;
    @NonNull
private String password;
    @DBRef
    private ArrayList<JournalEntery> journalEnteries=new ArrayList<>();
}
