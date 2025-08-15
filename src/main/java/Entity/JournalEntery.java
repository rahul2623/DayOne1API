package Entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "JournalDataBase")
@Getter
@Setter
public class JournalEntery {
    @Id
    private String id;
    @NonNull
    private String title;
    private Date date;
    private String content;
}
